package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ȸ�������� ���� ����Ͻ� ������ �������̽�
public interface Service {
	public abstract NextPage execute(HttpServletRequest request, HttpServletResponse response);
}
