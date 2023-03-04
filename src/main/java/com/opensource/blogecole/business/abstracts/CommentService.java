package com.opensource.blogecole.business.abstracts;

import com.opensource.blogecole.core.utilities.results.DataResult;
import com.opensource.blogecole.core.utilities.results.Result;
import com.opensource.blogecole.entities.concretes.Comment;

import java.util.List;

public interface CommentService {
    DataResult<List<Comment>> getAll();

    DataResult<Comment> getById(int id);

    Result update(Comment comment);

    Result add(Comment comment);
}
