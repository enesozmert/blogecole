package com.opensource.blogecole.business.abstracts;

import com.opensource.blogecole.core.utilities.results.DataResult;
import com.opensource.blogecole.core.utilities.results.Result;
import com.opensource.blogecole.entities.concretes.User;
import com.opensource.blogecole.entities.concretes.UserProfile;

import java.util.List;

public interface UserProfileService {
    Result add(UserProfile userProfile);
    Result update(UserProfile userProfile);
    DataResult<List<UserProfile>> getAll();
    DataResult<UserProfile> getById(int id);
}
