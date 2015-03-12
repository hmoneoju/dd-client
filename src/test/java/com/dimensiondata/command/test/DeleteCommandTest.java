package com.dimensiondata.command.test;

import com.dimensiondata.client.CloudServerClient;
import com.dimensiondata.command.DeleteCommand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DeleteCommandTest {

    @Mock
    CloudServerClient cloudServerClient;

    @InjectMocks
    DeleteCommand deleteCommand = new DeleteCommand();

    @Test
    public void execute() {
        deleteCommand.execute();
        verify(cloudServerClient, times(1)).delete(anyLong());
    }

}
