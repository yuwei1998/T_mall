package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.form.Property;
import com.form.PropertyExample;
import com.form.PropertyExample.Criteria;
import com.mapper.PropertyMapper;

@Service
public class PropertyServiceImpl implements PropertyService{

	@Autowired
	private PropertyMapper propertyMapper;
	
	@Override
	public void add(Property property) {
		propertyMapper.insert(property);
	}

	@Override
	public void delete(Integer id) {
		propertyMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void update(Property property) {
		propertyMapper.updateByPrimaryKey(property);
	}

	@Override
	public List<Property> list(Integer category_id) {
		PropertyExample example=new PropertyExample();
		Criteria criteria=example.createCriteria();
		criteria.andCategory_idEqualTo(category_id);
		List<Property>properties=propertyMapper.selectByExample(example);
		return properties;
	}

	@Override
	public Property get(Integer id) {
		return propertyMapper.selectByPrimaryKey(id);
	}

}
