package com.test.api.services;

import com.test.api.dto.PostDTO;
import com.test.api.exceptions.post.PostNotFoundException;
import com.test.api.exceptions.user.UserNotFoundException;
import com.test.api.mappers.PostMapper;
import com.test.api.models.Post;
import com.test.api.repositories.PostRepo;
import com.test.api.services.interfaces.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService {
    final PostRepo repo;
    final PostMapper mapper;

    @Override
    public PostDTO create(Post post) {
        return mapper.toDTO(repo.save(post));
    }

    @Override
    public PostDTO getById(Long id) throws PostNotFoundException {
        var post = repo.findById(id)
                .orElseThrow(() -> new PostNotFoundException(
                        "Пост с не найден."));

        return mapper.toDTO(post);
    }

    @Override
    public List<PostDTO> getListByUserId(Long id) throws PostNotFoundException {
        var posts = repo.getAllByUserId(id);
        if (posts == null)
            throw new PostNotFoundException("У этого пользователя еще нет постов.");
        return mapper.toListDTO(posts);
    }

    @Override
    public Long edit(Post newPost) {
        repo.save(newPost);
        return newPost.getId();
    }

    @Override
    public Long delete(Long id) {
        repo.deleteById(id);
        return id;
    }
}
