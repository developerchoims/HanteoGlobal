package com.hanteo.task1.service;

import org.springframework.http.ResponseEntity;

public interface PostService {

    ResponseEntity<?> getPostByCategoryId(Integer categoryId, int page, int size);

    ResponseEntity<?> getPostByCategoryName(String name, int page, int size);
}
