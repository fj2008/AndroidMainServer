package dto;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import exception.EmptyMemberInfoException;
import exception.OverflowMemberInfoException;

public class MemberInfo {
	private String id;
	private String pw;
	private String email;
	private String joinDate;
	
	public MemberInfo(HttpServletRequest request) throws EmptyMemberInfoException, OverflowMemberInfoException {
		this.id = request.getParameter("id");
		this.pw = request.getParameter("pw");
		this.email = request.getParameter("email");
		
		if(id == null || pw == null) {
			// 아이디 또는 비밀번호가 전달되지 않았다면은
			throw new EmptyMemberInfoException("아이디 또는 비밀번호가 전달되지 않았습니다.");
		} else if(id.length() > 20 || pw.length() > 16) {
			// 아이디가 20자를 초과했거나 비밀번호가 16자를 초과했다면
			throw new OverflowMemberInfoException("아이디 또는 비밀번호가 지정한 길이를 초과했습니다.");
		} else if(id.trim().length() == 0 || pw.trim().length() == 0) {
			// 아이디 또는 비밀번호가 공백으로만 전달됬다면
			throw new EmptyMemberInfoException("아이디 또는 비밀번호가 전달되지 않았습니다.");
		}
	}
	
	public MemberInfo(HttpServletRequest request, LocalDateTime joinDate) throws EmptyMemberInfoException, OverflowMemberInfoException {
		this(request);
		
		this.joinDate = joinDate.toString();
	}
	
	public MemberInfo(HttpServletRequest request, MemberInfo email) throws EmptyMemberInfoException, OverflowMemberInfoException {
		this(request);
		
		this.email = request.getParameter("email");
	}
	
	public MemberInfo(String id, String pw, String email) {
		this.id = id;
		this.pw = pw;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

}
