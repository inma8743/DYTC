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
			System.out.println("��������");
		}
		
		NextPage nextPage = new NextPage();
		System.out.println(result);
		if(result == 1){ //��������
			nextPage.setPageName("list.dytc2");
			nextPage.setRedirect(true); //�����̷�Ʈ ���
		}
		else {
			request.setAttribute("errorMessage", "������ �����Ͽ����ϴ�.");
			nextPage.setPageName("error.jsp");
			nextPage.setRedirect(false); //������ ���
		}
		return nextPage;
	}

}
