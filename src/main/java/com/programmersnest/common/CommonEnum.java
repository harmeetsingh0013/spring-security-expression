/**
 * 
 */
package com.programmersnest.common;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */
public class CommonEnum {

	public enum PERMSSION{
		ACCESS("ACCESS"), DENIED("DENIED");
		
		private String permssion;
		private PERMSSION(String permission){
			this.permssion = permission;
		}
		
		public String getPermission(){
			return this.permssion;
		}
	}
	
	public enum USER_ROLE{
		USER("ROLE_USER"), ADMIN("ROLE_ADMIN");
		
		private String role;
		private USER_ROLE(String role){
			this.role = role;
		}
		
		public String getRole(){
			return this.role;
		}
	}
}
