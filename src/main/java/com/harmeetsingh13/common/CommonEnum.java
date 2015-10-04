/**
 * 
 */
package com.harmeetsingh13.common;

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
}
