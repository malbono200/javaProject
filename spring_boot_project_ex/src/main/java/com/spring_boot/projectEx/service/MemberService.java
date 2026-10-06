package com.spring_boot.projectEx.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring_boot.projectEx.dao.IMemberDAO;
import com.spring_boot.projectEx.dto.MemberDTO;

@Service
@Qualifier("MemberService")
public class MemberService implements IMemberService {

	@Autowired
	@Qualifier("IMemberDAO")
	IMemberDAO dao;
	
	@Autowired
	PasswordEncoder pwdEncoder; //BCrypt 해시 encoder가 주입되도록 config 클래스에서 Bean 생성했음
	
	@Override
	public String loginCheck(HashMap<String, Object> map) {
		String encodedPwd = dao.loginCheck((String)map.get("id")); //해당 id의 회원이 있으면 암호화된 비밀번호 반환
		String result = "fail";
		if(encodedPwd != null && pwdEncoder.matches((String)map.get("pwd"), encodedPwd)) {
			result = "success";
		}
		System.out.println(result);
		return result;
		//return dao.loginCheck(map);
	}

	@Override
	public void insertMember(MemberDTO dto) {
		String encodedPwd = pwdEncoder.encode(dto.getMemPwd()); //평문 비밀번호를 암호화
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
		//비밀번호를 입력한 경우에만 암호화 (비어 있으면 mapper에서 비밀번호 수정 제외)
		if(dto.getMemPwd() != null && !dto.getMemPwd().isEmpty()) {
			dto.setMemPwd(pwdEncoder.encode(dto.getMemPwd()));
		}
		dao.updateMember(dto);
	}

	@Override
	@Transactional
	public void deleteMember(String memId) {
		dao.deleteMemberOrderProduct(memId);
		dao.deleteMemberOrderInfo(memId);
		dao.deleteMemberCart(memId);
		dao.deleteMember(memId);
	}
	
	
}
