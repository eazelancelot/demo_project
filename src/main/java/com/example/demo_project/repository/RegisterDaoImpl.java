package com.example.demo_project.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo_project.entity.Register;

public class RegisterDaoImpl extends BaseDao {

	/*
	 * do query
	 */
	public List<Register> doQueryByExpiredRegTime(Date date) {
		StringBuffer sb = new StringBuffer();
        sb.append(" select R from Register R")
          .append(" where R.regTime > :expiredDate");
        Map<String, Object> params = new HashMap<>();
        params.put("expiredDate", date);
        return doQuery(sb.toString(), params, Register.class);
	}
	
	/*
	 * do query with page size
	 */
	public List<Register> doQueryByExpiredRegTime(Date date, int pageSize) {
		StringBuffer sb = new StringBuffer();
        sb.append(" select R from Register R")
          .append(" where R.regTime > :expiredDate");
        Map<String, Object> params = new HashMap<>();
        params.put("expiredDate", date);
        return doQuery(sb.toString(), params, Register.class, pageSize);
	}
	
	/*
	 * do query with page size and start position
	 */
	public List<Register> doQueryByExpiredRegTime(Date date, int pageSize, int startPosition) {
		StringBuffer sb = new StringBuffer();
        sb.append(" select R from Register R")
          .append(" where R.regTime > :expiredDate");
        Map<String, Object> params = new HashMap<>();
        params.put("expiredDate", date);
        return doQuery(sb.toString(), params, Register.class, pageSize, startPosition);
	}
	
	public List<Register> doNativeQueryByExpiredRegTime(Date date, int pageSize, int startPosition) {
		StringBuffer sb = new StringBuffer();
        sb.append(" select * from register r");
        sb.append(" where r.reg_time > :expiredDate");
        Map<String, Object> params = new HashMap<>();
        params.put("expiredDate", date);
        return doNativeQuery(sb.toString(), params, Register.class, pageSize, startPosition);
	}
	
	//================= update
	public int updateAgeByName(String name, int newAge) {
        StringBuffer sb = new StringBuffer();
        sb.append(" update Register set age = :age");
        sb.append(" where name = :newName");
        Map<String, Object> params = new HashMap<>();
        params.put("age", newAge);
        params.put("newName", name);
        return doUpdate(sb.toString(), params);
	}
	
	public int updateAgeByAccount(String account, int newAge) {
        StringBuffer sb = new StringBuffer();
        sb.append(" update Register set age = :age");
        sb.append(" where account = :account");
        Map<String, Object> params = new HashMap<>();
        params.put("age", newAge);
        params.put("account", account);
        return doUpdate(sb.toString(), params);
	}
	
	//================= native update
	public int nativeUpdateAgeByName(String name, int newAge) {
        StringBuffer sb = new StringBuffer();
        sb.append(" update register set age = :age");
        sb.append(" where name = :newName");
        Map<String, Object> params = new HashMap<>();
        params.put("age", newAge);
        params.put("newName", name);
        return doNativeUpdate(sb.toString(), params);
	}
	
	public int nativeUpdateAgeByAccount(String account, int newAge) {
        StringBuffer sb = new StringBuffer();
        sb.append(" update register set age = :age");
        sb.append(" where account = :account");
        Map<String, Object> params = new HashMap<>();
        params.put("age", newAge);
        params.put("account", account);
        return doNativeUpdate(sb.toString(), params);
	}
	
	public List<Register> doQueryRoleContains(List<String> roleList) {
		Map<String, Object> params = new HashMap<>();
		StringBuffer sb = new StringBuffer();
        sb.append(" select * from register r");
        sb.append(" where");
        for (int i = 0; i < roleList.size(); i++) {
        	String item = roleList.get(i);
        	if (i < roleList.size() -1) {
        		sb.append(" role like :role" + i + " or ");
        	} else {
        		sb.append(" role like :role" + i);
        	}
        	params.put("role" + i, "%" + item + "%");
        }
        System.out.println(sb.toString());       
        return doNativeQuery(sb.toString(), params, Register.class, -1, 0);
	}

}
