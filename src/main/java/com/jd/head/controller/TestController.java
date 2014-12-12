package com.jd.head.controller;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestController {
	private Logger log = Logger.getLogger(getClass());
	@RequestMapping("show")
	public String show(ModelMap result){
		String message = "hello spring!";
		log.debug("start to handle show request");
		result.put("message", message);
		return "showMessage";
	}
}
