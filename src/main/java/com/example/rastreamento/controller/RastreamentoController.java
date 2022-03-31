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
    public Iterable<Clientes> get(){
        return service.getRastreamento();
    }

    @GetMapping("/{id}")
    public Optional<Clientes> get (@PathVariable("id")Long id){
        return service.getClientesByid(id);
    }

    @GetMapping("/cidade/{cidade}")
    public Optional<Clientes> getClientesByCidade (@PathVariable("cidade") Long cidade){
        return service.getClientesByid(cidade);
    }

    @PostMapping
    public String post(@RequestBody Clientes clientes){
        Clientes c = service.insert(clientes);

        return "Cadastro salvo com sucesso: " + c.getId();
    }

    @PutMapping("/{id}")
    public String put (@PathVariable("id") Long id, @RequestBody Clientes clientes) {

        Clientes c = service.update(clientes, id);

        return  "Cadastro atualizado com sucesso: "+ c.getId();
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable ("id") Long id) {

        service.delete(id);

        return "Cadastro deletado com sucesso.";
    }


}
