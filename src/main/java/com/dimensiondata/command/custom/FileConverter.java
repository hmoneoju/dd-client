package com.dimensiondata.command.custom;

import com.beust.jcommander.IStringConverter;
import com.dimensiondata.command.exception.CommandException;
import com.dimensiondata.model.Server;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.StringReader;
import java.util.List;

@Component
public class FileConverter implements IStringConverter<List<Server>>{

    @Autowired
    private Jaxb2Marshaller marshaller;

    @Override
    public List<Server> convert(String fileName) {
        String file = null;
        try {
            file = FileUtils.readFileToString(new File(fileName), null);
            return (List<Server>) marshaller.unmarshal(new StreamSource(new StringReader(file)));
        } catch (Exception e) {
            throw new CommandException("Could not unmarshall " +fileName, e);
        }
    }
}
