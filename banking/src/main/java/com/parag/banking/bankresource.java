package com.parag.banking;

import java.util.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("banks")
public class bankresource {
	repository repo=new repository();

	@GET
	@Path("bank/{ifsc}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public bank getbank(@PathParam("ifsc") String ifsc)
	{
		return repo.getbank(ifsc);
	}
	@GET
	@Path("bank/{city}&{bank_name}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<bank> getbanks(@PathParam("city") String city,@PathParam("bank_name") String name)
	{
		return repo.getbanks(city,name);
	}
}
