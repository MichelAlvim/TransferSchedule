package com.teste.cvc.exception;

public class TransferException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4366518338760563923L;

	public TransferException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public TransferException(String message) {
		super(message);
	}
}
