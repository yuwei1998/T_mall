package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.form.OrderItem;
import com.service.OrderItemService;

import java.util.List;

@Controller
@RequestMapping("")
public class PageController {
	@Autowired
	private OrderItemService orderItemService;

	@RequestMapping("/loginPage")
	public String loginPage() {
		return "pages/loginPage";
	}

	@RequestMapping("/registerSuccessPage")
	public String registerSuccessPage() {
		return "pages/registerSuccessPage";
	}

	@RequestMapping("/registerPage")
	public String registerPage() {
		return "pages/registerPage";
	}

	@RequestMapping("/test")
	public String testPage(Model model) {
		List<OrderItem> orderItems = orderItemService.getByOrderId(1);
		model.addAttribute("orderItems", orderItems);
		return "pages/buyPage";
	}

	@RequestMapping("/payPage")
	public String payPage() {
		return "pages/alipay";
	}

	@RequestMapping("/admin")
	public String admin() {
		return "pages/admin/index";
	}
}
