package com.example.rastreamento.controller;

import com.example.rastreamento.domain.Clientes;
import com.example.rastreamento.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/rastreamento")
public class RastreamentoController {
    @Autowired
    private ClientesService service;

    @GetMapping()
    public Iterable<Clientes> getAllClientes(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Clientes getById(@PathVariable("id")Long id){
        return service.findById(id);
    }

    @PostMapping
    public String post(@RequestBody Clientes clientes){
        Clientes c = service.insert(clientes);
        return "Cadastro salvo com sucesso: " + c.getId();
    }

    @PutMapping("/{id}")
    public Clientes put(@PathVariable("id") Long id, @RequestBody Clientes clientes) {
        return service.update(clientes, id);
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable ("id") Long id) {
        service.delete(id);
        return "Cadastro deletado com sucesso.";
    }


}
