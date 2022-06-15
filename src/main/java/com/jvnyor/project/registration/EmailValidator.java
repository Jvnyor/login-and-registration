package com.jvnyor.project.registration;

import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class EmailValidator implements Predicate<String> {

	@Override
	public boolean test(String t) {
		// TODO: Regex to validate email
		return t.matches("([a-zA-Z0-9\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+");
	}

}
