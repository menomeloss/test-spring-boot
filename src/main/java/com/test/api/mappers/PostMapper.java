package com.test.api.mappers;

import com.test.api.dto.PostDTO;
import com.test.api.models.Post;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostDTO toDTO(Post post);
    Post toModel(PostDTO postDTO);
    List<PostDTO> toListDTO(List<Post> posts);
}
