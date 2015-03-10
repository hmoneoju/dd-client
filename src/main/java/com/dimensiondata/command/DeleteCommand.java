package com.dimensiondata.command;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import org.springframework.stereotype.Component;

@Component
@Parameters(commandDescription = "Deletes the server matching the provided id in the cloud server system")
public class DeleteCommand extends AbstractCommand implements Command<Void> {

    @Parameter(names = {"-i","--id"}, description = "Server identifier", required = true)
    public Long id;

    @Override
    public Void execute() {
        cloudServerClient.delete(id);
        return null;
    }

}
