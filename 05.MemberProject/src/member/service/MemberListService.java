package member.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dto.Member;
import member.model.MemberDAO;

public class MemberListService implements Service {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// 2. DAO 메소드 호출
		MemberDAO dao = MemberDAO.getInstance();
		List<Member> list =null;
		try {
			list = dao.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 3. 다음페이지이동
		request.setAttribute("list", list);
		NextPage nextPage = new NextPage();
		
		nextPage.setPageName("list.jsp");
		nextPage.setRedirect(false);
		return nextPage;
	}
}
