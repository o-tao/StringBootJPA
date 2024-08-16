package com.app.controller;

import com.app.entity.UserEntity;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // 검색
    @GetMapping("/")
    public UserEntity home() {
        return userService.findByUserNm();
//        return userService.findByUserNmAndUserPwd();
    }

    // like 검색
//    @GetMapping("/")
//    public List<UserEntity> home() {
////        return userService.findByUserNmLike();
////        return userService.findByUserNmStartingWith();
////        return userService.findByUserNmEndingWith();
////        return userService.findByUserNmContaining();
//    }
}
