package com.example.demo_project.service.ifs;

import com.example.demo_project.entity.Bank;

public interface BankService {

	public Bank createAccount(String account) throws Exception;
	
	public void deleteAccount(String account) throws RuntimeException;
}
