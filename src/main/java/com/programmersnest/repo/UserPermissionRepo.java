/**
 * 
 */
package com.programmersnest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programmersnest.entities.User;
import com.programmersnest.entities.security.UserPermission;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */

@Repository
public interface UserPermissionRepo extends JpaRepository<UserPermission, String>{

	public UserPermission findByUserAndUrl(User user, String url);
	public List<UserPermission> findByUserAndUrlAndPermission(User user, String url, String permission);

}
