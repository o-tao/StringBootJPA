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
                        @PageableDefault(size = 2) Pageable pageable) {
        Page<UserEntity> users = userEntityRepository.findByUserNmContaining("", pageable);
        log.info("Users : {}", users);
        model.addAttribute("users", users);
        return "user";
    }

    @GetMapping("/grant")
    public String grant() {
        RoleEntity role = roleEntityRepository.findById(1).orElseThrow();
        log.info("Role : {}", role);

        UserEntity user = UserEntityRepository.findById(1).orElseThrow();
        log.info("User : {}", user);

        Set<RoleEntity> roles = user.getRoles();
        roles.add(role);
        user.setRoles(roles);

        userEntityRepository.save(user);

        return "redirect:/users";
    }
}
