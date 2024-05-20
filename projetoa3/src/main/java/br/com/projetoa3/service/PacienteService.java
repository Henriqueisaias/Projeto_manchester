
package br.com.projetoa3.service;

import br.com.projetoa3.dto.PacientesDTO;

import java.util.List;

public interface PacienteService {
    PacientesDTO createPaciente(PacientesDTO pacientesDTO);

    PacientesDTO getPacienteById(Long pacienteId);

    List<PacientesDTO> getAllPacientes();

    PacientesDTO updatePacientes(Long pacienteId, PacientesDTO updatePacientes);

    void deletePaciente(Long pacienteID);
}
