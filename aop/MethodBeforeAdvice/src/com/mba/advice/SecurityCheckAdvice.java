package com.mba.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import com.mba.security.beans.SecurityHelper;

public class SecurityCheckAdvice implements MethodBeforeAdvice {
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		SecurityHelper securityHelper = null;
		System.out.println("SecurityAdviceCheck");
		securityHelper = SecurityHelper.getInstance();
		if (securityHelper.authenticate() == false) {
			throw new IllegalAccessException("invalid un/pwd");
		}
		
	}
}
