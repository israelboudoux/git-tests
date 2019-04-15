package com.tests.generics;

import java.lang.reflect.ParameterizedType;

public class A <T extends Blablabla> {
	
	public final Class<T> clazz;
	
	public A() {
		this.clazz = getGenericClass();
	}
	
	@SuppressWarnings("unchecked")
	private Class<T> getGenericClass() {
		if(this.getClass().getGenericSuperclass() instanceof ParameterizedType) {
			throw new IllegalStateException("It was not possible to discover the Type of the Storage Record!");
		}
		
		return (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
}
