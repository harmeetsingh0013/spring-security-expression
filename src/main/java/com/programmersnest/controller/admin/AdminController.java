/**
 * 
 */
package com.programmersnest.controller.admin;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.programmersnest.common.CommonEnum;
import com.programmersnest.dtos.UserPermissionsDto;
import com.programmersnest.entities.User;
import com.programmersnest.entities.security.UserPermission;
import com.programmersnest.service.UserPermissionService;
import com.programmersnest.service.UserService;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */

@Controller
@RequestMapping(value="/admin")
public class AdminController {

	private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserPermissionService userPermissionService;
	
	@RequestMapping(value="/dashboard", method=RequestMethod.GET)
	public String dashboard(Model model) {
		LOG.info("In dashboard Controller method");
		
		List<UserPermissionsDto> permissions =  userService.findAllUsersPermissionsByRole(CommonEnum.USER_ROLE.USER.getRole());
		Optional<List<User>> optional = userService.findAllUsersByRole(CommonEnum.USER_ROLE.USER.getRole());
		optional.ifPresent(users -> model.addAttribute("users", users));
		model.addAttribute("permissions", permissions);
		return "admin/dashboard";
	}
	
	@RequestMapping(value="/assign-persmissions", method=RequestMethod.POST)
	public String assignPermissions(long[] userIds, String[] urls, String[] permissions, Model model) {
		LOG.info("In assignPermissions Controller method");
		
		List<UserPermission> userPermissions = IntStream.range(0, userIds.length)
				.<UserPermission>mapToObj(counter -> {
					UserPermission permission = new UserPermission();
					permission.setId(UUID.randomUUID().toString());
					permission.setUser(userService.findUserById(userIds[counter]));
					permission.setUrl(urls[counter]);
					permission.setPermission(permissions[counter]);
					return permission;
				}).collect(Collectors.toList());
		boolean result = userPermissionService.saveBulkUsersPermissions(userPermissions);
		if(!result) model.addAttribute("error", "User Already Have Same URL Permssions");
		return "redirect:/admin/dashboard";
	}
	
	@RequestMapping(value="/delete-permission", method=RequestMethod.GET)
	public String deletePermission(String permissionId) {
		LOG.info("In deletePermission Controller method");
		
		userPermissionService.deleteUserPermission(permissionId);
		return "redirect:/admin/dashboard";
	}
}
