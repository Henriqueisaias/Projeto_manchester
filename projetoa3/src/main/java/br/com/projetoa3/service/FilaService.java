package br.com.projetoa3.service;

import br.com.projetoa3.dto.FilaDTO;

import java.util.List;

/**
 * Interface para serviço de gerenciamento de fila de pacientes.
 */

public interface FilaService {

    /**
     * Adiciona um paciente à fila de acordo com o grau de risco.
     *
     * @param pacienteId ID do paciente a ser adicionado.
     * @param grauRisco Grau de risco do paciente.
     */
    FilaDTO addPacienteToFila(Long pacienteId, String grauRisco);

    /**
     * Remove um paciente da fila pelo grau de risco.
     *
     * @param grauRisco Grau de risco do paciente a ser removido.
     */
    void removePacienteFromFila(Long id);

    /**
     * Recupera a fila de pacientes agrupada pelo grau de risco.
     *
     * @return Mapa contendo a lista de IDs de pacientes por grau de risco.
     */

    List<FilaDTO> getPacientesByGrauRisco(String grauRisco);

    /**
     * Obtém todos os pacientes da fila, ordenados por prioridade e posição.
     *
     * @return Lista de FilaDTO contendo os dados de todos os pacientes na fila.
     */
    List<FilaDTO> getAllPacientes();
}
