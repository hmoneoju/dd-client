package com.dimensiondata.command.test;

import com.dimensiondata.client.CloudServerClient;
import com.dimensiondata.command.CountCommand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CountCommandTest {

    @Mock
    CloudServerClient cloudServerClient;

    @InjectMocks
    CountCommand countCommand = new CountCommand();

    @Test
    public void execute() {
        countCommand.execute();
        verify(cloudServerClient, times(1)).count();
    }

}
