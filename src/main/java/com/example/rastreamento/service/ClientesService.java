package com.example.rastreamento.service;

import com.example.rastreamento.domain.Clientes;
import com.example.rastreamento.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository rep;

    public  Clientes insert(Clientes clientes){
        return rep.save(clientes);
    }
    public Iterable<Clientes> findAll(){
        return rep.findAll();
    }
    public Clientes findById(Long id){
        try {
            return rep.findById(id).get();
        } catch (Exception ex){
            return null;
        }
    }
    public Clientes update(Clientes clientes, Long id) {
        Clientes clientesEntity = new Clientes(id, clientes.getBairro(), clientes.getCidade(),
                clientes.getNome(), clientes.getNumero_logradouro(), clientes.getRua(),
                clientes.getTelefone());
        if(rep.findById(id).isPresent()) {
            rep.save(clientesEntity);
            return clientesEntity;
        }
        throw new RuntimeException("id não existe");

    }

    public void delete(Long id){
       rep.deleteById(id);
    }

    public List<Clientes> getRastreamentoFake(){
        List<Clientes> rastreamento = new ArrayList<>();

        rastreamento.add(new Clientes(2L,"Assunção", "São Bernardo do Campo", "João da Silva", 36L, "Lazaro Zamenhoff", "11 41092454" ));

        return rastreamento;

    }

}
