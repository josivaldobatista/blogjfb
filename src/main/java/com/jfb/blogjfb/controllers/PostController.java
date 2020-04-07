package com.jfb.blogjfb.controllers;

import java.util.List;

import com.jfb.blogjfb.models.Post;
import com.jfb.blogjfb.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService service;

    @RequestMapping
    public ModelAndView getPosts() {
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = service.findAll();
        mv.addObject("posts", posts);
        return mv;
    }

    @GetMapping(value = "/{id}")
    public ModelAndView getPostDetails(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView("postDetails");
        Post post = service.findById(id);
        mv.addObject("post", post);
        return mv;
    }

}