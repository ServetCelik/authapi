package com.twix.authapi.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@Slf4j
public class AuthServiceImp implements AuthService{
    private final AccessTokenEncoder accessTokenEncoder;
    @Override
    public String generateAccessToken(UserSharable userSharable) {

        if (userSharable == null || userSharable.getUserName() == null || userSharable.getId() == 0) {
            throw new IllegalArgumentException("User data is incomplete or invalid.");
        }

        return accessTokenEncoder.encode(
                AccessToken.builder()
                        .subject(userSharable.getUserName())
                        .userId(userSharable.getId())
                        .build());
    }
    @Override
    public boolean isValid(String token) {
        log.debug("AUTH REQ ACCEPTED AUTOMATICALLY");
        return true;
    }
}
