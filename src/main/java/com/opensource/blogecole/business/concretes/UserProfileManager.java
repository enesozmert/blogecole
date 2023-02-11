package com.opensource.blogecole.business.concretes;

import com.opensource.blogecole.business.abstracts.UserProfileService;
import com.opensource.blogecole.core.utilities.results.*;
import com.opensource.blogecole.dataAccess.abstracts.UserProfileDao;
import com.opensource.blogecole.entities.concretes.User;
import com.opensource.blogecole.entities.concretes.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileManager implements UserProfileService {

    private UserProfileDao userProfileDao;

    @Autowired
    public UserProfileManager(UserProfileDao userProfileDao) {
        this.userProfileDao = userProfileDao;
    }

    @Override
    public Result add(UserProfile userProfile) {
        userProfileDao.save(userProfile);
        return new SuccessResult();
    }

    @Override
    public Result update(UserProfile userProfile) {
        if(userProfile==null) return new ErrorResult();
        UserProfile userProfileUpdate = userProfileDao.getOne(userProfile.getId());
        userProfileUpdate.setImagePath(userProfile.getImagePath());
        userProfileDao.save(userProfileUpdate);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<UserProfile>> getAll() {
        return (new SuccessDataResult<List<UserProfile>>(userProfileDao.findAll()));
    }

    @Override
    public DataResult<UserProfile> getById(int id) {
        UserProfile userProfile = userProfileDao.findById(id);
        if(userProfile==null) return new ErrorDataResult<UserProfile>();
        return (new SuccessDataResult<UserProfile>(userProfile));
    }
}
