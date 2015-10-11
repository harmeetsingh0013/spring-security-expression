package com.programmersnest.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programmersnest.dtos.UserPermissionsDto;
import com.programmersnest.entities.User;
import com.programmersnest.repo.UserRepo;
import com.programmersnest.service.UserService;

/**
 * Created by Harmeet Singh(Taara) on 14/9/15.
 * @version 1.0
 */

@Service
public class UserServiceImpl implements UserService{

	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public Optional<List<User>> findAllUsersByRole(String role) {
		LOG.info("In findAllUsersByRole service method");
		
		List<User> users = userRepo.findByRole(role);
		return Optional.of(users);
	}

	@Override
	public User findUserById(long userId) {
		LOG.info("In findUserById service method");
		
		return userRepo.findOne(userId);
	}

	@Override
	public List<UserPermissionsDto> findAllUsersPermissionsByRole(String role) {
		LOG.info("In findAllUsersPermissionsByRole service method");
		
		return userRepo.findAllUsersPermissionsByRole(role);
	}
}
