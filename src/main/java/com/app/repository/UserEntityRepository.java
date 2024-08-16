package com.app.repository;

import com.app.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {

    // 1. 이름 검색 조건: (해당 사용자 이름 조회) where user_nm = '고길동'
    public Optional<UserEntity> findByUserNm(String userNm);

    // 2. 이름과 비밀번호 검색 조건: where user_nm = '고길동' and user_pwd = '1234'
    public Optional<UserEntity> findByUserNmAndUserPwd(String userNm, String userPwd);

    // 3. 이름 검색 조건: (비슷한 이름 조회) where user_nm like '%길%'
    public List<UserEntity> findByUserNmLike(String userNm); // 변수의 값에 와일드카드의 기호를 추가하여 사용
    public List<UserEntity> findByUserNmStartingWith(String userNm); // 변수의 뒤로 오는 값에 대하여 찾아준다 : 변수 + "%"
    public List<UserEntity> findByUserNmEndingWith(String userNm); // 변수의 앞에 오는 값에 대하여 찾아준다 : "%" + 변수
    public List<UserEntity> findByUserNmContaining(String userNm); // 변수의 앞뒤로 오는 값에 대하여 찾아준다 : "%" + 변수 + "%"

}
