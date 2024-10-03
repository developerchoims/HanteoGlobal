package com.hanteo.task1.service;

import org.springframework.http.ResponseEntity;

public interface CategoryService {
    ResponseEntity<?> getCategoryByCategoryId(Integer categoryId);

    ResponseEntity<?> getCategoryByCategoryName(String name);
}
