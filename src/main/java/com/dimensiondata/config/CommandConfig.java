package com.dimensiondata.config;

import com.dimensiondata.command.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CommandConfig {

    @Autowired private LoadCommand loadCommand;
    @Autowired private CountCommand countCommand;
    @Autowired private ListCommand listCommand;
    @Autowired private DeleteCommand deleteCommand;
    @Autowired private UpdateCommand updateCommand;

    @Bean
    public Map<String, Command> commands() {
        Map<String, Command> mapParserCommands = new HashMap<String, Command>();
        mapParserCommands.put(CommandEnum.load.toString(), loadCommand);
        mapParserCommands.put(CommandEnum.count.toString(), countCommand);
        mapParserCommands.put(CommandEnum.list.toString(), listCommand);
        mapParserCommands.put(CommandEnum.delete.toString(), deleteCommand);
        mapParserCommands.put(CommandEnum.update.toString(), updateCommand);

        return mapParserCommands;
    }

}
