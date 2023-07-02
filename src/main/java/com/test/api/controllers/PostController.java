package com.test.api.controllers;

import com.test.api.exceptions.post.PostNotFoundException;
import com.test.api.models.Post;
import com.test.api.services.interfaces.IPostService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    final IPostService service;

    @PostMapping
    @Transactional
    public ResponseEntity createPost(@RequestBody Post post) {
        try {
            return ResponseEntity.ok(service.create(post));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка! Наверно у нас что-то случилось хз");
        }
    }

    @GetMapping
    public ResponseEntity getPostById(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(service.getById(id));
        } catch (PostNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка! Наверно у нас что-то случилось хз");
        }
    }

    @GetMapping
    public ResponseEntity getAllPostByUserId(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(service.getListByUserId(id));
        } catch (PostNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка! Наверно у нас что-то случилось хз");
        }
    }

    @PatchMapping
    @Transactional
    public ResponseEntity editPost(@RequestBody Post newPost) {
        try {
            return ResponseEntity.ok(service.edit(newPost));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка! Наверно у нас что-то случилось хз");
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletePost(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка! Наверно у нас что-то случилось хз");
        }
    }
}
