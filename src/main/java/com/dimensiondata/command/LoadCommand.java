package com.dimensiondata.command;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.dimensiondata.command.custom.FileValidator;
import org.springframework.stereotype.Component;

@Component
@Parameters(commandDescription = "a server specification from a file on local disk and persist it into the cloud server system")
public class LoadCommand extends AbstractCommand implements Command<Void> {

    @Parameter(names = {"-f","--file"}, description = "File name containing the list of server definition", required = true, validateWith = FileValidator.class)
    public String serverFileName;

    @Override
    public Void execute() {
        cloudServerClient.createServers(serverFileName);
        return null;
    }

}
