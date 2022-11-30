package com.example.demo_project.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_project.constants.RegisterRtnCode;
import com.example.demo_project.entity.Register;
import com.example.demo_project.repository.RegisterDao;
import com.example.demo_project.service.ifs.RegisterService;
import com.example.demo_project.vo.RegisterRes;

@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	private RegisterDao registerDao;

	@Override
	public Register register(String account, String pwd, String name, int age, String city) {
		// ������U�w�s�b�b��
		if (registerDao.existsById(account)) {
			return null;
		}
		Register reg = new Register(account, pwd, name, age, city);
		reg.setRegTime(new Date()); // new Date() --> �t�η�e�ɶ�
//		reg.setActive(false); // active �� date_type �O boolean, false default
		reg.setRole("General");
		return registerDao.save(reg);
	}

	@Override
	public RegisterRes activeAccount(String account) {
		Optional<Register> regOp = registerDao.findById(account);
		if (regOp.isPresent()) {
			Register reg = regOp.get();
			reg.setActive(true);
			registerDao.save(reg);
			return new RegisterRes(null, RegisterRtnCode.SUCCESSFUL.getMessage());
		}
		return new RegisterRes(null, RegisterRtnCode.FAILURE.getMessage());
	}

	@Override
	public RegisterRes addRole(String account, List<String> roleList) {
		Optional<Register> regOp = registerDao.findById(account);
		if (regOp.isPresent()) {
			Set<String> roleSet = new HashSet<>();
			//�h���Ѽ� roleList �̪����ƭ�
			for(String str : roleList) {
				roleSet.add(str);
			}
//			//�h��DB���w�s�b���ȩM�Ѽƪ��ȡA��̪����Ƴ���
			Register reg = regOp.get();
			String role = reg.getRole(); //�i��|���h�ӡA�γr��(,)�Ϲj; �Ҧp: General, SA, PM
			System.out.println(role);
			String[] roleArray = role.split(",");
			for(String item : roleArray) {
				String str = item.trim();
				roleSet.add(str);
			}
			String newStr = roleSet.toString().substring(1, roleSet.toString().length() - 1);
			reg.setRole(newStr);
			registerDao.save(reg);
			return new RegisterRes(reg, RegisterRtnCode.SUCCESSFUL.getMessage());
		}
		return new RegisterRes(null, RegisterRtnCode.ADD_ROLE_FAILURE.getMessage());
	}

	@Override
	public RegisterRes addRoleSet(String account, Set<String> roleSet) {
		Optional<Register> regOp = registerDao.findById(account);
		if (regOp.isPresent()) {
//			//�h��DB���w�s�b���ȩM�Ѽƪ��ȡA��̪����Ƴ���
			Register reg = regOp.get();
			String role = reg.getRole(); //�i��|���h�ӡA�γr��(,)�Ϲj; �Ҧp: General, SA, PM
			System.out.println(role);
			String[] roleArray = role.split(",");
			for(String item : roleArray) {
				String str = item.trim();
				roleSet.add(str);
			}
			String newStr = roleSet.toString().substring(1, roleSet.toString().length() - 1);
			reg.setRole(newStr);
			registerDao.save(reg);
			return new RegisterRes(reg, RegisterRtnCode.SUCCESSFUL.getMessage());
		}
		return new RegisterRes(null, RegisterRtnCode.ADD_ROLE_FAILURE.getMessage());
	}

}
