package com.opensource.blogecole.business.concretes;

import com.opensource.blogecole.business.abstracts.CommentService;
import com.opensource.blogecole.core.utilities.business.BusinessRules;
import com.opensource.blogecole.core.utilities.results.*;
import com.opensource.blogecole.dataAccess.abstracts.CommentDao;
import com.opensource.blogecole.entities.concretes.Category;
import com.opensource.blogecole.entities.concretes.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentManager implements CommentService {

    private CommentDao commentDao;

    @Autowired
    public CommentManager(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public Result add(Comment comment) {
        commentDao.save(comment);
        return (new SuccessResult());
    }

    @Override
    public Result update(Comment comment) { // id = 1 name=blog => (id= 1 name=blog1)param
        Comment commentUpdate = getById(comment.getId()).getData();
        commentUpdate.setText(comment.getText());
        commentUpdate.setBlogId(comment.getBlogId());
        commentUpdate.setUserId(comment.getUserId());
        commentDao.save(commentUpdate);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<Comment>> getAll() {
        return (new SuccessDataResult<List<Comment>>(commentDao.findAll()));
    }

    @Override
    public DataResult<Comment> getById(int id) {
        Comment comment = commentDao.findById(id);
        if(comment==null) return new ErrorDataResult<Comment>();
        return (new SuccessDataResult<Comment>(comment));
    }
}
