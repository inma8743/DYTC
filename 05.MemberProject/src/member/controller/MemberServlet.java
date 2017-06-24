package member.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dto.Member;
import member.model.MemberDAO;
import member.service.MemberDetailService;
import member.service.MemberListService;
import member.service.MemberLoginService;
import member.service.MemberRegisterService;
import member.service.NextPage;
import member.service.Service;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("*.dytc")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("MeberServlet doGet()");
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String cmd=uri.substring(path.length()+1);
		
		/*System.out.println(uri);
		System.out.println(path);*/
		System.out.println(cmd);
		
		HttpSession session = request.getSession();
		// 1. URL�� ��� �б� -------------------------------------------------------------------------------------------------
		Service service = null;
		NextPage nextPage = null;
		switch(cmd){
		//ȸ������
		case "register.dytc" : 
			System.out.println("ȸ������");
			service = new MemberRegisterService();
			nextPage = service.execute(request, response);
			break;
		//�α���
		case "login.dytc" : 
			System.out.println("�α���");
			service = new MemberLoginService();
			nextPage = service.execute(request, response);
			break;
		//�α׾ƿ�
		case "logout.dytc" :
			System.out.println("�α׾ƿ�");
			session.invalidate();
			response.sendRedirect("index.jsp");
			break;
		//����Ʈ
		case "list.dytc" : 
			System.out.println("����Ʈ");
			//MemberDAO dao = MemberDAO.getInstance();
			//dao.selectAll();
			service = new MemberListService();
			nextPage = service.execute(request, response);
			break;
		//��������
		case "detail.dytc" : 
			System.out.println("��������");
			service = new MemberDetailService();
			nextPage = service.execute(request, response);
			break;
		case "delete.dytc" : 
			System.out.println("����");
			break;
		
		}
		//2. ���������� �̵�----------------------------------------------
		if(nextPage != null){
			//�����̷�Ʈ
			if(nextPage.isRedirect() == true){//==true ���� ����
				response.sendRedirect(nextPage.getPageName());
			}
			//������
			else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage.getPageName());
				dispatcher.forward(request, response);
			}
		}
		else{
			System.out.println("Null�̴�!");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
