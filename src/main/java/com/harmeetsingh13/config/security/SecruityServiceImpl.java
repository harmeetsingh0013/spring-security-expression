/**
 * 
 */
package com.harmeetsingh13.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.harmeetsingh13.common.CommonEnum;
import com.harmeetsingh13.entities.User;
import com.harmeetsingh13.entities.security.UserPermission;
import com.harmeetsingh13.repo.UserPermissionRepo;

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
		UserPermission permission = userPermissionRepo.findByUserAndUrlAndPermission(user, url, CommonEnum.PERMSSION.ACCESS.getPermission());
		return (permission != null)? true: false;
	}
}
