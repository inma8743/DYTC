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
		//1.��û �Ķ���� ó��
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = null;
		//2.DAO �޼ҵ� ȣ��
		MemberDAO dao = MemberDAO.getInstance();  //=> MemberDAO dao = MemberDAO.getInstance().selectById(id);
		try {
			name = dao.login(id, pwd);
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
				
		//3. ���� ������ �̵�
		//�α��� ���� main.jsp
		//�α��� ���� error.jsp
		if(name==null){
			request.setAttribute("errorMessage", "�α��ο� �����ϼ̽��ϴ�");
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

