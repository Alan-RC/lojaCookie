package br.edu.ifrs.canoas.projetoatendimento.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Marca {

    @Id
    @GeneratedValue //gera id automatico
    private Long id;
    private String nome;
    private String pais;
    private String url;
    private String descricao;

}
