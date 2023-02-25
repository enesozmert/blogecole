package com.opensource.blogecole.business.abstracts;

import com.opensource.blogecole.core.utilities.results.DataResult;
import com.opensource.blogecole.core.utilities.results.Result;
import com.opensource.blogecole.entities.concretes.UserProfile;

import java.util.List;

public interface UserProfileService {

    DataResult<List<UserProfile>> getAll();

    DataResult<UserProfile> getById(int id);

    Result update(UserProfile userProfile);

    Result add(UserProfile userProfile);
}
