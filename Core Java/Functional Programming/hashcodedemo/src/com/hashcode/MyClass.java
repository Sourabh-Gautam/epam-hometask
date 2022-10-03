package com.hashcode;

import java.util.Objects;

public class MyClass {
	String name;
	
	public MyClass(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		System.out.println("Hashcode invoked");
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyClass other = (MyClass) obj;
		return Objects.equals(name, other.name);
	}
	
}
