package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.form.ReferalLink;
import com.service.ReferalLinkService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ReferalLinkController {

	@Autowired
	private ReferalLinkService referalLinkService;

	@RequestMapping("/listLink")
	public String list(Model model) {
		List<ReferalLink> links = referalLinkService.listAll();
		model.addAttribute("links", links);
		return "pages/admin/listLink";
	}

	@RequestMapping("/updateLink")
	public String update(ReferalLink link) {
		referalLinkService.update(link);
		return "redirect:listLink";
	}
}
