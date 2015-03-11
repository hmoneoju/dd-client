package com.dimensiondata.client;

import com.dimensiondata.model.Server;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component("restClient")
public class CloudServerRestClient implements CloudServerClient {

    RestTemplate restTemplate;

    @Override
    public void createServers(List<Server> servers) {
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void update(Long id, String name) {

    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public List<Server> list() {
        return null;
    }

}
