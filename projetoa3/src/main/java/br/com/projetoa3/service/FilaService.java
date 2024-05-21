package br.com.projetoa3.service;

import br.com.projetoa3.dto.FilaDTO;

import java.util.List;

public interface FilaService {
    FilaDTO addPacienteToFila(Long pacienteId, String grauRisco);

    void removePacienteFromFila(Long id);

    List<FilaDTO> getPacientesByGrauRisco(String grauRisco);

    List<FilaDTO> getAllPacientes();

    FilaDTO addPacienteComGrauRisco(Long pacienteId, String grauRisco);
}
