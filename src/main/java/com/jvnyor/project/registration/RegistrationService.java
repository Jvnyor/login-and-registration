package com.jvnyor.project.registration;

import org.springframework.stereotype.Service;

import com.jvnyor.project.appuser.AppUser;
import com.jvnyor.project.appuser.AppUserRole;
import com.jvnyor.project.appuser.AppUserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistrationService {

	private final AppUserService appUserService;
	
	private final EmailValidator emailValidator;
	
	public String register(RegistrationRequest request) {
		// TODO Auto-generated method stub
		boolean isValidEmail = emailValidator.test(request.getEmail());
		if(!isValidEmail) {
			throw new IllegalStateException("email not valid");
		}
		return appUserService.signUpUser(
				new AppUser(
						request.getFirstName(),
						request.getLastName(),
						request.getEmail(),
						request.getPassword(),
						AppUserRole.USER
				)
		);
	}

}
