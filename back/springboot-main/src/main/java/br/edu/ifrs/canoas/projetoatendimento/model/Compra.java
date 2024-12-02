package br.edu.ifrs.canoas.projetoatendimento.model;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data

public class Compra {
    @Id
    private int id;
    @DateTimeFormat(pattern="yyy-MM-dd HH:mm")
    private double valor;
    private int usuario_id;

}
