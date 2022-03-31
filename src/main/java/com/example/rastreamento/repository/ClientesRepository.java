package com.example.rastreamento.repository;

import com.example.rastreamento.domain.Clientes;
import org.springframework.data.repository.CrudRepository;

public interface ClientesRepository extends CrudRepository<Clientes, Long> {
    Iterable<Clientes> findByCidade(String cidade);
}
