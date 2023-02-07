package com.opensource.blogecole.business.concretes;

import com.opensource.blogecole.business.abstracts.UserService;
import com.opensource.blogecole.core.utilities.results.DataResult;
import com.opensource.blogecole.core.utilities.results.Result;
import com.opensource.blogecole.core.utilities.results.SuccessDataResult;
import com.opensource.blogecole.core.utilities.results.SuccessResult;
import com.opensource.blogecole.dataAccess.abstracts.UserDao;
import com.opensource.blogecole.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>( userDao.findAll() );
    }

    @Override
    public DataResult<User> getByEmail(String email) {
        return new SuccessDataResult<User>(userDao.findByEmail(email));
    }

    @Override
    public Result add(User user) {
        userDao.save(user);
        return new SuccessResult();
    }
}
