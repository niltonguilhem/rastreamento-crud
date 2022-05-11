package com.example.rastreamento.service;

import com.example.rastreamento.model.Clientes;
import com.example.rastreamento.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.UUID;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository rep;

    public Iterable<Clientes> getRastreamento() { return rep.findAll(); }

    public Optional<Clientes> getClientesById(UUID id){return rep.findById(id);}

    public Clientes saveClientes(Clientes clientes){return rep.save(clientes);}

    public Clientes update(Clientes clientes, UUID id) {
        Optional<Clientes> optional = getClientesById(id);
        if (optional.isPresent()){
            Clientes db = optional.get();
            db.setBairro(clientes.getBairro());
            db.setCidade(clientes.getCidade());
            db.setNome(clientes.getNome());
            db.setNumero_logradouro(clientes.getNumero_logradouro());
            db.setRua(clientes.getRua());
            db.setTelefone(clientes.getTelefone());
            rep.save(db);
            return db;

        }
        else {
            throw new RuntimeException();
        }
    }

    public void delete(UUID id){
        Optional<Clientes> clientes = getClientesById(id);
        if (clientes.isPresent()){
            rep.deleteById(id);
        }
    }
}
