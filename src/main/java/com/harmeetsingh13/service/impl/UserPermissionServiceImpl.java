/**
 * 
 */
package com.harmeetsingh13.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harmeetsingh13.entities.security.UserPermission;
import com.harmeetsingh13.repo.UserPermissionRepo;
import com.harmeetsingh13.service.UserPermissionService;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */
@Service
public class UserPermissionServiceImpl implements UserPermissionService{

	private static final Logger LOG = LoggerFactory.getLogger(UserPermissionServiceImpl.class);
	
	@Autowired
	private UserPermissionRepo userPermissionRepo;
	
	@Override
	public void saveBulkUsersPermissions(List<UserPermission> permissions) {
		LOG.info("In saveBulkUsersPermissions service method");
		
		userPermissionRepo.save(permissions);
	}

}
