package com.opensource.blogecole.business.concretes;

import com.opensource.blogecole.business.abstracts.CategoryService;
import com.opensource.blogecole.core.utilities.business.BusinessRules;
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

        Result businessRules = BusinessRules.run(
                isLowerCase(category.getName())
        );
        if(businessRules!=null) return businessRules;
        if (isUniqName(category.getName()) == false)
            return (new ErrorResult("Already exist"));
        categoryDao.save(category);
        return (new SuccessResult());
    }

    private Result isLowerCase(String name) {
        if (!name.equals(name.toLowerCase()))
            return new ErrorResult("Name is not lower");
        return new SuccessResult();
    }

    @Override
    public Result update(Category category) { // id = 1 name=blog => (id= 1 name=blog1)param
        if (isUniqName(category.getName()) == false)
            return (new ErrorResult("Already exist"));
        Category categoryUpdate = getById(category.getId()).getData();
        categoryUpdate.setName(category.getName());
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

    private boolean isUniqName(String name)
    {
        List<Category> categories = categoryDao.findAllByName(name);

        if (categories.size() > 1)
            return (false);
        return (true);
    }

}
