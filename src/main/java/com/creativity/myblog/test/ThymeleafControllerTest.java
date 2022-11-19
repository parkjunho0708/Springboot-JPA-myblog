package com.creativity.myblog.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ThymeleafControllerTest {

	@RequestMapping(value = "/thymeleaf/example", method = RequestMethod.GET)
	public ModelAndView thymeleafIndexExample() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("name", "creation");
		
		List<String> list = new ArrayList<String>();
	    list.add("List A");
	    list.add("List B");
	    list.add("List C");
	    list.add("List D");
	    list.add("List 1");
	    list.add("List 2");
	    list.add("List 3");
	    
		modelAndView.addObject("values", list);
		modelAndView.setViewName("index");
		return modelAndView;
	}
}
