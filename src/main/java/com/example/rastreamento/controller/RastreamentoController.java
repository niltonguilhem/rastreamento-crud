package com.example.rastreamento.controller;

import com.example.rastreamento.model.Clientes;
import com.example.rastreamento.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/rastreamento")
public class RastreamentoController {
    @Autowired
    private ClientesService service;

    @GetMapping()
    public Iterable<Clientes> get(){
        return service.getRastreamento();
    }

    @GetMapping("/{id}")
    public Optional<Clientes> get (@PathVariable("id") UUID id ) {
        return service.getClientesById(id);
    }

    @PostMapping
    public ResponseEntity<Clientes> saveClientes(@RequestBody Clientes clientes) {
        return new ResponseEntity<>(service.saveClientes(clientes), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clientes> put (@PathVariable ("id") UUID id, @RequestBody Clientes clientes) {
        Clientes c = service.update(clientes,id);
        return new ResponseEntity<>(c, HttpStatus.ALREADY_REPORTED);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable ("id") UUID id) {

        service.delete(id);
    }


}
