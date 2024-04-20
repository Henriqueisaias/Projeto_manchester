package br.com.projetoa3.dto;

import br.com.projetoa3.entity.Pacientes;

public record PacientesResponseDTO(Long id, String nome, Integer idade, String pressao, String temperatura) {
    public  PacientesResponseDTO(Pacientes pacientes){
        this(pacientes.getId(), pacientes.getNome(), pacientes.getIdade(), pacientes.getPressao(), pacientes.getTemperatura());

    }
}
