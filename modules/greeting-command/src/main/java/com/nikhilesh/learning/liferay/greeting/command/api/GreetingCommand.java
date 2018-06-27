package com.nikhilesh.learning.liferay.greeting.command.api;

import org.osgi.service.component.annotations.Component;

/**
 * @author nik
 */
@Component(
		immediate = true,
		property = {"osgi.command.function=greet", "osgi.command.scope=greet"},
		service = Object.class
)
public class GreetingCommand {

	public String greet(String name) {

//        System.out.println(String.format("Hello %s !!", name));

		return String.format("Hello %s !!", name);
	}

}