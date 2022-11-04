package com.annotation.bean_dependency;

public class College {
	
	private Principal principal;

	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}
	
	public void helloPrincipal() {
		System.out.println(principal);
	}
	
}
