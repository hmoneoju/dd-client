package com.dimensiondata.client;

import com.dimensiondata.marshaller.XmlMarshaller;
import com.dimensiondata.model.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("restClient")
public class CloudServerRestClient implements CloudServerClient {

    private static final String SERVERS_URL = "/servers";
    private static final String SERVER_URL = "/server";
    private static final String COUNT_URL = "/count";

    @Value("${rest.server.url}")
    private String serverUrl;

    @Autowired
    private CloudRestTemplate restTemplate;

    @Autowired
    private XmlMarshaller marshaller;

    @Override
    public void createServers(String fileName) {
        List<Server> servers = marshaller.unmarshall(fileName);
        restTemplate.exchange(getServersUrl(), HttpMethod.POST, servers, List.class, null);
    }

    @Override
    public Long count() {
        ResponseEntity<Long> response = restTemplate.exchange(getServersUrl() + COUNT_URL, HttpMethod.GET, null, Long.class);
        return response.getBody();
    }

    @Override
    public Server update(Server server) {
        String serverUrl = getServerUrl(server.getId());
        ResponseEntity<Server> response = restTemplate.exchange(serverUrl, HttpMethod.PUT, server, Server.class);
        return response.getBody();
    }

    @Override
    public void delete(Long id) {
        String serverUrl = getServerUrl(id);
        restTemplate.exchange(serverUrl, HttpMethod.DELETE, null, null);
    }

    @Override
    public List<Server> list() {
        String serversUrl = getServersUrl();
        return (List<Server>) restTemplate.exchange(serversUrl, HttpMethod.GET, null, List.class).getBody();
    }

    private String getServersUrl() {
        return new StringBuilder().append(serverUrl).append(SERVERS_URL).toString();
    }

    private String getServerUrl(Long id) {
        return new StringBuilder(getServersUrl())
                .append(SERVER_URL).append("/").append(id)
                .toString();
    }

}
