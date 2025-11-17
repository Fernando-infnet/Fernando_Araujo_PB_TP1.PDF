package org.example.banco.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="conta")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double saldo;

    @Override
    public String toString() {
        return id + " - " + nome + " - " + saldo;
    }
}
