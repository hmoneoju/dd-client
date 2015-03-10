package com.dimensiondata.client;

import com.dimensiondata.model.Server;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("restClient")
public class CloudServerRestClient implements CloudServerClient {

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
