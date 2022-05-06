package com.example.userservice.exception;

public class AlreadyThereException extends RuntimeException {
	public <T> AlreadyThereException(Class<T> cls, String id) {
		super(cls.getSimpleName() + " with id: " + id + " already exists!");
	}
}