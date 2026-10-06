package com.spring_boot.projectEx.service;

import java.util.HashMap;

import com.spring_boot.projectEx.dto.MemberDTO;

public interface IMemberService {
	public String loginCheck(HashMap<String, Object> map);
	public void insertMember(MemberDTO dto);
	public String idCheck(String id);
	
	public MemberDTO selectMember(String memId);
	public void updateMember(MemberDTO dto);
	public void deleteMember(String memId);
}
