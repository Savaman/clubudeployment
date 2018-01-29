package edu.ben.classconnect.controllers;

public class BaseController {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void addToMessage(String message) {
		this.message += "\n" + message;
	}

}
