package br.com.projetoa3.mapper;

import br.com.projetoa3.dto.PacientesDTO;
//import br.com.projetoa3.dto.PacientesRequestDTO;
//import br.com.projetoa3.dto.PacientesResponseDTO;
import br.com.projetoa3.entity.Pacientes;

public class PacientesMapper {

    public static PacientesDTO mapToPacientesDTO(Pacientes pacientes) {
        return new PacientesDTO(
                pacientes.getId(),
                pacientes.getNome(),
                pacientes.getIdade(),
                pacientes.getSintomas(),
                pacientes.getDataEntrada(),
                pacientes.getDataSaida(),
                pacientes.getRemediosReceitados()
        );
    }

    public static Pacientes mapToPacientes(PacientesDTO pacientesDTO) {
        return new Pacientes(
                pacientesDTO.getId(),
                pacientesDTO.getNome(),
                pacientesDTO.getIdade(),
                pacientesDTO.getSintomas(),
                pacientesDTO.getDataEntrada(),
                pacientesDTO.getDataSaida(),
                pacientesDTO.getRemediosReceitados()
        );
    }
}
