package com.example.rastreamento.controller;

import com.example.rastreamento.model.Clientes;
import com.example.rastreamento.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:8080")
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
    public Optional<Clientes> get (@PathVariable("id") UUID id){
        return service.getClientesByid(id);
    }

    @PostMapping
    public String post(@RequestBody Clientes clientes){
        Clientes c = service.save(clientes);

        return "Cadastro salvo com sucesso: " + c.getId();
    }

    @PutMapping("/{id}")
    public String put (@PathVariable("id") UUID id, @RequestBody Clientes clientes) {

        Clientes c = service.update(clientes, id);

        return  "Cadastro atualizado com sucesso: "+ c.getId();
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable ("id") UUID id) {

        service.delete(id);

        return "Cadastro deletado com sucesso.";
    }


}
