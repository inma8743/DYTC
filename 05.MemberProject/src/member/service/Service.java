package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 회원관리를 위한 비즈니스 계층의 인터페이스
public interface Service {
	public abstract NextPage execute(HttpServletRequest request, HttpServletResponse response);
}
