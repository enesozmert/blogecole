package com.opensource.blogecole.api.controllers;

import com.opensource.blogecole.business.abstracts.BlogService;
import com.opensource.blogecole.core.utilities.results.DataResult;
import com.opensource.blogecole.core.utilities.results.Result;
import com.opensource.blogecole.entities.concretes.Blog;
import com.opensource.blogecole.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogControllers {

    private BlogService blogService;

    @Autowired
    public BlogControllers(BlogService blogService) {
        this.blogService = blogService;
    }
    @PostMapping(value = "/add")
    public Result add(@RequestBody Blog blog){
        return blogService.add(blog);
    }
    @PostMapping(value = "/update")
    public Result update(@RequestBody Blog blog){
        return blogService.update(blog);
    }

    @GetMapping("/getall")
    public DataResult<List<Blog>> getAll(){
        return blogService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<Blog> getById(int id){
        return blogService.getById(id);
    }
}
