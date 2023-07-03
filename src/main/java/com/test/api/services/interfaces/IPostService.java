package com.test.api.services.interfaces;

import com.test.api.dto.PostDTO;
import com.test.api.exceptions.post.PostNotFoundException;
import com.test.api.models.Post;

import java.util.List;

public interface IPostService {
    PostDTO create(Post post);
    PostDTO getById(Long id) throws PostNotFoundException;
    List<PostDTO> getListByUserName(String name) throws PostNotFoundException;
    Long edit(Post newPost);
    Long delete(Long id);
}
