package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompanyReq {

	@JsonProperty("org_id")
	private String orgId;

	@JsonProperty("company_id")
	private String companyId;

	public CompanyReq() {

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
