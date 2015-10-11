/**
 * 
 */
package com.programmersnest.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */
@Controller
@RequestMapping(value="/user")
public class UserController {

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value="/dashboard", method=RequestMethod.GET)
	public String dashboard() {
		LOG.info("In dashboard Controller method");
		
		return "user/dashboard";
	}
	
	@RequestMapping(value="/section-one", method=RequestMethod.GET)
	@PreAuthorize(value="@securityService.userHasPermissionForURL(authentication, '/section-one')")
	public String sectionOne() {
		LOG.info("In sectionOne Controller method");
		
		return "user/section-one";
	}
	
	@RequestMapping(value="/section-two", method=RequestMethod.GET)
	@PreAuthorize(value="@securityService.userHasPermissionForURL(authentication, '/section-two')")
	public String sectionTwo() {
		LOG.info("In sectionTwo Controller method");
		
		return "user/section-two";
	}
	
	@RequestMapping(value="/section-three", method=RequestMethod.GET)
	@PreAuthorize(value="@securityService.userHasPermissionForURL(authentication, '/section-three')")
	public String sectionThree() {
		LOG.info("In sectionThree Controller method");
		
		return "user/section-three";
	}
}
