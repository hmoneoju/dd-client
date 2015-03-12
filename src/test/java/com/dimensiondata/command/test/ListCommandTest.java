package com.dimensiondata.command.test;


import com.dimensiondata.client.CloudServerClient;
import com.dimensiondata.command.ListCommand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ListCommandTest {

    @Mock
    CloudServerClient cloudServerClient;

    @InjectMocks
    ListCommand listCommand = new ListCommand();

    @Test
    public void execute() {
        listCommand.execute();
        verify(cloudServerClient, times(1)).list();
    }

}
