package com.myproject.rspc.user.model.service;

import com.myproject.rspc.user.model.vo.User;

public interface UserService {
	
	int insertUser(User user);

	User selectOneUser(String id);
	
}
