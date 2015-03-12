package com.dimensiondata.command.test;


import com.dimensiondata.client.CloudServerClient;
import com.dimensiondata.command.UpdateCommand;
import com.dimensiondata.model.Server;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UpdateCommandTest {

    @Mock
    CloudServerClient cloudServerClient;

    @InjectMocks
    UpdateCommand updateCommand = new UpdateCommand();

    @Test
    public void execute() {
        updateCommand.execute();
        verify(cloudServerClient, times(1)).update( (Server) anyObject( ));
    }

}
