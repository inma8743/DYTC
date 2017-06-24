package member.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dto.Member;
import member.model.MemberDAO;

public class MemberLoginService implements Service {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//1.요청 파라미터 처리
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = null;
		//2.DAO 메소드 호출
		MemberDAO dao = MemberDAO.getInstance();  //=> MemberDAO dao = MemberDAO.getInstance().selectById(id);
		try {
			name = dao.login(id, pwd);
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
				
		//3. 다음 페이지 이동
		//로그인 성공 main.jsp
		//로그인 실패 error.jsp
		if(name==null){
			request.setAttribute("errorMessage", "로그인에 실패하셨습니다");
			NextPage nextPage = new NextPage();
			nextPage.setPageName("error.jsp");
			nextPage.setRedirect(false);
			return nextPage;
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			NextPage nextPage = new NextPage();
			nextPage.setPageName("index.jsp");
			nextPage.setRedirect(false);
			return nextPage;
		}
		
	}
}

