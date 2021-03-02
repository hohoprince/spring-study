package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    // html form 태그 사용, ajax 검색
    @PostMapping(value = "/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam) {

        return searchParam;
    }

    @PutMapping("/putMethod")
    public void put() {

    }

    @PatchMapping("patchMethod")
    public void patch() {

    }
}
