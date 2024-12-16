package br.ufrn.imd.primavera.app.security;

import java.util.UUID;

public class Token {

	private static Token instance;

	private String value;

	private Token() {
		this.value = UUID.randomUUID().toString();
	}

	public synchronized static Token getInstance() {
		if (instance == null) {
			instance = new Token();
		}
		return instance;
	}

	public String getValue() {
		return value;
	}
}
