/**
 * 
 */
package com.programmersnest.config.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.programmersnest.common.CommonEnum;
import com.programmersnest.entities.User;
import com.programmersnest.entities.security.UserPermission;
import com.programmersnest.repo.UserPermissionRepo;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */

@Component(value="securityService")
public class SecruityServiceImpl {

	@Autowired
	private UserPermissionRepo userPermissionRepo;
	
	public boolean userHasPermissionForURL(final Authentication auth, String url) {
		User user = (User) auth.getPrincipal();
		List<UserPermission> permissions = userPermissionRepo.findByUserAndUrlAndPermission(user, url, CommonEnum.PERMSSION.ACCESS.getPermission());
		return (permissions != null && !permissions.isEmpty())? true: false;
	}
}
