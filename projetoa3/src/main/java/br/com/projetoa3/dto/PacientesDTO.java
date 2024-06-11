package br.com.projetoa3.dto;

import br.com.projetoa3.exception.LocalDateTimeDeserializer;
import br.com.projetoa3.exception.LocalDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * Classe que representa um objeto de transferência de dados (DTO) para informações de pacientes.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacientesDTO {
    /** Identificador do paciente. */
    private Long id;

    /** Nome do paciente. */
    private String nome;

    /** Idade do paciente. */
    private Integer idade;

    /** Sintomas apresentados pelo paciente. */
    private String sintomas;

    /** Data de entrada do paciente no sistema. */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dataEntrada;

    /** Data de saída do paciente do sistema. */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dataSaida;

    /** Medicamentos receitados para o paciente. */
    private String remediosReceitados;

    /** Grau de risco do paciente. */
    private String grauRisco;
}
