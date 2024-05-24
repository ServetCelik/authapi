package com.twix.authapi.controller;

import com.twix.authapi.business.AuthService;
import com.twix.authapi.business.UserSharable;
import com.twix.authapi.configuration.security.isauthenticated.IsAuthenticated;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

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
    public void validate(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_OK);
    }


//        String authToken = request.getHeader("Authorization");
//        if (authToken == null || !authService.isValid(authToken)) {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        } else {
//            response.setStatus(HttpServletResponse.SC_OK);
//        }

}
