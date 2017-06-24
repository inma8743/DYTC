package member.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dto.Member;
import member.model.MemberDAO;

public class MemberRegisterService implements Service {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		// 1.요청 파라미터 처리
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gen = request.getParameter("gender");
		String addr = request.getParameter("addr");
		
		// 2. DAO메소드 호출
		Member member = new Member();
		member.setId(id);
		member.setPassword(pw);
		member.setName(name);
		member.setAge(age);
		member.setGender(gen);
		member.setAddr(addr);
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = 0;
		try {
			result=dao.insert(member);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 3.다음 페이지 설정
		NextPage nextPage = new NextPage();
		if(result == 1){ //회원가입성공
			nextPage.setPageName("login.jsp");
			nextPage.setRedirect(true); //리다이렉트 방식
		}
		else {
			request.setAttribute("errorMessage", "회원가입이 실패했습니다.");
			nextPage.setPageName("error.jsp");
			nextPage.setRedirect(false); //포워드 방식
		}
		return nextPage;
	}
	
}
