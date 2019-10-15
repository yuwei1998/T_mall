package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.form.Property;
import com.form.PropertyValue;
import com.form.PropertyValueExample;
import com.mapper.PropertyValueMapper;

@Service
public class PropertyValueServiceImpl implements PropertyValueService{

	@Autowired
	private PropertyValueMapper propertyValueMapper;
	@Autowired
	private PropertyService propertyService;
	@Autowired
	private ProductService productService;
	
	@Override
	public void add(PropertyValue propertyValue) {
		propertyValueMapper.insert(propertyValue);
	}

	@Override
	public void delete(Integer id) {
		propertyValueMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteByProductId(Integer product_id) {
		// 按条件查询出需要删除的列表
		PropertyValueExample example = new PropertyValueExample();
		example.or().andProduct_idEqualTo(product_id);
		Integer category_id = productService.get(product_id).getCategory_id();
		List<PropertyValue> propertyValues = list(product_id, category_id);
		// 循环删除
		for (int i = 0; i < propertyValues.size(); i++) {
			propertyValueMapper.deleteByPrimaryKey(propertyValues.get(i).getId());
		}
	}

	@Override
	public void update(PropertyValue propertyValue) {
		propertyValueMapper.updateByPrimaryKey(propertyValue);
	}

	@Override
	public List<PropertyValue> list(Integer product_id, Integer category_id) {
		PropertyValueExample example = new PropertyValueExample();
		List<PropertyValue> propertyValues = new ArrayList<>();
		List<Property> properties = propertyService.list(category_id);
		for (Property property : properties) {
			// 筛选出同时匹配 property_id 和 product_id 的值
			example.or().andProperty_idEqualTo(property.getId()).andProduct_idEqualTo(product_id);
			propertyValues.addAll(propertyValueMapper.selectByExample(example));
		}	
		return propertyValues;
	}

	@Override
	public PropertyValue get(Integer id) {
		return propertyValueMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<PropertyValue> listByProductId(Integer product_id) {
		PropertyValueExample example = new PropertyValueExample();
		example.or().andProduct_idEqualTo(product_id);
		List<PropertyValue> propertyValues = propertyValueMapper.selectByExample(example);
		for (PropertyValue propertyValue : propertyValues) {
			Property property = propertyService.get(propertyValue.getProperty_id());
			propertyValue.setProperty(property);
		}
		return propertyValues;
	}

}
