package com.creativity.myblog.test;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ThymeleafControllerTest {

	@RequestMapping(method = RequestMethod.GET)
	public String thymeleafIndexExample(Model model) {
		model.addAttribute("name", "creation");
		model.addAttribute("values", Arrays.asList("Spring", "Spring Boot", "Vue.js", "React"));
		return "/index";
	}
}
