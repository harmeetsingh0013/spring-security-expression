/**
 * 
 */
package com.programmersnest.dtos;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */

public class UserPermissionsDto {

	private long userId;
	private String permissionId;
	private String name;
	private String email;
	private String url;
	private String permission;
	
	public UserPermissionsDto(long userId, String permissionId, String name, String email, String url, String permission) {
		this.userId = userId;
		this.permissionId = permissionId;
		this.name = name;
		this.email = email;
		this.url = url;
		this.permission = permission;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
