package com.opensource.blogecole.business.abstracts;

import com.opensource.blogecole.core.utilities.results.DataResult;
import com.opensource.blogecole.core.utilities.results.Result;
import com.opensource.blogecole.entities.concretes.Category;
import com.opensource.blogecole.entities.concretes.User;
import com.opensource.blogecole.entities.concretes.UserProfile;

import java.util.List;

public interface CategoryService {

    DataResult<List<Category>> getAll();

    DataResult<Category> getById(int id);

    Result update(Category category);

    Result add(Category category);
}
