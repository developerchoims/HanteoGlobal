package com.hanteo.task1.repository;

import com.hanteo.task1.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("SELECT c FROM Category c WHERE c.parent.id = :categoryId")
    List<Category> findAllByCategoryId(Integer categoryId);

    @Query("SELECT c FROM Category c WHERE c.parent.name = :name")
    List<Category> findAllByCategoryName(String name);
}
