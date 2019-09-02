package com.org.thewitchking.bankdetails.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	 @GetMapping("/")
	    public String giveWelcome() {
	        return "Welcome to the bank details please visit the page insited  <a href=\"/api/\">Click Here</a>\" ";
	   }
}
