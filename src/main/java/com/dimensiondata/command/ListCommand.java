package com.dimensiondata.command;

import com.beust.jcommander.Parameters;
import com.dimensiondata.model.Server;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Parameters(commandDescription = "the servers within the cloud server system")
public class ListCommand extends AbstractCommand implements Command<List<Server>> {

    @Override
    public List<Server> execute() {
        return cloudServerClient.list() ;
    }

}
