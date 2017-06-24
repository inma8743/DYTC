package board.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.Board;
import board.model.BoardDAO;
import member.service.NextPage;
import member.service.Service;

public class BoardListService implements Service {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// 2. DAO 메소드 호출
		BoardDAO dao = BoardDAO.getInstance();
		List<Board> boardList =null;
		try {
			boardList = dao.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		// 3. 다음페이지이동		
		request.setAttribute("boardList", boardList);
		NextPage nextPage = new NextPage();
				
		nextPage.setPageName("/board/boardList.jsp");
		nextPage.setRedirect(false);
		return nextPage;
	}
}
