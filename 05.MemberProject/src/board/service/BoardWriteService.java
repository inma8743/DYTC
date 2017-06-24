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
/*		// 1.요청파라미터 처리
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String fileName = request.getParameter("fileName");
		
		// 2. DAO method호출
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
		// 3.다음 페이지 설정
		NextPage nextPage = new NextPage();
		if(result == 1){ //회원가입성공
			nextPage.setPageName("/board/boardList.jsp");
			nextPage.setRedirect(false); 
		}
		else {
			request.setAttribute("errorMessage", "회원가입이 실패했습니다.");
			nextPage.setPageName("error.jsp");
			nextPage.setRedirect(false); //포워드 방식
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
		//request, 실제 경로, 파일 최대크기, 인코딩 방식, 파일 중복시 파일이름 변경
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
		// 3.다음 페이지 설정
		NextPage nextPage = new NextPage();
		if(result == 1){ // 글쓰기 성공
			nextPage.setPageName("list.dytc2");
			nextPage.setRedirect(false); 
		}
		else {
			request.setAttribute("errorMessage", "글쓰기가 실패했습니다.");
			nextPage.setPageName("error.jsp");
			nextPage.setRedirect(false); //포워드 방식
		}
		
		return nextPage;
	}
}
