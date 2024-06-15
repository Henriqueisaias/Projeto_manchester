package br.com.projetoa3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe que representa a entidade Fila no sistema.
 */
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "fila")
@EqualsAndHashCode(of = "id")
public class Fila {

    /**
     * Identificador único da fila.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Paciente associado à fila.
     */
    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Pacientes paciente;

    /**
     * Grau de risco associado à fila.
     */
    @Column(name = "grau_risco")
    private String grauRisco;

    /**
     * Posição do paciente na fila.
     */
    @Column(name = "posicao")
    private Integer posicao;

    /**
     * Prioridade do paciente na fila.
     */
    @Column(name = "prioridade")
    private Integer prioridade;

    public Fila() {
    }

}
