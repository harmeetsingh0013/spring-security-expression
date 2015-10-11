package com.programmersnest.service;

import java.util.List;
import java.util.Optional;

import com.programmersnest.dtos.UserPermissionsDto;
import com.programmersnest.entities.User;

/**
 * Created by Harmeet Singh(Taara) on 14/9/15.
 * @version 1.0
 */

public interface UserService {

	public Optional<List<User>> findAllUsersByRole(String role);
	public User findUserById(long userId);
	public List<UserPermissionsDto> findAllUsersPermissionsByRole(String role);
}
