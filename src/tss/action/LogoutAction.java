package tss.action;

import java.io.UnsupportedEncodingException;


public class LogoutAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7243871542697239236L;

	public String execute(){
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset='utf-8'");
			request.getSession().invalidate();
			
			System.out.println("success!!!");
			return SUCCESS;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}
