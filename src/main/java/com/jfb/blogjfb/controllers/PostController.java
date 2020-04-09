package com.jfb.blogjfb.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import com.jfb.blogjfb.models.Post;
import com.jfb.blogjfb.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class PostController {

    @Autowired
    private PostService service;

    @RequestMapping("/posts")
    public ModelAndView getPosts() {
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = service.findAll();
        mv.addObject("posts", posts);
        return mv;
    }

    @GetMapping(value = "posts/{id}")
    public ModelAndView getPostDetails(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView("postDetails");
        Post post = service.findById(id);
        mv.addObject("post", post);
        return mv;
    }

    @GetMapping("/newpost")
    public ModelAndView getPostForm() {
        ModelAndView mv = new ModelAndView("postForm");
        return mv;
    }

    @PostMapping("/newpost")
    public ModelAndView savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return new ModelAndView("redirect:/posts/newpost");
        }
        post.setData(LocalDate.now());
        service.save(post);
        return new ModelAndView("redirect:/posts");
    }

}