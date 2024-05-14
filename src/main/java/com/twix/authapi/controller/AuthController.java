package com.twix.authapi.controller;

import com.twix.authapi.controller.dto.LoginUserRequest;
import com.twix.authapi.controller.dto.LoginUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {
    //
//    @PostMapping("/save")
//    public ResponseEntity<CreateUserResponse> createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
//        Employee employee = Employee.builder()
//                .name(createUserRequest.getName())
//                .lastName(createUserRequest.getLastName())
//                .email(createUserRequest.getEmail())
//                .build();
//
//        employee.setRoles(Set.of(
//                EmployeeRole.builder()
//                        .employee(employee)
//                        .role(RoleEnum.NONE)
//                        .build()));
//
//
//        User user = User.builder()
//                .userName(createUserRequest.getUserName())
//                .password(createUserRequest.getPassword())
//                .employee(employee)
//                .build();
//
//        User responseEntity = createUserUseCase.createUser(user);
//        CreateUserResponse response = UserConverter.userToCreateUserResponse(responseEntity);
//
//        return  ResponseEntity.status(HttpStatus.CREATED).body(response);
//    }
    @PostMapping("/login")
    public ResponseEntity<LoginUserResponse> canLogin(@RequestBody @Valid LoginUserRequest loginUserRequest) {
//        String responseString = loginUserUseCase.loginUser(loginUserRequest.getName(),loginUserRequest.getPassword());
//        User loggedUser = getUserUseCase.getUserByName(loginUserRequest.getName());
//        LoginUserResponse response = LoginUserResponse.builder()
//                .accessToken(responseString)
//                .userName(loggedUser.getUserName())
//                .roles((loggedUser.getEmployee().getRoles().stream().map(EmployeeRole::getRole).toList().toString()))
//                .build();

        return ResponseEntity.ok(null);
    }
}
