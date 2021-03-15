package com.myproject.rspc.user.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.rspc.user.model.vo.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public int insertUser(User user) {
		
		return sqlSession.insert("userMapper.insertUser", user);
	}

	@Override
	public User selectOneUser(String id) {
		
		return sqlSession.selectOne("userMapper.loginUser", id);
	}

}
