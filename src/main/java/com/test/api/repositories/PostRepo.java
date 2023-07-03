package com.test.api.repositories;

import com.test.api.models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepo extends CrudRepository<Post, Long> {
    List<Post> getAllByUserName(String name);
}
