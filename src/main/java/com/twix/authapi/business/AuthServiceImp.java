package com.twix.authapi.business;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@Slf4j
public class AuthServiceImp implements AuthService{
    //private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AccessTokenEncoder accessTokenEncoder;
    @Override
    public String login(String name,String password){
        UserSharable user = UserSharable.builder().build();

//        try{
//            user = findUser(name);
//        }catch (NullPointerException e){
//            throw new UserNotExistException("User with name " + name + " does not exist.");
//        }
//
//        if (!matchesPassword(password, user.getPassword())) {
//            throw new InvalidCredentialsException("User with given credentials does not exist.");
//        }

        return generateAccessToken(user);
    }
    private boolean matchesPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
//    private UserEntity findUser(String name){
//        return userRepository.findByUserName(name);
//    }
    private String generateAccessToken(UserSharable user) {
        return accessTokenEncoder.encode(
                AccessToken.builder()
                        .subject(user.getUserName())
                        .userId(user.getId())
                        .build());
    }
}
