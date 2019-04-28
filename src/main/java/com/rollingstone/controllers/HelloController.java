package com.rollingstone.controllers;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rollingstone.util.XSSUtil;

@Controller
public class HelloController {
	
	Logger log = LoggerFactory.getLogger("WebController");

	@GetMapping("/")
	    public String index(Model model){
	        model.addAttribute("datetime", new Date());

	        return "index";
	    }
	 
    @GetMapping({"/hello"})
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
    	boolean isXss = XSSUtil.detectXSS(name);
    	String viewName = "";
    	log.info("XSS Detected :"+ isXss);
    	if (!isXss) {
    		model.addAttribute("name", name);
    		viewName = "hello";
    	}
    	else {
    		model.addAttribute("error", "Cross Site Scripting is Not Allowed");
    		viewName = "error";
    	}
    	log.info("Viewname :"+viewName);
        return viewName;
    }
}
