package com.njkol.redis.mongo.exception;

public class NoReviewsFoundException extends Exception {

	private static final long serialVersionUID = 2L;

	private final String msg;

	public NoReviewsFoundException(String message) {
		super(message);
		this.msg = message;
	}

	public String getMsg() {
		return this.msg;
	}
}
