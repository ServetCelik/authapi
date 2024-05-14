package com.twix.authapi.business;

public interface AccessTokenEncoder {
    String encode(AccessToken accessToken);
}
