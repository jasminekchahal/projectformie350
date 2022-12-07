package com.restaurant.controller;


import com.restaurant.controller.exceptions.ServerNotFoundException;
import com.restaurant.model.entity.Server;
import com.restaurant.model.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ServerController
{
    @Autowired
    private final ServerRepository repository;

    @Autowired
    public ServerController(ServerRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping("/servers")
    List<Server> retrieveAllServers()
    {
        return repository.findAll();
    }

    @GetMapping("/servers/{server_id}")
    Server retrieveServer(@PathVariable("server_id") long server_id)
    {
        return repository.findById(server_id)
                .orElseThrow(() -> new ServerNotFoundException(server_id));
    }

    @DeleteMapping("/servers/{server_id}")
    void deleteServer(@PathVariable("server_id") long server_id)
    {
        repository.deleteById(server_id);
    }

    @PostMapping("/servers")
    Server createServer(@RequestBody Server newServer) { return repository.save(newServer);}

    @PutMapping("/servers/{server_id}")
    Server updateServer(@RequestBody Server newServer, @PathVariable("server_id") long server_id) {
        return repository.findById(server_id)
                .map(server -> {
                    server.setName(newServer.getName());
                    server.setServing_capacity(newServer.getServing_capacity());
                    server.setAvailability(newServer.getAvailability());
                    return repository.save(server);
                })
                .orElseGet(() -> {
                    newServer.setId(server_id);
                    return repository.save(newServer);
                });
    }
}

