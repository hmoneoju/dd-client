package com.dimensiondata.client;

import com.dimensiondata.model.Server;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CloudServerClient {
    void createServers(List<Server> servers);
    long count();
    void update(Long id, String name);
    void delete(Long id);
    List<Server> list();
}
