package com.opensource.blogecole.business.concretes;

import com.opensource.blogecole.business.abstracts.BlogService;
import com.opensource.blogecole.core.utilities.results.*;
import com.opensource.blogecole.dataAccess.abstracts.BlogDao;
import com.opensource.blogecole.entities.concretes.Blog;
import com.opensource.blogecole.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogManager implements BlogService {

    private BlogDao blogDao;

    @Autowired
    public BlogManager(BlogDao blogDao) {
        this.blogDao = blogDao;
    }

    @Override
    public DataResult<List<Blog>> getAll() {
        return (new SuccessDataResult<List<Blog>>(blogDao.findAll()));
    }

    @Override
    public DataResult<Blog> getById(int id) {
        Blog blog = blogDao.findById(id);
        if(blog==null) return new ErrorDataResult<Blog>();
        return (new SuccessDataResult<Blog>(blog));
    }

    @Override
    public Result update(Blog blog) {
        return null;
    }

    @Override
    public Result add(Blog blog) {

        blogDao.save(blog);
        return (new SuccessResult("Blog added"));
    }
}
