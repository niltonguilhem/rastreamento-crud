package com.example.rastreamento.service;

import com.example.rastreamento.model.Clientes;
import com.example.rastreamento.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;
import java.util.UUID;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository rep;

    public Iterable<Clientes> getRastreamento() { return rep.findAll(); }

    public Optional<Clientes> getClientesByid(UUID id){return rep.findById(id);}

    public Clientes save(Clientes clientes){return rep.save(clientes);}

    //public Iterable<Clientes> getClientesByCidade(String cidade) {return rep.findByCidade(cidade);}

    /*public  Clientes insert (Clientes clientes){
        Assert.isNull(clientes.getId(), "Não foi possível inserir o registro");
        return rep.save(clientes);
    }*/

    public Clientes update(Clientes clientes, UUID id) {
        Assert.notNull(id, "Não foi possível atualizar o registro");

        //Busca o item no banco de dados clientes
        Optional<Clientes> optional = getClientesByid(id);
        if (optional.isPresent()){
            Clientes db = optional.get();
            //Copiar as propriedades
            db.setBairro(clientes.getBairro());
            db.setCidade(clientes.getCidade());
            db.setNome(clientes.getNome());
            db.setNumero_logradouro(clientes.getNumero_logradouro());
            db.setRua(clientes.getRua());
            db.setTelefone(clientes.getTelefone());
            System.out.println("Item id: " + db.getId());

            //Atualiza item de estoque
            rep.save(db);

            return db;

        } else {
            throw new RuntimeException("Não foi possível atualizar o registro");
        }

    }

    public void delete(UUID id){
        Optional<Clientes> clientes = getClientesByid(id);
        if (clientes.isPresent()){
            rep.deleteById(id);
        }
    }
}
