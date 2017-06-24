package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardDeleteService;
import board.service.BoardDetailService;
import board.service.BoardListService;
import board.service.BoardWriteService;
import member.service.MemberRegisterService;
import member.service.NextPage;
import member.service.Service;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("*.dytc2")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Board doGet()");
		// 1. URL별 기능 분기 -------------------------------------------------------------------------------------------------
		Service service = null;
		NextPage nextPage = null;
		
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String cmd=uri.substring(path.length()+1); //경로때문에 (/board)+6이 되서
		System.out.println(cmd);	//경로
		
		switch(cmd){
		case "write.dytc2":
			System.out.println("글쓰기");
			service = new BoardWriteService();
			nextPage = service.execute(request, response);
			break;
		case "list.dytc2" : 
			System.out.println("게시판 리스트");
			service = new BoardListService();
			nextPage = service.execute(request, response);
			break;
		case "detail.dytc2":
			System.out.println("게시판 디테일리스트");
			service = new BoardDetailService();
			nextPage = service.execute(request, response);
			break;
		case "delete.dytc2": 
			System.out.println("게시판 글 삭제");
			service = new BoardDeleteService();
			nextPage = service.execute(request, response);
			break;
		}
		//2. 다음페이지 이동----------------------------------------------
		if(nextPage != null){
			//리다이렉트
			if(nextPage.isRedirect()){//==true 생략 가능
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
