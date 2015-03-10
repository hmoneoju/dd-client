package com.dimensiondata.command;

import com.beust.jcommander.JCommander;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.Map;

@Controller
public class CommandLineController implements CommandLineRunner {

    @Resource
    private Map<String,Command> commands;

    @Override
    public void run(String... strings) throws Exception {
        JCommander commander = new JCommander();

        Iterator commandNames = commands.entrySet().iterator();
        while (commandNames.hasNext()) {
            Map.Entry<String,Command> commandEntry = (Map.Entry<String,Command>) commandNames.next();
            commander.addCommand(commandEntry.getKey(), commandEntry.getValue());
        }

        try {
            commander.parse(strings);
            String parsedCommand = commander.getParsedCommand();
            if ( parsedCommand == null )
                throw new Exception();
            commands.get(parsedCommand).execute();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            commander.usage();
            System.exit(-1);
        }
    }


}
