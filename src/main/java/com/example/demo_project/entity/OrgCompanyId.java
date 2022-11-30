package com.example.demo_project.entity;

import java.io.Serializable;


@SuppressWarnings("serial")
public class OrgCompanyId implements Serializable {

	private String orgId;

	private String companyId;

	public OrgCompanyId() {

	}
	
	public OrgCompanyId(String orgId, String companyId) {
		this.orgId = orgId;
		this.companyId = companyId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

}
