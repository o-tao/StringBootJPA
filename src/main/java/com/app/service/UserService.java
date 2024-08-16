package com.app.service;

import com.app.entity.UserEntity;
import com.app.repository.UserEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    // 이름 검색
    public UserEntity findByUserNm() {
        return userEntityRepository.findByUserNm("오팔봉").orElseThrow();
    }

    // 비밀번호 검색
    public UserEntity findByUserNmAndUserPwd() {
        return userEntityRepository.findByUserNmAndUserPwd("오팔봉", "1234").orElseThrow();
    }

    // like 검색
    public List<UserEntity> findByUserNmLike() {
        String userNm = "팔봉";
        return userEntityRepository.findByUserNmLike("%" + userNm + "%");
    }

    // StartingWith 검색 : 팔봉%
    public List<UserEntity> findByUserNmStartingWith() {
        return userEntityRepository.findByUserNmStartingWith("팔봉");
    }

    // EndingWith 검색 : %팔봉
    public List<UserEntity> findByUserNmEndingWith() {
        return userEntityRepository.findByUserNmEndingWith("팔봉");
    }

    // Containing 검색 : %팔봉%
    public List<UserEntity> findByUserNmContaining() {
        return userEntityRepository.findByUserNmContaining("팔봉");
    }
}
