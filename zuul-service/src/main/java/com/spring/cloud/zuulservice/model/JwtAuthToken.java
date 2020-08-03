package com.spring.cloud.zuulservice.model;

import java.io.Serializable;

public class JwtAuthToken implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;

	public JwtAuthToken(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}