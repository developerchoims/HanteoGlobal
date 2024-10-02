package com.hanteo.task1.service;

import com.hanteo.task1.entity.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {
    ResponseEntity<?> getCategoryByCategoryId(Integer categoryId);

    ResponseEntity<?> getCategoryByCategoryName(String name);
}
