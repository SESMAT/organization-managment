package com.ntg.organization.organization.exception;

public enum Errors {

	EMPPLOYEE_NOT_FOUND("0001", "Employee not exists");

	private final String code;
	private final String message;

	private Errors(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
