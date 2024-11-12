package com.leon.api.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenController {

	@Autowired
	AuthenticationManager authenticationManager;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestHeader("Authorization") String authorizationHeader) {

		if (authorizationHeader != null && authorizationHeader.startsWith("Basic ")) {

			String token = authorizationHeader.substring(6);
			String decodedToken = new String(Base64.getDecoder().decode(token));
			String[] credentials = decodedToken.split(":");

			String username = credentials[0];
			String password = credentials[1];

			try {

				Authentication authentication = authenticationManager
						.authenticate(new UsernamePasswordAuthenticationToken(username, password));

				if (authentication.isAuthenticated()) {
					return ResponseEntity.ok(token);
				}

			} catch (AuthenticationException e) {

				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
			}

		}

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	}

}
