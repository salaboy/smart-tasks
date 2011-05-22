package com.wordpress.salaboy.smarttasks.formbuilder.api.exception;


public class InvalidTaskException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String taskId;
	
	public InvalidTaskException(String theTaskId, String message) {
		super(message);
		this.taskId = theTaskId;
	}
	
	public InvalidTaskException(String theTaskId, Throwable cause) {
		super(cause);
		this.taskId = theTaskId;
	}
	
	public InvalidTaskException(String theTaskId, String message, Throwable cause) {
		super(message, cause);
		this.taskId = theTaskId;
	}
}
