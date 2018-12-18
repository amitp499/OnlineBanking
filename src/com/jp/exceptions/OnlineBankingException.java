package com.jp.exceptions;

public class OnlineBankingException extends Exception {

	public OnlineBankingException(String message, Throwable cause) {
		super(message, cause);
	}

	public OnlineBankingException(String message) {
		super(message);
	}
}
