package br.com.projetoa3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilaDTO {
    private Long id;
    private Long pacienteId;
    private String grauRisco;
    private Integer posicao;
    private Integer prioridade;
}
