package com.app.controller;

import com.app.entity.BoardEntity;
import com.app.repository.BoardEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardEntityRepository boardEntityRepository;

    @GetMapping("/boards")
    public String boards() {
        return "board";
    }

    @ResponseBody
    @GetMapping("/boardAll")
    public List<BoardEntity> getAllBoards() {
//        return boardEntityRepository.getBoards();
//        return boardEntityRepository.findAll();
        return boardEntityRepository.getBoardAll();
    }
}
