package com.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.form.Category;
import com.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@RequestMapping("/listCategory")
	public String list(Model model) {
		List<Category> categories = categoryService.list();
		model.addAttribute("categories", categories);
		return "pages/admin/listCategory";
	}

	@RequestMapping("/editCategory")
	public String edit(Category category,Model model) {
		model.addAttribute("category", category);
		return "pages/admin/editCategory";
	}

	@RequestMapping("/updateCategory")
	public String update(Category category) {
		categoryService.update(category);
		return "redirect:listCategory";
	}
}
