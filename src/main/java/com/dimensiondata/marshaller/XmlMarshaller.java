package com.dimensiondata.marshaller;


import com.dimensiondata.model.Server;
import com.dimensiondata.marshaller.exception.UnmarshallException;
import com.dimensiondata.model.Servers;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

@Component
public class XmlMarshaller {

    @Autowired
    private Jaxb2Marshaller marshaller;

    public List<Server> unmarshall(String fileName) {
        String file;
        try {
            file = FileUtils.readFileToString(new File(fileName), null);
            Servers servers = (Servers) marshaller.unmarshal(new StreamSource(new StringReader(file)));
            return servers.getServers();
        } catch (IOException e) {
            throw new UnmarshallException("Could not unmarshall " +fileName, e);
        }
    }
}
