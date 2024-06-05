package br.com.projetoa3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "fila")
@EqualsAndHashCode(of = "id")
public class Fila {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Fila() {
    }

    public Fila(Pacientes paciente, String grauRisco, Integer prioridade, Integer posicao) {
        this.paciente = paciente;
        this.grauRisco = grauRisco;
        this.prioridade = prioridade;
        this.posicao = posicao;
}
}
