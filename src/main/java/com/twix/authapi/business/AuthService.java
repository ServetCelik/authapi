package com.twix.authapi.business;

public interface AuthService {

    String generateAccessToken(UserSharable user);
    boolean isValid(String token);
}
