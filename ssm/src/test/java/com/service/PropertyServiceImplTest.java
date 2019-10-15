package com.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.form.Property;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml"})
public class PropertyServiceImplTest {

	@Autowired
	private PropertyService propertyService;
	@Test
	public void testList() {
		List<Property>properties=propertyService.list(1);
		for (Property property : properties) {
			System.out.println(property);
		}
	}

}
