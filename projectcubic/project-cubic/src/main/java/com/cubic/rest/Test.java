package com.cubic.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.stereotype.Service;
@Service
@Path("/hellorest")
public class Test {
@GET
public String getsdfd(){
	return "hello rest";
}
}
