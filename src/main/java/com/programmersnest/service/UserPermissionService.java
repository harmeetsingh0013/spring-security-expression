/**
 * 
 */
package com.programmersnest.service;

import java.util.List;

import com.programmersnest.entities.security.UserPermission;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */
public interface UserPermissionService {

	public boolean saveBulkUsersPermissions(List<UserPermission> permissions);
	public void deleteUserPermission(String permissionId);
}
