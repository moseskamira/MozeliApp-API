package com.mobifest.mozeli.utils;

public class AuthenticationResponse {
	private final String jwt;
	
	public AuthenticationResponse(String myJwt) {
		this.jwt = myJwt;
	}
	public String getJwt() {
		return jwt;
	}
}
