package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.form.User;
import com.form.UserExample;
import com.form.UserExample.Criteria;
import com.mapper.UserMapper;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> list() {
		UserExample example =new UserExample();
		return userMapper.selectByExample(example);
	}

	@Override
	public void updatePassword(int id, String password) {
		User user=get(id);
		user.setPassword(password);
		userMapper.updateByPrimaryKey(user);
	}

	@Override
	public User get(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public boolean isExist(String name) {
		UserExample example=new UserExample();
		Criteria criteria=example.createCriteria();
		criteria.andNameEqualTo(name);
		List<User> users=userMapper.selectByExample(example);
		if(!users.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public void add(User user) {
		userMapper.insert(user);
	}

	@Override
	public User get(String name, String password) {
		UserExample example=new UserExample();
		Criteria criteria=example.createCriteria();
		criteria.andNameEqualTo(name);
		criteria.andPasswordEqualTo(password);
		List<User> users=userMapper.selectByExample(example);
		if(users.isEmpty()) {
			return null;
		}
		return users.get(0);
	}

}
