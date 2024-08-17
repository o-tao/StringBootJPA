package com.app.controller;

import com.app.entity.RoleEntity;
import com.app.entity.UserEntity;
import com.app.repository.RoleEntityRepository;
import com.app.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserEntityRepository UserEntityRepository;
    private final RoleEntityRepository roleEntityRepository;
    private final UserEntityRepository userEntityRepository;

    @GetMapping("/users")
    public String users(Model model,
                        @RequestParam(name = "userNm", required = false, defaultValue = "") String userNm,
                        @PageableDefault(size = 3) Pageable pageable) {
        Page<UserEntity> users = userEntityRepository.findByUserNmContaining(userNm, pageable);
        log.info("Users : {}", users);

        int cnt = 5; // 페이지 이동 버튼 갯수
        int end = Math.min(users.getTotalPages(), users.getPageable().getPageNumber() + cnt);
        int start = Math.max(1, end - (cnt - 1));

        model.addAttribute("users", users);
        model.addAttribute("start", start);
        model.addAttribute("end", end);
        return "user";
    }

    // 권한 부여
    @GetMapping("/grant")
    public String grant() {
        // 사용자 정보 가져오기
        UserEntity user = UserEntityRepository.findById(3).orElseThrow();

        // 사용자가 가지고 있는 권한 목록 가져오기
        Set<RoleEntity> roles = user.getRoles();

        // 신규 권한 가져오기
        RoleEntity role = roleEntityRepository.findById(3).orElseThrow();

        // 사용자 권한 목록 추가
        roles.add(role);
        user.setRoles(roles);

        // 수정된 사용자 정보 적용
        UserEntityRepository.save(user);

        return "redirect:/users";
    }

    @ResponseBody
    @GetMapping("/detail")
    public UserEntity detail(@RequestParam("id") Integer id) {
        return UserEntityRepository.findById(id).orElseThrow();
    }
}
