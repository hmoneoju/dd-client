package com.dimensiondata.command;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import org.springframework.stereotype.Component;

@Component
@Parameters(commandDescription = "Updates the name of the server with id the one provided, in the cloud server system" )
public class UpdateCommand extends AbstractCommand implements Command<Void> {

    @Parameter(names = {"-i","--id"}, description = "Server identifier", required = true)
    public Long id;

    @Parameter(names = {"-n","--name"}, description = "Name to set", required = true)
    public String name;

    @Override
    public Void execute() {
        cloudServerClient.update(id, name);
        return null;
    }

}
