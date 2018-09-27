package com.njkol.redis.mongo.exception;

/**
 * 
 * @author Nilanjan Sarkar
 *
 */
public class VendorNotFoundException extends Exception {

	private static final long serialVersionUID = 2L;

	private final String msg;

	public VendorNotFoundException(String message) {
		super(message);
		this.msg = message;
	}

	public String getMsg() {
		return this.msg;
	}

}
