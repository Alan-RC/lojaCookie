package br.edu.ifrs.canoas.projetoatendimento.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MarcaRepository extends CrudRepository<Marca, Long> {
    List<Marca> findByNome(String nome);
    @Query(value = "delete from marca where id = :id", nativeQuery=true)
    void deleteMaluco(Long id);
}

