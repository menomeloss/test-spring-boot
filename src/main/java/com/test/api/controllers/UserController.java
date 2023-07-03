package com.test.api.controllers;

import com.test.api.exceptions.user.UserAlreadyExistException;
import com.test.api.exceptions.user.UserNotFoundException;
import com.test.api.models.User;
import com.test.api.services.interfaces.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    final IUserService service;

    public UserController(IUserService service) {
        this.service = service;
    }

    @PostMapping
    @Transactional
    public ResponseEntity registration(@RequestBody User user) {
        try {
            return ResponseEntity.ok(service.registration(user));
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка! Наверно у нас что-то случилось хз");
        }
    }

    @GetMapping
    public ResponseEntity geUserByName(@RequestParam String name) {
        try {
            return ResponseEntity.ok(service.getByName(name));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch(Exception e) {
            return ResponseEntity.badRequest().body("Ошибка! Наверно у нас что-то случилось хз");
        }
    }


    @PatchMapping
    @Transactional
    public ResponseEntity updateUserData(@RequestBody User user) {
        try {
            return ResponseEntity.ok(service.update(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка! Наверно у нас что-то случилось хз");
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка! Наверно у нас что-то случилось хз");
        }
    }
}
