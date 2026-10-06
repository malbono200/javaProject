package com.spring_boot_mini_project.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring_boot_mini_project.dao.IMemberDAO;
import com.spring_boot_mini_project.dto.MemberDTO;


@Service
@Qualifier("MemberService")
public class MemberService implements IMemberService {
	@Autowired
	@Qualifier("IMemberDAO")
	IMemberDAO dao;
	
	@Autowired
	PasswordEncoder pwdEncoder;

	@Override
	public String loginCheck(HashMap<String, Object> map) {
		String encodedPwd = dao.loginCheck((String)map.get("id")); 
		String result = "fail";
		if(encodedPwd != null && pwdEncoder.matches((String)map.get("pwd"), encodedPwd)) {
			result = "success";
		}
		System.out.println(result);
		return result;
	}

	@Override
	public void insertMember(MemberDTO dto) {
		String encodedPwd = pwdEncoder.encode(dto.getMemPwd());
		dto.setMemPwd(encodedPwd);
		dao.insertMember(dto);
	}

	@Override
	public String idCheck(String id) {
		return dao.idCheck(id);
	}

	@Override
	public MemberDTO selectMember(String memId) {
		return dao.selectMember(memId);
	}

	@Override
	public void updateMember(MemberDTO dto) {
		if(dto.getMemPwd() != null && !dto.getMemPwd().isEmpty()) {
			dto.setMemPwd(pwdEncoder.encode(dto.getMemPwd()));
		}
		dao.updateMember(dto);
	}

	@Override
	public void deleteMember(String memId) {
		dao.deleteMemberOrderProduct(memId);
		dao.deleteMemberOrderInfo(memId);
		dao.deleteMemberCart(memId);
		dao.deleteMember(memId);
	}
	
	
}
