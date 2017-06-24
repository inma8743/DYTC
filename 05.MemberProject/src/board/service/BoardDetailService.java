package board.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.Board;
import board.model.BoardDAO;
import member.dto.Member;
import member.model.MemberDAO;
import member.service.NextPage;
import member.service.Service;

public class BoardDetailService implements Service {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		//1.��û �Ķ���� ó��
		int num = Integer.parseInt(request.getParameter("num"));
		//2.DAO �޼ҵ� ȣ��
		BoardDAO dao = BoardDAO.getInstance();  //=> MemberDAO dao = MemberDAO.getInstance().selectById(id);
		Board board = null;
		try {
			dao.updateReadCount(num);
			board = dao.selectByNum(num);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//3. ���� ������ �̵�
		request.setAttribute("boardDetail", board);
		NextPage nextPage = new NextPage();
		
		nextPage.setPageName("board/boardDetail.jsp");
		nextPage.setRedirect(false);
		return nextPage;
	}

}
