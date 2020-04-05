package com.jfb.blogjfb.services.impl;

import com.jfb.blogjfb.models.Post;
import com.jfb.blogjfb.repositories.PostRepository;
import com.jfb.blogjfb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository repo;

    @Override
    public List<Post> findAll() {
        return repo.findAll();
    }

    @Override
    public Post findById(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return repo.save(post);
    }
}
