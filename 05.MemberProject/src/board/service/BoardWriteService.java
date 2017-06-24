package board.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.dto.Board;
import board.model.BoardDAO;
import member.model.MemberDAO;
import member.service.NextPage;
import member.service.Service;

public class BoardWriteService implements Service {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
/*		// 1.��û�Ķ���� ó��
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String fileName = request.getParameter("fileName");
		
		// 2. DAO methodȣ��
		Board board = new Board();
		board.setContent(content);
		board.setFileName(fileName);
		board.setId(id);
		board.setSubject(title);
		
		BoardDAO dao = BoardDAO.getInstance();
		int result = 0;
		try {
			result=dao.insert(board);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		// 3.���� ������ ����
		NextPage nextPage = new NextPage();
		if(result == 1){ //ȸ�����Լ���
			nextPage.setPageName("/board/boardList.jsp");
			nextPage.setRedirect(false); 
		}
		else {
			request.setAttribute("errorMessage", "ȸ�������� �����߽��ϴ�.");
			nextPage.setPageName("error.jsp");
			nextPage.setRedirect(false); //������ ���
		}
		
		return nextPage;*/
		
		String path=request.getServletContext().getRealPath("./upload");
		System.out.println(path);
		String id = null;
		String subject = null;
		String content = null;
		Enumeration files = null;
		
		String fileSystemName = null;
		String fileOriginalName = null;
		//request, ���� ���, ���� �ִ�ũ��, ���ڵ� ���, ���� �ߺ��� �����̸� ����
		try {
			MultipartRequest multi = new MultipartRequest(request, path, 10 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy() );
			id = multi.getParameter("id");
			subject = multi.getParameter("title");
			content = multi.getParameter("content");
			
			files = multi.getFileNames();
			
			while(files.hasMoreElements()){
				String file = (String) files.nextElement();
				
				fileSystemName = multi.getFilesystemName(file);
				fileOriginalName = multi.getOriginalFileName(file);
				
				System.out.println(fileSystemName);
				System.out.println(fileOriginalName);
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Board board = new Board();
		board.setContent(content);
		board.setFileName(fileSystemName);
		board.setId(id);
		board.setSubject(subject);
		
		BoardDAO dao = BoardDAO.getInstance();
		int result = 0;
		try {
			result=dao.insert(board);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		// 3.���� ������ ����
		NextPage nextPage = new NextPage();
		if(result == 1){ // �۾��� ����
			nextPage.setPageName("list.dytc2");
			nextPage.setRedirect(false); 
		}
		else {
			request.setAttribute("errorMessage", "�۾��Ⱑ �����߽��ϴ�.");
			nextPage.setPageName("error.jsp");
			nextPage.setRedirect(false); //������ ���
		}
		
		return nextPage;
	}
}
