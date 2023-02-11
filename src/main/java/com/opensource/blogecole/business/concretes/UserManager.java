package com.opensource.blogecole.business.concretes;

import com.opensource.blogecole.business.abstracts.UserService;
import com.opensource.blogecole.core.utilities.results.*;
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
    public Result add(User user) {
        userDao.save(user);
        return new SuccessResult();
    }
    @Override
    public Result update(User user)
    {
        if(user==null) return new ErrorResult();
        User userUpdate = userDao.getOne(user.getId());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setFirstName(user.getFirstName());
        userUpdate.setLastName(user.getLastName());
        userDao.save(userUpdate);
        return new SuccessResult();
    }
    @Override
    public DataResult<User> getById(int id) {
        User user = userDao.findById(id);
        if(user==null) return new ErrorDataResult<User>();
        return (new SuccessDataResult<User>(user));
    }

    @Override
    public DataResult<List<User>> getAll()
    {
        return new SuccessDataResult<List<User>>( userDao.findAll() );
    }

    @Override
    public DataResult<User> getByEmail(String email) {
        return new SuccessDataResult<User>(userDao.findByEmail(email));
    }
}
