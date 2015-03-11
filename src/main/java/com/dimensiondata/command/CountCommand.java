package com.dimensiondata.command;

import com.beust.jcommander.Parameters;
import org.springframework.stereotype.Component;

@Component
@Parameters( commandDescription = "the number of servers within the cloud server system")
public class CountCommand extends AbstractCommand implements Command<Long> {

    @Override
    public Long execute() {
        return cloudServerClient.count();
    }

}
