package board.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import member.model.MemberDAO;
import member.service.NextPage;
import member.service.Service;

public class BoardDeleteService implements Service{

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDAO dao = BoardDAO.getInstance();
		int result = 0;
		try {
			result=dao.deleteByNum(num);
		} catch (SQLException e) {
			System.out.println("삭제에러");
		}
		
		NextPage nextPage = new NextPage();
		System.out.println(result);
		if(result == 1){ //삭제성공
			nextPage.setPageName("list.dytc2");
			nextPage.setRedirect(true); //리다이렉트 방식
		}
		else {
			request.setAttribute("errorMessage", "삭제에 실패하였습니다.");
			nextPage.setPageName("error.jsp");
			nextPage.setRedirect(false); //포워드 방식
		}
		return nextPage;
	}

}
