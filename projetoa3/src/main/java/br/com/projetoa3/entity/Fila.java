package br.com.projetoa3.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Cria os Getters and Setter e o ToString
@AllArgsConstructor //Criar construtor com as propriedades de fila
@NoArgsConstructor // Criar construtor vazio
@Builder //Ajudar na criação do objeto fila
@Entity //Informar que é uma entidade Banco de Dados
public class Fila implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Pacientes paciente;

    @Column(name = "grau_risco")
    private String grauRisco;

    @Column(name = "posicao")
    private Integer posicao;

    @Column(name = "prioridade")
    private Integer prioridade;
}
