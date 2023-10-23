//package ru.netology.cloudservice.configs;
//
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import ru.netology.cloudservice.repository.UserRepository;
//
//@Configuration
//@AllArgsConstructor
//public class ApplicationConfig {
//
//    private final UserRepository repository;
////
////    private  UserDetailsService userDetailsService;
////
////    @Autowired
////    public void setUserDetailsService (UserDetailsService userDetailsService) {
////        this.userDetailsService = userDetailsService;
////    }
//
//    @Bean
//    public UserDetailsService userDetailsService () {
//        return username -> (UserDetails) repository.findByLogin(username);
//    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider () {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailsService);
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager (AuthenticationConfiguration configuration) throws  Exception {
//        return configuration.getAuthenticationManager();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder () {
//        return new BCryptPasswordEncoder();
//    }
//}
