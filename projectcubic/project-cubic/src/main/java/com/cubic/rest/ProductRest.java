package com.cubic.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubic.service.ProductService;
import com.cubic.vo.EnumSearchResult;
import com.cubic.vo.ProductSearchResult;
import com.cubic.vo.ProductVO;

@Service
@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductRest {
	@Autowired
	private ProductService service;

	@GET
	@Path("/{id}")
	public Response searchProductById(@PathParam("id") final Long pk) {
		ProductVO result = service.searchById(pk);
		return Response.ok().entity(result).build();

	}

	@GET
	@Path("/all")
	public Response searchAll() {
		List<ProductVO> results = service.searchAll();
		ProductSearchResult presults = new ProductSearchResult();
		presults.setProducts(results);
		return Response.ok().entity(presults).build();

	}

	@GET
	@Path("/upc")
	public Response searchProductByUpc(@QueryParam("upc") final String upc) {
		ProductSearchResult presults = new ProductSearchResult();
		List<ProductVO> results = service.searchByUpc(upc);
		presults.setProducts(results);
		return Response.ok().entity(presults).build();
	}

	@GET
	@Path("/name")
	public Response searchProductByName(@QueryParam("name") final String pname) {
		ProductSearchResult presults = new ProductSearchResult();
		List<ProductVO> results = service.searchByName(pname);
		presults.setProducts(results);
		return Response.ok().entity(presults).build();

	}

	@GET
	@Path("/number")
	public Response searchProductByNumber(@QueryParam("number") final String pnumber) {
		ProductSearchResult presults = new ProductSearchResult();
		List<ProductVO> results = service.searchByNumber(pnumber);
		presults.setProducts(results);
		return Response.ok().entity(presults).build();

	}

	@GET
	@Path("/enumCategory")
	public Response getEnumCategory() {
		EnumSearchResult ecResults = new EnumSearchResult();
		ArrayList<String> results = service.getEnumCategory();
		ecResults.setEnumList(results);
		return Response.ok().entity(ecResults).build();
	}

	@GET
	@Path("/enumManufacture")
	public Response getEnumManufacture() {
		EnumSearchResult ecResults = new EnumSearchResult();
		ArrayList<String> results = service.getEnumManufacture();
		ecResults.setEnumList(results);
		return Response.ok().entity(ecResults).build();
	}

	@POST
	public Response addProduct(final ProductVO vo) {
		ProductVO result = service.add(vo);
		return Response.ok().entity(result).build();
	}

	@DELETE
	@Path("/{id}")
	public Response removeProduct(@PathParam("id") final Long pk) {
		service.remove(pk);
		return Response.noContent().build();
	}

	@PUT
	public Response updateProduct(final ProductVO vo) {
		System.out.println("called put method");
		ProductVO result = service.add(vo);
		return Response.ok().entity(result).build();
	}

}
