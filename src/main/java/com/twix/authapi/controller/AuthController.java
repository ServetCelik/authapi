package com.twix.authapi.controller;

import com.twix.authapi.business.AuthService;
import com.twix.authapi.business.UserSharable;
import com.twix.authapi.configuration.security.isauthenticated.IsAuthenticated;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {
 private final AuthService authService;

    @PostMapping("/generateAccessToken")
    public ResponseEntity<String> generateAccessToken(@RequestBody UserSharable userSharable) {
        try {
            String token = authService.generateAccessToken(userSharable);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            // Log the exception and return an appropriate error response
            return ResponseEntity.badRequest().body("Error generating access token: " + e.getMessage());
        }
    }
    @IsAuthenticated
    @GetMapping("/validate")
    public ResponseEntity<?> validateRequest() {return ResponseEntity.ok().build();}
//        String authToken = request.getHeader("Authorization");
//        if (authToken == null || !authService.isValid(authToken)) {
//            // If the token is not valid, return a 401 Unauthorized response
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
        // If the token is valid, return a 200 OK response

}
