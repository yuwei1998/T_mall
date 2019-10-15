package com.service;

import java.util.List;

import com.form.Property;

public interface PropertyService {

	void add(Property property);
	
	void delete(Integer id);
	
	void update(Property property);
	
	List<Property> list(Integer category_id);
	
	Property get(Integer id);
}
