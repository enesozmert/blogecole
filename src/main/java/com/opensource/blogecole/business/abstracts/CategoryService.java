package com.opensource.blogecole.business.abstracts;

import com.opensource.blogecole.core.utilities.results.DataResult;
import com.opensource.blogecole.core.utilities.results.Result;
import com.opensource.blogecole.entities.concretes.Category;
import com.opensource.blogecole.entities.concretes.UserProfile;

import java.util.List;

public interface CategoryService {
    Result add(Category category);
    Result update(Category category);
    DataResult<List<Category>> getAll();
    DataResult<Category> getById(int id);
}
