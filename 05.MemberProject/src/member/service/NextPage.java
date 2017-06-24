package member.service;

// 이동할 페이지의 정보를 저장하는 클래스
public class NextPage {
	private String pageName;//이동할 페이지 이름
	private boolean isRedirect;// 이동 방법 true -> 리다이렉트, false -> 포워드
	
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
