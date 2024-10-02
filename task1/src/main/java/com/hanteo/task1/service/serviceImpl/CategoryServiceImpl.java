package com.hanteo.task1.service.serviceImpl;

import com.hanteo.task1.common.Constants;
import com.hanteo.task1.entity.Category;
import com.hanteo.task1.repository.CategoryRepository;
import com.hanteo.task1.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public ResponseEntity<?> getCategoryByCategoryId(Integer categoryId) {
        try{
            List<Category> categories = categoryRepository.findAllByCategoryId(categoryId);
            return ResponseEntity.ok(categories);
        } catch (Exception e){
            log.error(Constants.CATEGORY_EXCEPTION, e);
            return ResponseEntity.badRequest().body(Constants.CATEGORY_EXCEPTION);
        }
    }

    @Override
    public ResponseEntity<?> getCategoryByCategoryName(String name) {
        try{
            List<Category> categories = categoryRepository.findAllByCategoryName(name);
            return ResponseEntity.ok(categories);
        } catch (Exception e){
            log.error(Constants.CATEGORY_EXCEPTION, e);
            return ResponseEntity.badRequest().body(Constants.CATEGORY_EXCEPTION);
        }
    }
}
