package ru.netology.cloudservice.security;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthFilter jwtAuthFilter;

//    private final UserDetailsService userDetailsService;
//    private final DaoAuthenticationProvider daoAuthenticationProvider;

//    public SecurityConfiguration(JwtAuthFilter jwtAuthenticationFilter,
//                          UserDetailsService userDetailsService,
//                          DaoAuthenticationProvider daoAuthenticationProvider) {
//
//        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
//        this.userDetailsService = userDetailsService;
//        this.daoAuthenticationProvider = daoAuthenticationProvider;
//    }

//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
//        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//        return daoAuthenticationProvider;
//    }

//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//
//        httpSecurity.headers().frameOptions().disable();
//
//        httpSecurity.cors().and().csrf().disable();
//        //@formatter:off
//        httpSecurity
//                .authorizeHttpRequests()
//                .requestMatchers("/login").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .exceptionHandling()
//                .authenticationEntryPoint(
//                        (request, response, authException)
//                                -> response.sendError(
//                                HttpServletResponse.SC_UNAUTHORIZED,
//                                authException.getLocalizedMessage()
//                        )
//                )
//                .and()
//                .authenticationProvider(daoAuthenticationProvider())
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//        //@formatter:on
//        return httpSecurity.build();
//    }


//    private final JwtAuthFilter jwtAuthFilter;
//
//
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        return http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests(
                        auth -> auth.requestMatchers("/login").permitAll()
                                .requestMatchers("/logout").permitAll()
                                .anyRequest().authenticated()
                                .and()
                                .addFilterAfter(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                ).build();
    }

//                .csrf(csrf -> csrf.disable())
//                .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests(auth ->
//                        auth.requestMatchers("/login").permitAll()
//                                .anyRequest().authenticated()
//                );
//        http.authenticationProvider(authenticationProvider());
//
//        http.addFilterBefore(JwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//    }
}
