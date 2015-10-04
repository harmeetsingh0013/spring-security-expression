package com.harmeetsingh13.service;

import java.util.List;
import java.util.Optional;

import com.harmeetsingh13.entities.User;

/**
 * Created by Harmeet Singh(Taara) on 14/9/15.
 * @version 1.0
 */

public interface UserService {

	public Optional<List<User>> findAllUsersByRole(String role);
	public User findUserById(long userId);
}
