package com.epam.quizapp.util;

import java.lang.reflect.Method;

import com.epam.quizapp.annotation.Render;

public class Renderer {

	private Renderer() {
	}
	
	public static void render(Class<?> page) {
		Method[] methods = page.getDeclaredMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(Render.class)) {
				try {
					method.invoke(page.getConstructor().newInstance());
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}

}
