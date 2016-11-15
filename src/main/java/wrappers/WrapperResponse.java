package wrappers;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class WrapperResponse extends HttpServletResponseWrapper{

	public WrapperResponse(HttpServletResponse response) {
		super(response);
	}
	
	@Override 
	public void sendRedirect(String param){
		
	}

}

