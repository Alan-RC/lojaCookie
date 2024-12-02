package br.edu.ifrs.canoas.projetoatendimento.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class ItemCompra {

    @Id
    @GeneratedValue
    private int id;
    private double valor;
    private int quantidade;
    private boolean devolucao;

    @OneToMany
    private Produto produto;

    

    


}
