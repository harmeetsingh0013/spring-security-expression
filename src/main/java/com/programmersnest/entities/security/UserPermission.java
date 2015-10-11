/**
 * 
 */
package com.programmersnest.entities.security;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.programmersnest.entities.User;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */

@Entity
@Table(name="users_permissions")
public class UserPermission {

	private String id;
	private User user;
	private String url;
	private String permission;
	
	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@ManyToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	
}
