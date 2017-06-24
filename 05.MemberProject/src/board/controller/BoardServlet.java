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
		// 1. URL�� ��� �б� -------------------------------------------------------------------------------------------------
		Service service = null;
		NextPage nextPage = null;
		
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String cmd=uri.substring(path.length()+1); //��ζ����� (/board)+6�� �Ǽ�
		System.out.println(cmd);	//���
		
		switch(cmd){
		case "write.dytc2":
			System.out.println("�۾���");
			service = new BoardWriteService();
			nextPage = service.execute(request, response);
			break;
		case "list.dytc2" : 
			System.out.println("�Խ��� ����Ʈ");
			service = new BoardListService();
			nextPage = service.execute(request, response);
			break;
		case "detail.dytc2":
			System.out.println("�Խ��� �����ϸ���Ʈ");
			service = new BoardDetailService();
			nextPage = service.execute(request, response);
			break;
		case "delete.dytc2": 
			System.out.println("�Խ��� �� ����");
			service = new BoardDeleteService();
			nextPage = service.execute(request, response);
			break;
		}
		//2. ���������� �̵�----------------------------------------------
		if(nextPage != null){
			//�����̷�Ʈ
			if(nextPage.isRedirect()){//==true ���� ����
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
