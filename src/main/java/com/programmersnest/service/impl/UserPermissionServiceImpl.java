/**
 * 
 */
package com.programmersnest.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programmersnest.entities.security.UserPermission;
import com.programmersnest.repo.UserPermissionRepo;
import com.programmersnest.service.UserPermissionService;

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
	public boolean saveBulkUsersPermissions(List<UserPermission> permissions) {
		LOG.info("In saveBulkUsersPermissions service method");
		try{
			userPermissionRepo.save(permissions);
			return true;
		}catch(Exception ex) {
			return false;
		}
		
	}

	@Override
	public void deleteUserPermission(String permissionId) {
		LOG.info("In saveBulkUsersPermissions service method");
		
		userPermissionRepo.delete(permissionId);
	}

}
