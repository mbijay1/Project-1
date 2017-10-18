package com.cubic.exceptionmap;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.cubic.exception.DuplicateValueFoundException;
import com.cubic.vo.ErrorResponse;

@Component
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class DuplicateValueFoundExceptionMapper implements ExceptionMapper<DuplicateValueFoundException> {

	public Response toResponse(DuplicateValueFoundException exception) {
		ErrorResponse eresponse = new ErrorResponse();
		eresponse.setErrorCode("500");
		eresponse.setErrorDetails(exception.getMessage());
		return Response.serverError().status(502).entity(eresponse).build();
	}

}
