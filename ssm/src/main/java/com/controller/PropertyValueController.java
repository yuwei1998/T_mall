package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.form.Product;
import com.form.Property;
import com.form.PropertyValue;
import com.service.ProductService;
import com.service.PropertyService;
import com.service.PropertyValueService;

@Controller
@RequestMapping("/admin")
public class PropertyValueController {

	@Autowired
	private PropertyValueService propertyValueService;

	@Autowired
	private ProductService productService;

	@Autowired
	private PropertyService propertyService;
	
	@RequestMapping("/listPropertyValue")
	public String list(Model model, Integer product_id, Integer category_id) {
		List<PropertyValue> propertyValues = propertyValueService.listByProductId(product_id);
		model.addAttribute("propertyValues", propertyValues);
		Product product = productService.get(product_id);
		model.addAttribute("product", product);
		List<Property> properties = propertyService.list(category_id);
		model.addAttribute("properties", properties);
		return "pages/admin/listPropertyValue";
	}
	@RequestMapping("/addPropertyValue")
	public String add(PropertyValue propertyValue) {
		System.out.println(propertyValue);
		int product_id = propertyValue.getProduct_id();
		int category_id = productService.get(product_id).getCategory_id();
		propertyValueService.add(propertyValue);
		return "redirect:listPropertyValue?product_id=" + product_id + "&category_id=" + category_id;
	}

	@RequestMapping("/deletePropertyValue")
	public String delete(Integer id) {
		int product_id = propertyValueService.get(id).getProduct_id();
		int category_id = productService.get(product_id).getCategory_id();
		propertyValueService.delete(id);
		return "redirect:listPropertyValue?product_id=" + product_id + "&category_id=" + category_id;
	}

	@RequestMapping("/editPropertyValue")
	public String edit(Integer id, Model model) {
		PropertyValue propertyValue = propertyValueService.get(id);
		model.addAttribute("propertyValue", propertyValue);
		Product product = productService.get(propertyValue.getProduct_id());
		model.addAttribute("product", product);
		return "pages/admin/editPropertyValue";
	}

	@RequestMapping("/updatePropertyValue")
	public String update(PropertyValue propertyValue) {
		int product_id = propertyValue.getProduct_id();
		int category_id = productService.get(product_id).getCategory_id();
		propertyValueService.update(propertyValue);
		return "redirect:listPropertyValue?product_id=" + product_id + "&category_id=" + category_id;
	}
}
