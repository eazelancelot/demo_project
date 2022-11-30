package com.example.demo_project.service.impl;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Bank;
import com.example.demo_project.repository.BankDao;
import com.example.demo_project.service.ifs.BankService;

@Service
public class BankServiceImpl implements BankService {
	
	@Value("${email.passworddd:ASDF}")
	private String emailPwddd;
	
	@Autowired
	private BankDao bankDao;

	
	@Transactional(rollbackOn = Exception.class)
	@Override
	public Bank createAccount(String account) throws Exception {
		Bank bankItem = new Bank(account, 0);
		Bank resBank = bankDao.save(bankItem);
//		throw new Exception("Create account Error!!");
		return resBank;
	}


	@Transactional
	@Override
	public void deleteAccount(String account) throws RuntimeException {
		bankDao.deleteById(account);
		System.out.println("Delete account success");
		throw new RuntimeException("Delete account Error!!");
	}

}
