package P3.Archery.auth;

import P3.Archery.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    public static final String[] ENDPOINTS_WHITELIST = {
            "/user/login",
            "/user/register",
            //TODO: Remove this in prod, this removes auth for all endpoints
            "/**"
    };

    public static final String[] ENDPOINTS_ADMIN = {
            "/user/update/**",
            "/event/create"
    };

    private final UserService userService;
    private final JwtAuthFilter jwtAuthFilter;

    public SecurityConfig(UserService userService, JwtAuthFilter jwtAuthFilter) {
        this.userService = userService;
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder passwordEncoder) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(passwordEncoder);
        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request ->
                request.requestMatchers(ENDPOINTS_WHITELIST).permitAll()
                        .anyRequest().authenticated())
                //Cross site request forgery is disabled lmao, no one hopefully cares that much about spoofing archery club requests (I hope)
                .csrf(csrf -> csrf.disable())
                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                //Technically, this makes it so that any route accessed outside the whitelisted routes is authenticated if someone has a valid token, this should be moved to a second filter
                //Since there's no reason to automatically give auth to routes that aren't protected anyway
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);



/*
        http.csrf().disable()
                .authorizeRequests()
                .requestMatchers("/user/login").permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
*/

        return http.build();
    }

    @Bean
    public SecurityFilterChain adminFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(request -> request.requestMatchers(ENDPOINTS_ADMIN).hasRole("ADMIN").anyRequest().authenticated());

        return http.build();
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
