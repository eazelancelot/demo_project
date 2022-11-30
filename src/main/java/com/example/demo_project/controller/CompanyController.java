package com.example.demo_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Company;
import com.example.demo_project.service.ifs.CompanyService;
import com.example.demo_project.vo.CompanyReq;

@RestController
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@PostMapping(value = "/api/getCompanies")
	public List<Company> findAll() {
		return companyService.findAll();
	}
	
	@PostMapping(value = "/api/getCompanyById")
	public Company findById(@RequestBody CompanyReq req) {
		return companyService.findById(req.getOrgId(), req.getCompanyId());
	}
	
	@PostMapping(value = "/api/updateCompanyById")
	public Company updateById(@RequestBody CompanyReq req) {
		return companyService.updateById(req.getOrgId(), req.getCompanyId());
	}
	
	@PostMapping(value = "/api/saveCompany")
	public Company saveCompany() {
		return companyService.saveCompany();
	}

}
