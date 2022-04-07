# example-cassandra-test

Api para estudo da conexão do cassandra

# Docker

```
docker run --name some-cassandra -p 9042:9042 cassandra
```
```
docker exec -it some-cassandra cqlsh
```
# Create Keyspace

```
CREATE KEYSPACE rastreamento
  WITH REPLICATION = { 
   'class' : 'SimpleStrategy', 
   'replication_factor' : 1 
  };
```

# Create database
```
CREATE TABLE rastreamento.clientes(
   id bigint, 
   bairro text, 
   cidade text,
   nome text,
   numero_logradouro bigint,
   rua text,
   telefone text, 
   PRIMARY KEY (id));
```