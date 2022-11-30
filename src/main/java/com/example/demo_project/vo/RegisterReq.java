package com.example.demo_project.vo;

import java.util.Date;

import org.springframework.boot.origin.SystemEnvironmentOrigin;

public class RegisterReq {

	private String account;

	private String pwd;

	private String name;

	private int age;

	private String city = "";
	
	private Date date;
	
	private RegisterReq req;
	
	public RegisterReq() {
		this.date = new Date();
	}
	
	public RegisterReq(String name, String account, String pwd) {
//		this();
		this.date = new Date();
		this.name = name;
		this.account = account;
		this.pwd = pwd;
	}
	
	public void show() {
		System.out.println("name: " + this.name);
		System.out.println("account: " + this.account);
		System.out.println("pwd: " + this.pwd);
		System.out.println("date: " + this.date);
		System.out.println("req_name: " + this.req.getName());
	}
	
	public void show(String account, String pwd) {
		System.out.println("account: " + account);
		System.out.println("pwd: " + pwd);
		System.out.println("date: " + new Date());
	}
	
	private void showName() {
		System.out.println("name: " + this.name);
	}
	
	public static void main(String[] args) {
		RegisterReq req = new RegisterReq("AAA", "A01", "123");
//		req.setReq(req);
		req.show();
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public RegisterReq getReq() {
		return req;
	}

	public void setReq(RegisterReq req) {
		this.req = req;
	}

}
