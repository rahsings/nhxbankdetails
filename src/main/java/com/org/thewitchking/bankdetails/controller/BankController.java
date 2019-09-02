package com.org.thewitchking.bankdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.thewitchking.bankdetails.model.Bank_Branches;
import com.org.thewitchking.bankdetails.service.BankService;

@RestController
@RequestMapping("/api")
public class BankController {

    @Autowired 
    BankService service;
    
    @GetMapping("/")
    public String getApi() {
    	return "please check the api's mentioned";
    }
 
	@GetMapping("/branches/autocomplete{?q,limit,offset}")
    @ResponseBody
    public List<Bank_Branches> getByBranch(@RequestParam("q") String q, @RequestParam("offset") int offset,
    		@RequestParam("limit") int limit) {
        return service.getBankByBranch(q,offset,limit);
    }
    
    @GetMapping("/branches{?q,limit,offset}")
	  @ResponseBody
	  public List<Bank_Branches> getAll(@RequestParam("q") String q, @RequestParam("offset") int offset,
	  		@RequestParam("limit") int limit) {
	      return service.getBankByAll(q,offset,limit);
	  }
    
}
