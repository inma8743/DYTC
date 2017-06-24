package member.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dto.Member;
import member.model.MemberDAO;

public class MemberRegisterService implements Service {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		// 1.��û �Ķ���� ó��
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gen = request.getParameter("gender");
		String addr = request.getParameter("addr");
		
		// 2. DAO�޼ҵ� ȣ��
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
		// 3.���� ������ ����
		NextPage nextPage = new NextPage();
		if(result == 1){ //ȸ�����Լ���
			nextPage.setPageName("login.jsp");
			nextPage.setRedirect(true); //�����̷�Ʈ ���
		}
		else {
			request.setAttribute("errorMessage", "ȸ�������� �����߽��ϴ�.");
			nextPage.setPageName("error.jsp");
			nextPage.setRedirect(false); //������ ���
		}
		return nextPage;
	}
	
}
