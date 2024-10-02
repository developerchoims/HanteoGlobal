package com.hanteo.task1.controller;

import com.hanteo.task1.entity.Post;
import com.hanteo.task1.model.dto.PostResponseDto;
import com.hanteo.task1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    //Post 불러오기(카테고리 식별자로 검색)
    @GetMapping("/post-category-id")
    public ResponseEntity<?> getPostByCategoryId(@RequestParam Integer categoryId
                                                , @RequestParam int page
                                                , @RequestParam int size) {
        return postService.getPostByCategoryId(categoryId, page, size);
    }

    //Post 불러오기(카테고리 이름으로 검색)
    @GetMapping("/post-category-name")
    public ResponseEntity<?> getPostByCategoryName(@RequestParam String name
                                                    , @RequestParam int page
                                                    , @RequestParam int size){
        return postService.getPostByCategoryName(name, page, size);
    }


}
