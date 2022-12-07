package com.restaurant.controller;

import com.restaurant.controller.exceptions.TableNotFoundException;
import com.restaurant.model.entity.Tables;

import com.restaurant.model.repository.TablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TablesController
{

    @Autowired
    private final TablesRepository repository;

    @Autowired
    public TablesController(TablesRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping("/tables")
    List<Tables> retrieveAllTables()
    {
        return repository.findAll();
    }

    @GetMapping("/tables/{table_id}")
    Tables retrieveTable(@PathVariable("table_id") int table_id)
    {
        return repository.findById(table_id)
                .orElseThrow(() -> new TableNotFoundException(table_id));
    }

    @PostMapping("/tables")
    Tables createTable(@RequestBody Tables newTables)
    {
        return repository.save(newTables);
    }

    @PutMapping("/tables/{table_id}")
    Tables updateTables(@RequestBody Tables newTables, @PathVariable("table_id") int table_id)
    {
        return repository.findById(table_id)
                .map(tables -> {
                    tables.setTable_capacity(newTables.getTable_capacity());
                    return repository.save(tables);
                })
                .orElseGet(() -> {
                    newTables.setId(table_id);
                    newTables.setTable_capacity(table_id);
                    return repository.save(newTables);
                });
    }



    @DeleteMapping("/tables/{table_id}")
    void deleteTable(@PathVariable("table_id") int table_id) {
        repository.deleteById(table_id);
    }
}

