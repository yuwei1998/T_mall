package com.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.form.User;
import com.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml"})
public class UserServiceImplTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void testList() {
		List<User>users=userService.list();
		for (User user : users) {
			System.out.println(user);
		}
	}

	@Test
	public void testUpdatePassword() {
		userService.updatePassword(1, "1234");
	}

	@Test
	public void testGet() {
		System.out.println(userService.get(1));
	}
	@Test
	public void testGet1() {
		System.out.println(userService.get("我没有三颗心脏123","123"));
	}

	@Test
	public void testIsExist() {
		System.out.println(userService.isExist("我没有三颗心脏"));
	}

	@Test
	public void testAdd() {
		User user = new User();
		user.setName("wiy");
		user.setPassword("123");
		userService.add(user);
	}

}
