package com.example.demo.src.user.service;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponseStatus;
import com.example.demo.src.user.dto.LoginDto;
import com.example.demo.src.user.dto.IsLoginDto;
import com.example.demo.src.user.dto.SignUpDto;
import com.example.demo.src.user.entity.UserEntity;
import com.example.demo.src.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    public void signUp(SignUpDto signUpDto) throws BaseException {
        System.out.print("2");

        UserEntity user = new UserEntity(signUpDto);
        System.out.print("3");

        userRepository.save(user);
    }

    public IsLoginDto login(LoginDto loginDto) throws BaseException {
        Optional<UserEntity> user = userRepository.findUserEntityByUsernameAndPassword(
                loginDto.getUsername(), loginDto.getPassword());

        if (user.isPresent()) {

            return new IsLoginDto(loginDto.getUsername(), true);
        } else {
            return new IsLoginDto(loginDto.getUsername(), false);
        }
    }


}
