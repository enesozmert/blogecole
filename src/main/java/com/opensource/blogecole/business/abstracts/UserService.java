package com.opensource.blogecole.business.abstracts;


import com.opensource.blogecole.core.utilities.results.DataResult;
import com.opensource.blogecole.core.utilities.results.Result;
import com.opensource.blogecole.entities.concretes.User;

import java.util.List;

public interface UserService {
    Result update(User user);

    DataResult<List<User>> getAll();
    DataResult<User> getByEmail(String email);
    Result add(User user);

    DataResult<User> getById(int id);
}
