package org.acme.getting.started.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("/a")
public class A {

    @POST
    @Path("/getA")
    public Response getA(AModel aMode) {

        AModel aModel = new AModel();
        aModel.setA("aaaa");
        return Response.ok(aModel).build();
    }

    @GET
    public String hello(@QueryParam("name") String name) {
        return "hello";
    }
}
