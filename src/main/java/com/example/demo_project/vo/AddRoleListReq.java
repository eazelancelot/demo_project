package com.example.demo_project.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddRoleListReq {

	private String account;

	@JsonProperty("role_list")
	private List<String> roleList;

	public AddRoleListReq() {

	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public List<String> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<String> roleList) {
		this.roleList = roleList;
	}

}
