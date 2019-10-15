package com.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.form.Category;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml"})
public class CategoryServiceImplTest {


	@Autowired
	CategoryService categoryService;
	@Test
	public void test() {
		List<Category> categories = categoryService.list();
		for (Category category : categories) {
			System.out.println(category);
		}
	}

}
