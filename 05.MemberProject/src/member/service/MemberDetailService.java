package member.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dto.Member;
import member.model.MemberDAO;

public class MemberDetailService implements Service {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//1.��û �Ķ���� ó��
		String id = request.getParameter("id");
		//2.DAO �޼ҵ� ȣ��
		MemberDAO dao = MemberDAO.getInstance();  //=> MemberDAO dao = MemberDAO.getInstance().selectById(id);
		Member member = null;
		try {
			member = dao.selectById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//3. ���� ������ �̵�
		request.setAttribute("detail", member);
		NextPage nextPage = new NextPage();
		
		nextPage.setPageName("detail.jsp");
		nextPage.setRedirect(false);
		return nextPage;
	}

}
