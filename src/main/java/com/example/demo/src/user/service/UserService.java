package com.example.demo.src.user.service;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponseStatus;
import com.example.demo.src.user.dto.SignUpDto;
import com.example.demo.src.user.entity.UserEntity;
import com.example.demo.src.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    public void signUp(SignUpDto signUpDto) throws BaseException {

        if(!(signUpDto.getPassword().equals(signUpDto.getConfirmedPassword()))){
            throw new BaseException(BaseResponseStatus.NOT_EQUAL_PASSWORD);
        }

        UserEntity user = new UserEntity(signUpDto);

        userRepository.save(user);
    }
}
