package com.ntg.organization.organization.exception;

public class EmployeeNotFoundException extends RuntimeException{

	public EmployeeNotFoundException() {
		super();
	}

	public EmployeeNotFoundException(final String message) {
		super(message);
	}
}
