package com.hanteo.task1.service.serviceImpl;

import com.hanteo.task1.common.Constants;
import com.hanteo.task1.entity.Post;
import com.hanteo.task1.repository.PostRepository;
import com.hanteo.task1.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> getPostByCategoryId(Integer categoryId, int page, int size) {
        try{
            //categoryId로 post entity 가져오기
            Pageable pageable = PageRequest.of(page, size);
            Page<Post> posts = postRepository.findAllByCategoryId(categoryId, pageable);
            return ResponseEntity.ok(posts);
        } catch (Exception e){
            log.error(Constants.POST_EXCEPTION, e);
            return ResponseEntity.badRequest().body(Constants.POST_EXCEPTION);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> getPostByCategoryName(String name, int page, int size) {
        try{
            Pageable pageable = PageRequest.of(page, size);
            Page<Post> posts = postRepository.findAllByCategoryName(name, pageable);
            return ResponseEntity.ok(posts);
        } catch (Exception e){
            log.error(Constants.POST_EXCEPTION, e);
            return ResponseEntity.badRequest().body(Constants.POST_EXCEPTION);
        }
    }
}
