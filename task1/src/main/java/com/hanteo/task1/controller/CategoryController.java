package com.hanteo.task1.controller;

import com.hanteo.task1.service.CategoryService;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<?> getCategory(@Nullable @RequestParam Integer categoryId
                                    , @Nullable @RequestParam String name) {

        //카테고리 식별자 및 카테고리명으로 검색이 되어야하며,
        //검색된 결과 값은 해당 카테고리의 하위 카테고리를 모두 담고 있어야 한다.

        //categoryId가 null이 아닐 때 categoryId로 검색 결과 전달
        if(categoryId != null){
            return categoryService.getCategoryByCategoryId(categoryId);
        } else {
            //name이 null이 아닐 때 name으로 검색 결과 전달
            if(name != null && !name.isEmpty()){
                return categoryService.getCategoryByCategoryName(name);
            }  else {
                //categoryId == null, name==null||name.isEmpty()면 return null;
                return null;
            }
        }
    }
}
