package ru.netology.cloudservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.cloudservice.models.AuthRequest;
import ru.netology.cloudservice.models.AuthResponse;
import ru.netology.cloudservice.security.JwtTokenService;
import ru.netology.cloudservice.service.UserService;

import java.util.Base64;

@RestController
@AllArgsConstructor
public class AuthController {

    @Autowired
    private final JwtTokenService jwtTokenService;

    @Autowired
    private final UserService userService;


    @PostMapping(value = "/login")
    public ResponseEntity<?> createAuthToken(@RequestBody AuthRequest authRequest) {
        final UserDetails userDetails = userService.getUserByLogin(authRequest.getLogin());
        if (userDetails != null) {
            Base64.Decoder decoder = Base64.getDecoder();
            var name = userDetails.getUsername();
            var pass = new String(decoder.decode(userDetails.getPassword()));
            if (name.equals(authRequest.getLogin()) && pass.equals(authRequest.getPassword())) {
                final String token = jwtTokenService.generateToken(userDetails);
                userService.addTokenToUser(authRequest.getLogin(), token);
                return ResponseEntity.status(HttpStatus.OK).body(AuthResponse.builder().token(token).build());
            }
        }
        return ResponseEntity.status(400).body("Bad credentials");
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("Auth-Token") String token) {
        userService.logoutUser(token);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
