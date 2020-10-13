package com.lea.kumiko.midware.others.reflection;

import java.lang.reflect.ReflectPermission;

public class Reflector {


	public static boolean canControlMemberAccessible(){
		try{
			SecurityManager securityManager = System.getSecurityManager();
			if(securityManager != null){
				securityManager.checkPermission(new ReflectPermission("suppressAccessChecks"));
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
