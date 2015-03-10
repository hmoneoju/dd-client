package com.dimensiondata.command.custom;

import com.dimensiondata.Application;
import com.dimensiondata.model.Server;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Ignore
public class FileValidatorTest {

    @Autowired
    private FileConverter converter;

    @Test
    public void parsesValidFile() {
        List<Server> servers = converter.convert("servers.xml");
        assertEquals(3, servers.size());
    }


}
