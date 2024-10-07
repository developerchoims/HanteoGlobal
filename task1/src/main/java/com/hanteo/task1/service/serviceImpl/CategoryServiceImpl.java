package com.hanteo.task1.service.serviceImpl;

import com.hanteo.task1.common.Constants;
import com.hanteo.task1.entity.Category;
import com.hanteo.task1.repository.CategoryRepository;
import com.hanteo.task1.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public ResponseEntity<?> getCategoryByCategoryId(Integer categoryId) {
        try{
            //최종 정보가 담길 Map
            Map<Integer, List> map = new HashMap<>();
            // 선택된 첫 번째 카테고리
            Optional<Category> firstCategory = categoryRepository.findById(categoryId);
            if(firstCategory.isPresent()){
                // 두 번째 카테고리 목록
                List<Category> secondCategories = categoryRepository.findAllByCategoryId(firstCategory.get().getId());
                if(!secondCategories.isEmpty()){
                    map.put(firstCategory.get().getId(), secondCategories);
                    for(Category category : secondCategories){
                        // 세 번째 카테고리 목록
                        List<Category> thirdCategories = categoryRepository.findAllByCategoryId(category.getId());
                        if(!thirdCategories.isEmpty()){
                            map.put(category.getId(), thirdCategories);
                        }
                    }
                }
            }
            return ResponseEntity.ok(map);
        } catch (Exception e){
            log.error(Constants.CATEGORY_EXCEPTION, e);
            return ResponseEntity.badRequest().body(Constants.CATEGORY_EXCEPTION);
        }
    }

    @Override
    public ResponseEntity<?> getCategoryByCategoryName(String name) {
        try {
            //최종 정보가 담길 Map
            Map<Integer, List> map = new HashMap<>();
            // 선택된 첫 번째 카테고리 -> 공지사항 검색일 경우 Exception처리(두 개 이상의 결과 추출되기 때문)
            Optional<Category> firstCategory = categoryRepository.findByName(name);
            if (firstCategory.isPresent()) {
                // 두 번째 카테고리 목록
                List<Category> secondCategories = categoryRepository.findAllByCategoryId(firstCategory.get().getId());
                if (!secondCategories.isEmpty()) {
                    map.put(firstCategory.get().getId(), secondCategories);
                    for (Category category : secondCategories) {
                        // 세 번째 카테고리 목록
                        List<Category> thirdCategories = categoryRepository.findAllByCategoryId(category.getId());
                        if (!thirdCategories.isEmpty()) {
                            map.put(category.getId(), thirdCategories);
                        }
                    }
                }
            }
            return ResponseEntity.ok(map);
        }catch (IncorrectResultSizeDataAccessException e){
            log.error(Constants.DUPLICATE_CATEGORY_EXCEPTION, e);
            return ResponseEntity.badRequest().body(Constants.DUPLICATE_CATEGORY_EXCEPTION);
        } catch (Exception e) {
            log.error(Constants.CATEGORY_EXCEPTION, e);
            return ResponseEntity.badRequest().body(Constants.CATEGORY_EXCEPTION);
        }
    }
}
