package br.com.projetoa3.dto;
import lombok.*;

/**
 * Classe que representa um objeto de transferência de dados (DTO) para uma fila de pacientes.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilaDTO {
    /** Identificador da fila. */
    private Long id;

    /** Identificador do paciente na fila. */
    private Long pacienteId;

    /** Nome do paciente. */
    private String nomePaciente;

    /** Sintomas apresentados pelo paciente. */
    private String sintomasPaciente;

    /** Idade do paciente. */
    private Integer idadePaciente;

    /** Grau de risco do paciente. */
    private String grauRisco;

    /** Posição do paciente na fila. */
    private Integer posicao;

    /** Prioridade do paciente na fila. */
    private Integer prioridade;
}