package com.opensource.blogecole.business.concretes;

import com.opensource.blogecole.business.abstracts.CategoryService;
import com.opensource.blogecole.core.utilities.results.*;
import com.opensource.blogecole.dataAccess.abstracts.CategoryDao;
import com.opensource.blogecole.entities.concretes.Category;
import com.opensource.blogecole.entities.concretes.User;
import com.opensource.blogecole.entities.concretes.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements CategoryService {

    private CategoryDao categoryDao;

    @Autowired
    public CategoryManager(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Result add(Category category) {
        categoryDao.save(category);
        return (new SuccessResult());
    }

    @Override
    public Result update(Category category) {
        if (category==null) return new ErrorResult();
        Category categoryUpdate = categoryDao.getOne(category.getId());
        categoryUpdate.setName(categoryUpdate.getName());
        categoryDao.save(categoryUpdate);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<Category>> getAll() {
        return (new SuccessDataResult<List<Category>>(categoryDao.findAll()));
    }

    @Override
    public DataResult<Category> getById(int id) {
        Category category = categoryDao.findById(id);
        if(category==null) return new ErrorDataResult<Category>();
        return (new SuccessDataResult<Category>(category));
    }
}
