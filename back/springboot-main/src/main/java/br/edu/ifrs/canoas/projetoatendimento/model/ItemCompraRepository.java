package br.edu.ifrs.canoas.projetoatendimento.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ItemCompraRepository extends CrudRepository<ItemCompra, Interger> {
    List<ItemCompra> findByNome(String nome);
    @Query(value = "delete from marca where id = :id", nativeQuery=true)
    void deleteMaluco(Long id);
}
