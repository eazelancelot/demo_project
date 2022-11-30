package com.example.demo_project.vo;

import com.example.demo_project.entity.Bank;

public class BankRes {

	private Bank bank;

	private String message;

	public BankRes() {

	}
	
	public BankRes(Bank bank, String message) {
		this.bank = bank;
		this.message = message;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
