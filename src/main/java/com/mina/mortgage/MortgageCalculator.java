package com.mina.mortgage;

import com.google.gson.Gson;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/mortgage")
public class MortgageCalculator {
    
    @GET
    @Path("/payment")
    @Produces("application/json")
    public Response getPayment(@Context UriInfo info){
        Gson gson = new Gson();
        
        String principle = info.getQueryParameters().getFirst("principle");
	String interest = info.getQueryParameters().getFirst("interest");
        String term = info.getQueryParameters().getFirst("term");
        MortgageInfo mortgageInfo = new MortgageInfo(Double.parseDouble(principle), Double.parseDouble(interest), Integer.parseInt(term));

       return Response.status(200).entity(gson.toJson(mortgageInfo)).build();
    }
    
    @POST
    @Path("/echo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(String entity){
       return Response.status(200).entity(entity).build();
    }

}
