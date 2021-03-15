package com.myproject.rspc.user.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.rspc.user.model.dao.UserDAO;
import com.myproject.rspc.user.model.vo.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired(required=true)
	UserDAO userDAO;
	
	@Override
	public int insertUser(User user) {
		
		return userDAO.insertUser(user);
	}

	@Override
	public User selectOneUser(String id) {
		
		return userDAO.selectOneUser(id);
	}

}
