package com.harmeetsingh13.repo;

import com.harmeetsingh13.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by james on 14/9/15.
 */

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    public List<User> findByEmail(String email);
	public List<User> findByRole(String role);
}
