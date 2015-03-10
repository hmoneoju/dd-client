package com.dimensiondata.command;

import com.dimensiondata.client.CloudServerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractCommand {

    @Autowired
    @Qualifier("restClient")
    protected CloudServerClient cloudServerClient;

}
