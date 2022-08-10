package com.ntg.organization.organization.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponse handleResourceNotFound(final EmployeeNotFoundException exception,
			final HttpServletRequest request) {

		return new ErrorResponse(Errors.EMPPLOYEE_NOT_FOUND.getMessage(),
				Errors.EMPPLOYEE_NOT_FOUND.getCode());
	}
}
