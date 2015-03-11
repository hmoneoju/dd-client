package com.dimensiondata;

import com.dimensiondata.command.*;
import com.dimensiondata.model.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Server.class);
        return marshaller;
    }

    /**
     *  Commands definition
     */
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

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
