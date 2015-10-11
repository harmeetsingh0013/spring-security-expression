/**
 * 
 */
package com.programmersnest.config.security.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.stereotype.Component;

import com.programmersnest.entities.security.SecureUser;


/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */

@Component
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private static final Logger LOG = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws ServletException, IOException {
		LOG.info("in onAuthenticationSuccess method");
		
		DefaultSavedRequest defaultSavedRequest = (DefaultSavedRequest) request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST_KEY");
		if(defaultSavedRequest != null){
			String requestURL = defaultSavedRequest.getRedirectUrl() +"?"+ defaultSavedRequest.getQueryString();
			getRedirectStrategy().sendRedirect(request, response, requestURL);
		}else{
	        HttpSession session = request.getSession();  
	        SecureUser authUser = (SecureUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        session.setAttribute("username", authUser.getName());  
	        session.setAttribute("authorities", authentication.getAuthorities());  
	        response.setStatus(HttpServletResponse.SC_OK);  
	        if(authUser.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equalsIgnoreCase("ROLE_USER"))){
	        	getRedirectStrategy().sendRedirect(request, response, "/user/dashboard");
	        }else{
	        	getRedirectStrategy().sendRedirect(request, response, "/admin/dashboard");
	        }
	        
		}
	}
}
