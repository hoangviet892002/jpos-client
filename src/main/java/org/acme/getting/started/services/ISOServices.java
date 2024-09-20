package org.acme.getting.started.services;

import org.acme.getting.started.models.MessagesISO;
import org.jpos.iso.ISOException;

import java.io.IOException;

public interface ISOServices {
     String post(MessagesISO messagesISO) throws ISOException, IOException;
}
