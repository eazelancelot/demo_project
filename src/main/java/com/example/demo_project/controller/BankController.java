package com.example.demo_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Bank;
import com.example.demo_project.service.ifs.BankService;
import com.example.demo_project.vo.BankReq;
import com.example.demo_project.vo.BankRes;

import io.swagger.v3.oas.annotations.Hidden;

//@ApiIgnore
@Hidden
@RestController
public class BankController {
	
	@Autowired
	private BankService bankService;
	
	@PostMapping(value = "/api/createAccount")
	public BankRes createAccount(@RequestBody BankReq req) throws Exception {
		Bank bank = bankService.createAccount(req.getAccount());
		return new BankRes(bank, "success");
	}
	
	@PostMapping(value = "/api/deleteAccount")
	public BankRes deleteAccount(@RequestBody BankReq req) throws Exception {
		bankService.deleteAccount(req.getAccount());
		return new BankRes(new Bank(), "success");
	}

}
