package br.edu.ifrs.canoas.projetoatendimento.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private Integer id;
    private Double valor;
    private Integer quantidade;
    private Boolean devolucao;
    @ManyToOne
    @JoinColumn(name = "id_compra")
    private Compra compra;
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;
    }