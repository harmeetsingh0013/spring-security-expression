package com.programmersnest.repo;

import com.programmersnest.dtos.UserPermissionsDto;
import com.programmersnest.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by james on 14/9/15.
 */

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    public List<User> findByEmail(String email);
	public List<User> findByRole(String role);
	@Query(value="SELECT new com.harmeetsingh13.dtos.UserPermissionsDto(user.id, perm.id, user.name, user.email, perm.url, perm.permission) FROM "
			+ "UserPermission AS perm RIGHT OUTER JOIN perm.user AS user WHERE user.role = :role")
	public List<UserPermissionsDto> findAllUsersPermissionsByRole(@Param("role")String role);
}
