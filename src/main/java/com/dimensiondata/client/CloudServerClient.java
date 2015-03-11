package com.dimensiondata.client;

import com.dimensiondata.model.Server;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CloudServerClient {

    void createServers(String fileName);

    Long count();

    Server update(Server server);

    void delete(Long id);

    List<Server> list();
}
