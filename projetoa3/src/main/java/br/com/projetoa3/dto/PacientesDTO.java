package br.com.projetoa3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacientesDTO {
    private Long id;
    private String nome;
    private Integer idade;
    private String sintomas;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private String remediosReceitados;
    private String risco;
}
