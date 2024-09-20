package org.acme.getting.started.config;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;
import org.jpos.iso.ISOException;
import org.jpos.iso.packager.GenericPackager;

import java.io.IOException;
import java.io.InputStream;

@ApplicationScoped
public class ChannelConfig {

//    @Produces
//    public GenericPackager packager() throws IOException, ISOException {
//        InputStream is = getClass().getClassLoader().getResourceAsStream("packager/hdbank.xml");
//        if (is == null) {
//            throw new IOException("Cannot find hdbank.xml");
//        }
//
//        return new GenericPackager(is);
//    }

}
