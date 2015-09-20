/**
 * 
 */
package com.harmeetsingh13.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
}
