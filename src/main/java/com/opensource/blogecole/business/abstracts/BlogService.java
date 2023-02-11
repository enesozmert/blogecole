package com.opensource.blogecole.business.abstracts;

import com.opensource.blogecole.core.utilities.results.DataResult;
import com.opensource.blogecole.core.utilities.results.Result;
import com.opensource.blogecole.entities.concretes.Blog;
import com.opensource.blogecole.entities.concretes.Category;

import java.util.List;

public interface BlogService {

    DataResult<List<Blog>> getAll();

    DataResult<Blog> getById(int id);

    Result update(Blog blog);

    Result add(Blog blog);
}
