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
		// 1. URL별 기능 분기 -------------------------------------------------------------------------------------------------
		Service service = null;
		NextPage nextPage = null;
		switch(cmd){
		//회원가입
		case "register.dytc" : 
			System.out.println("회원가입");
			service = new MemberRegisterService();
			nextPage = service.execute(request, response);
			break;
		//로그인
		case "login.dytc" : 
			System.out.println("로그인");
			service = new MemberLoginService();
			nextPage = service.execute(request, response);
			break;
		//로그아웃
		case "logout.dytc" :
			System.out.println("로그아웃");
			session.invalidate();
			response.sendRedirect("index.jsp");
			break;
		//리스트
		case "list.dytc" : 
			System.out.println("리스트");
			//MemberDAO dao = MemberDAO.getInstance();
			//dao.selectAll();
			service = new MemberListService();
			nextPage = service.execute(request, response);
			break;
		//상세페이지
		case "detail.dytc" : 
			System.out.println("상세페이지");
			service = new MemberDetailService();
			nextPage = service.execute(request, response);
			break;
		case "delete.dytc" : 
			System.out.println("삭제");
			break;
		
		}
		//2. 다음페이지 이동----------------------------------------------
		if(nextPage != null){
			//리다이렉트
			if(nextPage.isRedirect() == true){//==true 생략 가능
				response.sendRedirect(nextPage.getPageName());
			}
			//포워드
			else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage.getPageName());
				dispatcher.forward(request, response);
			}
		}
		else{
			System.out.println("Null이다!");
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
