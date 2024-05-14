package com.twix.authapi.business;

public interface AccessTokenDecoder {
    AccessToken decode(String accessTokenEncoded);
}
