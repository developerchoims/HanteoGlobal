package com.hanteo.task1.repository;

import com.hanteo.task1.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("SELECT p FROM Post p WHERE p.category.id = :categoryId")
    Page<Post> findAllByCategoryId(Integer categoryId, Pageable pageable);

    @Query("SELECT p FROM Post p WHERE p.category.name = :name")
    Page<Post> findAllByCategoryName(String name, Pageable pageable);
}
