package com.cubic.vo;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ErrorResponse {
	private String ErrorCode;
	private String ErrorDetails;
	
	public String getErrorCode() {
		return ErrorCode;
	}

	public void setErrorCode(String errorCode) {
		ErrorCode = errorCode;
	}

	public String getErrorDetails() {
		return ErrorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		ErrorDetails = errorDetails;
	}

	public ErrorResponse() {
		
		
		
	}

}
