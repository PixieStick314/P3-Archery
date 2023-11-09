package P3.Archery.util;/*
package P3.Archery.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.oauth2Login()
                .and().build();
    }
}
*/

import P3.Archery.entity.User;
import P3.Archery.service.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;
import P3.Archery.repository.UserRepository;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {
    private final UserService userService;

    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

    }


    @Override
    public User authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new Exception("User not found with email: " + email);
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Authentication failed. Invalid password.");
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        //  Set auth object in security context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //  returns user found with findByEmail
        return user;
    }
}