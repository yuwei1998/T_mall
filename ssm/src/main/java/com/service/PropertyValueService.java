package com.service;

import java.util.List;

import com.form.PropertyValue;

public interface PropertyValueService {

	
	void add(PropertyValue propertyValue);

	void delete(Integer id);

	void deleteByProductId(Integer product_id);

	void update(PropertyValue propertyValue);

	List<PropertyValue> list(Integer product_id, Integer category_id);

	PropertyValue get(Integer id);

	List<PropertyValue> listByProductId(Integer product_id);
}
