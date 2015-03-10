package com.dimensiondata.command;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.dimensiondata.command.custom.FileConverter;
import com.dimensiondata.command.custom.FileValidator;
import com.dimensiondata.model.Server;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Parameters(commandDescription = "Read a server specification from a file on local disk and persist it into the cloud server system")
public class LoadCommand extends AbstractCommand implements Command<Void> {

    @Parameter(names = {"-f","--file"}, description = "File name containing the list of server definition", required = true, validateWith = FileValidator.class, converter = FileConverter.class)
    public List<Server> servers;

    @Override
    public Void execute() {
        cloudServerClient.createServers(servers);
        return null;
    }

}
