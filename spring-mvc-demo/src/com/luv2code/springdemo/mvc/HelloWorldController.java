package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.*;

import com.sun.net.httpserver.HttpServer;

@Controller
public class HelloWorldController {
	
	//need a controller method to show the initial HTNL for
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// new a controller method to read form data and
	// add data to the model
	
	@RequestMapping("/processFormVertionTwo")
	public String letsShoutDude(HttpServer request, Model model) {
		// read the request parametr from the HTML form
		String theName = request.getParametr("studentName");
		
		//convert the data to all caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Yo" + theName;
		
		//add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}

}
