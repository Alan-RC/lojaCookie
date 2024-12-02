package br.edu.ifrs.canoas.projetoatendimento.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    List<Usuario> findByNome(String nome);
    @Query(value = "DELETE FROM usuario WHERE id = :id", nativeQuery = true)
    void deleteMaluco(@Param("id") Integer id);
}
