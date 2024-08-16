package com.app.service;

import com.app.entity.UserEntity;
import com.app.repository.UserEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    public void run() {
        log.info("UserService Run!");
//        insert(); // 저장
//        select(); // 조회
//        update(); // 업데이트
//        delete(); // 삭제
    }

    // 저장
    @Transactional
    protected void insert() {
        UserEntity user = new UserEntity();
        user.setUserNm("팔봉");
        user.setUserPwd("1");

        userEntityRepository.save(user);
    }

    // 조회
    private void select() {
        UserEntity user = userEntityRepository.findById(4).orElseThrow();
        log.info("User : {}", user);
    }

    // 수정
    @Transactional // 휘발성으로 날라가지 않게함
    protected void update() {
        UserEntity user = userEntityRepository.findById(4).orElseThrow();
        user.setUserNm("오팔봉");
    }

    private void delete() {
        UserEntity user = userEntityRepository.findById(4).orElseThrow();
        userEntityRepository.delete(user);
    }

    // 이름 검색
    public UserEntity findByUserNm() {
        return userEntityRepository.findByUserNm("고길동").orElseThrow();
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
