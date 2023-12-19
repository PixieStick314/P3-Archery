/*
package P3.Archery.auth;

import P3.Archery.model.User;
import P3.Archery.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class AdminFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final ObjectMapper mapper;

    private final UserService userService;

    public AdminFilter(JwtUtil jwtUtil, ObjectMapper mapper, UserService userService) {
        this.jwtUtil = jwtUtil;
        this.mapper = mapper;
        this.userService = userService;
    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        Map<String, Object> errorDetails = new HashMap<>();

        try {
            String accessToken = jwtUtil.resolveToken(request);
            if (accessToken == null) {
                errorDetails.put("message", "Authorization Error");
                errorDetails.put("details", "You must be an admin to perform this request");
                response.setStatus(HttpStatus.FORBIDDEN.value());
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);

                mapper.writeValue(response.getWriter(), errorDetails);
                return;
            }
            Claims claims = jwtUtil.resolveClaims(request);

            if (claims != null & jwtUtil.validateClaims(claims)) {
                String email = claims.getSubject();
                User user = userService.getByEmail(email);
                System.out.println("Roles: " + user.getRoles());
                if (user.getRoles().contains(User.Role.ADMIN)) {
                    System.out.println("User is an admin");
                    Authentication authentication =
                            new UsernamePasswordAuthenticationToken(email,"",new ArrayList<>());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                } else {
                    errorDetails.put("message", "Authorization Error");
                    errorDetails.put("details", "You must be an admin to perform this request");
                    response.setStatus(HttpStatus.FORBIDDEN.value());
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);

                    mapper.writeValue(response.getWriter(), errorDetails);
                    return;
                }
            }
        } catch (Exception e) {
            errorDetails.put("message", "Unknown error");
            errorDetails.put("details", "Please consult a site admin");
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);

            mapper.writeValue(response.getWriter(), errorDetails);

        }

        chain.doFilter(request, response);
    }

}
*/
