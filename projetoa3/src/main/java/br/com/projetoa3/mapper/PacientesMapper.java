package br.com.projetoa3.mapper;

import br.com.projetoa3.dto.PacientesDTO;
import br.com.projetoa3.entity.Pacientes;

/**
 * Mapper para converter entre Pacientes e PacientesDTO.
 */
public class PacientesMapper {

    /**
     * Converte um objeto Pacientes para PacientesDTO.
     *
     * @param pacientes Objeto Pacientes a ser convertido.
     * @return PacientesDTO Objeto convertido.
     */
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

    /**
     * Converte um objeto PacientesDTO para Pacientes.
     *
     * @param pacienteDTO Objeto PacientesDTO a ser convertido.
     * @return Pacientes Objeto convertido.
     */
    public static Pacientes mapToPacientes(PacientesDTO pacienteDTO) {
        Pacientes paciente = new Pacientes();
        paciente.setId(pacienteDTO.getId());
        paciente.setNome(pacienteDTO.getNome());
        paciente.setIdade(pacienteDTO.getIdade());
        paciente.setSintomas(pacienteDTO.getSintomas());
        paciente.setDataEntrada(pacienteDTO.getDataEntrada());
        paciente.setDataSaida(pacienteDTO.getDataSaida());
        paciente.setRemediosReceitados(pacienteDTO.getRemediosReceitados());
        paciente.setGrauRisco(pacienteDTO.getGrauRisco());
        return paciente;
    }

}
