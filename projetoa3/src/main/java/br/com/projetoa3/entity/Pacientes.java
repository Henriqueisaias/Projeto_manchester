package br.com.projetoa3.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 * Classe que representa a entidade Pacientes no sistema.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pacientes")
@EqualsAndHashCode(of = "id")
public class Pacientes {

    /** Identificador único do paciente. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nome do paciente. */
    @Column(name = "nome_do_paciente")
    private String nome;

    /** Idade do paciente. */
    @Column(name = "idade_do_paciente")
    private Integer idade;

    /** Sintomas apresentados pelo paciente. */
    @Column(name = "sintomas_do_paciente")
    private String sintomas;

    /** Data de entrada do paciente no sistema. */
    @Column(name = "data_de_entrada")
    private LocalDateTime dataEntrada;

    /** Data de saída do paciente do sistema. */
    @Column(name = "data_de_saida")
    private LocalDateTime dataSaida;

    /** Medicamentos receitados para o paciente. */
    @Column(name = "remedios_receitados")
    private String remediosReceitados;

    /** Grau de risco do paciente. */
    @Column(name = "grauRisco")
    private String grauRisco;
}
