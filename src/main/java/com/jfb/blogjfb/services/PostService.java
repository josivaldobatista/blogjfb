package com.jfb.blogjfb.services;

import com.jfb.blogjfb.models.Post;

import java.util.List;

public interface PostService {

    List<Post> findAll();
    Post findById(Integer id);
    Post save(Post post);
}
