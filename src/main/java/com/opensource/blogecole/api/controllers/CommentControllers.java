package com.opensource.blogecole.api.controllers;

import com.opensource.blogecole.business.abstracts.CommentService;
import com.opensource.blogecole.core.utilities.results.DataResult;
import com.opensource.blogecole.core.utilities.results.Result;
import com.opensource.blogecole.entities.concretes.Category;
import com.opensource.blogecole.entities.concretes.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentControllers {
    private CommentService commentService;

    @Autowired
    public CommentControllers(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping(value = "/add")
    public Result add(@RequestBody Comment comment){
        return commentService.add(comment);
    }
    @PostMapping(value = "/update")
    public Result update(@RequestBody Comment comment){
        return commentService.update(comment);
    }

    @GetMapping("/getall")
    public DataResult<List<Comment>> getAll(){
        return commentService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<Comment> getById(int id){
        return commentService.getById(id);
    }
}
