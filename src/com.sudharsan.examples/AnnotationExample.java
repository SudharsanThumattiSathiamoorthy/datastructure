package com.sudharsan.examples;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.sudharsan.examples.TesterInfo.Priority;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {
	boolean isEnabled() default true;
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface TesterInfo {
	
	public enum Priority {
		HIGH,
		MEDIUM,
		LOW;
	};
	
	Priority priority() default Priority.LOW;
	String[] tags() default StringUtils.EMPTY;
	String createdBy() default "Sudharsan";
}

@TesterInfo(priority = Priority.HIGH, createdBy = "Sudharsan", tags = "MongoDB")
class TestExample {
	
	@Test
	void testA() {
		if (true) 
			throw new RuntimeException("This test fails always");
	}
	
	@Test 
	public void testB() {
		if (false) 
			throw new RuntimeException("This test will always succeed.");
	}
	
	@Test(isEnabled = false)
	void testC() {
		if (10 > 1) {
			
		}
	}
}

public class AnnotationExample {

	public static void main(final String... args) {
		
		Class<TestExample> obj = TestExample.class;
		
		if (obj.isAnnotationPresent(TesterInfo.class)) {
			
			final Annotation annotation = obj.getAnnotation(TesterInfo.class);
			final TesterInfo testerInfo = (TesterInfo) annotation;
			
			System.out.println("Priority : " + testerInfo.priority());
			System.out.println("Priority : " + testerInfo.createdBy());
			
			System.out.println(Arrays.asList(testerInfo.tags()).stream().collect(Collectors.joining(",")));
		}
		
		Arrays.asList(obj.getDeclaredMethods())
		.stream()
		.filter(m -> m.isAnnotationPresent(Test.class))
		.forEach(m -> {
			final Annotation annotation = m.getAnnotation(Test.class);
			final Test test = (Test)annotation;
			
			if (test.isEnabled()) {
				
			}
		});
		
	}
}
