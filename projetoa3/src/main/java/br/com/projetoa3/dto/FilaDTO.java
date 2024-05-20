package br.com.projetoa3.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilaDTO {
    private Long id;
    private Long pacienteId;
    private String grauRisco;
    private Integer posicao;
    private Integer prioridade;
}