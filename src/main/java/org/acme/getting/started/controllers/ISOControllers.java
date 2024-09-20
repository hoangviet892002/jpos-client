package org.acme.getting.started.controllers;


import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.acme.getting.started.models.MessagesISO;
import org.acme.getting.started.services.ISOServices;
import org.jpos.iso.ISOException;

import java.io.IOException;

@Path("/iso")
public class ISOControllers {
    @Inject
    private  ISOServices isoServices;

    @Path("/post")
    @POST
    public String post(MessagesISO messagesISO) throws ISOException, IOException {


        return  isoServices.post(messagesISO);
    }
}
