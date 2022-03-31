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

    public Iterable<Clientes> getRastreamento() { return rep.findAll(); }

    public Optional<Clientes> getClientesByid(Long id){return rep.findById(id);}

    public Iterable<Clientes> getClientesByCidade(String cidade) {return rep.findByCidade(cidade);}

    public  Clientes insert (Clientes clientes){
        Assert.isNull(clientes.getId(), "Não foi possível inserir o registro");
        return rep.save(clientes);
    }

    public Clientes update(Clientes clientes, Long id) {
        Assert.notNull(id, "Não foi possível atualizar o registro");

        //Busca o item no banco de dados estoque
        Optional<Clientes> optional = getClientesByid(id);
        if (optional.isPresent()){
            Clientes db = optional.get();
            //Copiar as propriedades
            db.setCidade(clientes.getCidade());
            System.out.println("Item id: " + db.getId());

            //Atualiza item de estoque
            rep.save(db);

            return db;

        } else {
            throw new RuntimeException("Não foi possível atualizar o registro");
        }

    }

    public void delete(Long id){
        Optional<Clientes> clientes = getClientesByid(id);
        if (clientes.isPresent()){
            rep.deleteById(id);
        }
    }

    public List<Clientes> getRastreamentoFake(){
        List<Clientes> rastreamento = new ArrayList<>();

        rastreamento.add(new Clientes(2L,"Assunção", "São Bernardo do Campo", "João da Silva", 36L, "Lazaro Zamenhoff", "11 41092454" ));

        return rastreamento;

    }

}
