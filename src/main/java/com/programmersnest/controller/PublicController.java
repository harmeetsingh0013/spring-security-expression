/**
 * 
 */
package com.programmersnest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */

@Controller
@RequestMapping(value="/")
public class PublicController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
}
