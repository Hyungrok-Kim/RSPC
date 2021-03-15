package com.myproject.rspc.user.model.dao;

import com.myproject.rspc.user.model.vo.User;

public interface UserDAO {
	
	int insertUser(User user);

	User selectOneUser(String id);

}
