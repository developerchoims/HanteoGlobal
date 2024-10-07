package com.hanteo.task1.repository;

import com.hanteo.task1.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {


    @Query("SELECT c FROM Category c JOIN CategoryParent cp ON cp.category.id = c.id WHERE cp.parent.id = :categoryId")
    List<Category> findAllByCategoryId(Integer categoryId);

    @Query("SELECT c FROM Category c JOIN CategoryParent cp ON cp.category.id = c.id WHERE cp.parent.name = :name")
    List<Category> findAllByCategoryName(String name);

    @Query("SELECT c FROM Category c WHERE c.name = :name")
    Optional<Category> findByName(String name);
}
