package br.com.OPT_WEB_002.util;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ViewExpired {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;
	
		try{
		
			chain.doFilter(request, response);
		}catch(javax.faces.application.ViewExpiredException e){
		
			request.setAttribute("erro", e.getMessage());
			httpResponse.sendRedirect(httpRequest.getContextPath()+"error.xhtml");
			
		}catch(Exception e1){
			
			request.setAttribute("erro", e1.getMessage());
			httpResponse.sendRedirect(httpRequest.getContextPath()+"error.xhtml");
			return;
		}
		
		
	}

	


}