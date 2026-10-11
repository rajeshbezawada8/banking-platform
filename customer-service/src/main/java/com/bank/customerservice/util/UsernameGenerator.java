package com.bank.customerservice.util;

import java.security.SecureRandom;

public class UsernameGenerator {

	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final SecureRandom RANDOM = new SecureRandom();

	public UsernameGenerator() {

	}

	public static String generate() {
		StringBuilder userName = new StringBuilder(7);
		for (int i = 0; i <= 7; i++) {
			int Index = RANDOM.nextInt(CHARACTERS.length());
			userName.append(Index);
		}
		return userName.toString();
	}
}
