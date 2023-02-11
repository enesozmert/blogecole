package com.opensource.blogecole.api.controllers;

import com.opensource.blogecole.business.abstracts.CategoryService;
import com.opensource.blogecole.core.utilities.results.DataResult;
import com.opensource.blogecole.core.utilities.results.Result;
import com.opensource.blogecole.entities.concretes.Category;
import com.opensource.blogecole.entities.concretes.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryControllers {
    private CategoryService categoryService;

    @Autowired
    public CategoryControllers(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(value = "/add")
    public Result add(@RequestBody Category category){
        return categoryService.add(category);
    }
    @PostMapping(value = "/update")
    public Result update(@RequestBody Category category){
        return categoryService.update(category);
    }

    @GetMapping("/getall")
    public DataResult<List<Category>> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<Category> getById(int id){
        return categoryService.getById(id);
    }
}
