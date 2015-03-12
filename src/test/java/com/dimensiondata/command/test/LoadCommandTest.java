package com.dimensiondata.command.test;

import com.dimensiondata.client.CloudServerClient;
import com.dimensiondata.command.LoadCommand;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LoadCommandTest {

    @Mock
    CloudServerClient cloudServerClient;

    @InjectMocks
    LoadCommand loadCommand = new LoadCommand();

    @Test
    public void execute() {
        loadCommand.execute();
        verify(cloudServerClient, times(1)).createServers( anyString() );
    }
}
