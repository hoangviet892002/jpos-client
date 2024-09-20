package org.acme.getting.started.services.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.getting.started.models.MessagesISO;
import org.acme.getting.started.services.ISOServices;
import org.jpos.iso.ISOChannel;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.channel.ASCIIChannel;
import org.jpos.iso.packager.GenericPackager;

import java.io.IOException;
import java.io.InputStream;


@ApplicationScoped
public class ISOServicesImpl implements ISOServices {

    @Override
    public String post(MessagesISO messagesISO) throws ISOException, IOException {

        InputStream is = getClass().getClassLoader().getResourceAsStream("packager/hdbank.xml");
        if (is == null) {
            throw new IOException("Cannot find hdbank.xml");
        }
        GenericPackager packager = new GenericPackager(is);

        ISOMsg request = new ISOMsg();
        request.setPackager(packager);
        request.setMTI("0100");
        request.set(3, messagesISO.getField1());
        request.set(4, messagesISO.getField2());
        request.set(7,  messagesISO.getField3());
        request.set(11, messagesISO.getField4());
        ISOChannel isoChannel = new ASCIIChannel("localhost",10000, packager);
        isoChannel.connect();
        isoChannel.send(request);
        ISOMsg response = isoChannel.receive();
        isoChannel.disconnect();
        byte[] data = response.pack();
        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setPackager(packager);
        isoMsg.unpack(data);

        StringBuilder responseMessage = new StringBuilder();
        for (int i = 1; i <= isoMsg.getMaxField(); i++) {
            if (isoMsg.hasField(i)) {
                responseMessage.append("Field ").append(i).append(" (").append(isoMsg.getFieldNumber()).append("): ").append(isoMsg.getString(i)).append("\n");
            }
        }
        return responseMessage.toString();
    }
}
