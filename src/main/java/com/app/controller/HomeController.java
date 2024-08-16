package com.app.controller;

import com.app.entity.Test;
import com.app.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    TestRepository testRepository;

    @GetMapping("/test")
    public List<Test> test() {
        
        return testRepository.findAll();
    }

    @GetMapping("/set")
    public Test set() {
        Test test = new Test();
        test.setNo(1);
        test.setDel(false);
        return testRepository.save(test);
    }
}
