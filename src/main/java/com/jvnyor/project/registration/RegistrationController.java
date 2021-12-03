package com.jvnyor.project.registration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

	private RegistrationService registrationService;
	
	@PostMapping
	public ResponseEntity<String> register(@RequestBody RegistrationRequest request) {
		return ResponseEntity.ok(registrationService.register(request));
		
	}
	
	@GetMapping("/confirm")
	public ResponseEntity<String> confirmation(@RequestParam String token) {
		return ResponseEntity.ok(registrationService.confirmToken(token));
	}
	
}
