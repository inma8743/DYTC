package member.service;

// �̵��� �������� ������ �����ϴ� Ŭ����
public class NextPage {
	private String pageName;//�̵��� ������ �̸�
	private boolean isRedirect;// �̵� ��� true -> �����̷�Ʈ, false -> ������
	
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}	
}
