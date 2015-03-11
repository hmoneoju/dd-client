package com.dimensiondata.model;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "servers")
public class Servers {

    @XmlElement(name = "server")
    private List<Server> server;

    public List<Server> getServers() {
        return server;
    }

    public void setServers(List<Server> servers) {
        this.server = servers;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for ( Server aServer: server ) {
            if ( server.size() != 0 ) builder.append("\n");
            builder.append(aServer.toString());
        }
        return builder.toString();
    }

}
