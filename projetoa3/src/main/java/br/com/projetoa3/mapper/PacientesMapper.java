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
                pacientes.getRemediosReceitados(),
                pacientes.getGrauRisco()
        );
    }


    public static Pacientes mapToPacientes(PacientesDTO pacienteDTO) {
        Pacientes paciente = new Pacientes();
        paciente.setId(pacienteDTO.getId());
        paciente.setNome(pacienteDTO.getNome());
        paciente.setIdade(pacienteDTO.getIdade());
        paciente.setSintomas(pacienteDTO.getSintomas());
        paciente.setDataEntrada(pacienteDTO.getDataEntrada());
        paciente.setDataSaida(pacienteDTO.getDataSaida());
        paciente.setRemediosReceitados(pacienteDTO.getRemediosReceitados());
        paciente.setGrauRisco(pacienteDTO.getGrauRisco()); // Novo campo mapeado
        return paciente;
    }

}
