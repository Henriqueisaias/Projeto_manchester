package br.com.projetoa3.mapper;

import br.com.projetoa3.dto.PacientesRequestDTO;
import br.com.projetoa3.dto.PacientesResponseDTO;
import br.com.projetoa3.entity.Pacientes;

public class PacientesMapper {

    public static Pacientes mapToPacientes(PacientesRequestDTO pacientesRequestDTO) {
        return new Pacientes(
                null, // O id será gerado pelo banco de dados
                pacientesRequestDTO.nome(),
                pacientesRequestDTO.idade(),
                pacientesRequestDTO.pressao(),
                pacientesRequestDTO.temperatura()
        );
    }

    public static PacientesResponseDTO mapToPacientesResponseDTO(Pacientes pacientes) {
        return new PacientesResponseDTO(
                pacientes.getId(),
                pacientes.getNome(),
                pacientes.getIdade(),
                pacientes.getPressao(),
                pacientes.getTemperatura()
        );
    }
}
