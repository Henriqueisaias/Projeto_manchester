
package br.com.projetoa3.service;

import br.com.projetoa3.dto.PacientesDTO;

import java.util.List;

/**
 * Interface para serviço de gerenciamento de pacientes.
 */
public interface PacienteService {

    /**
     * Cria um novo paciente.
     *
     * @param pacientesDTO Dados do paciente a ser criado.
     * @return PacientesDTO Dados do paciente após ser salvo.
     */
    PacientesDTO createPaciente(PacientesDTO pacientesDTO);

    /**
     * Recupera os dados de um paciente pelo seu ID.
     *
     * @param pacienteId ID do paciente a ser recuperado.
     * @return PacientesDTO Dados do paciente encontrado.
     */
    PacientesDTO getPacienteById(Long pacienteId);

    /**
     * Recupera a lista de todos os pacientes.
     *
     * @return Lista de PacientesDTO contendo os dados de todos os pacientes.
     */
    List<PacientesDTO> getAllPacientes();

    /**
     * Atualiza os dados de um paciente existente.
     *
     * @param pacienteId ID do paciente a ser atualizado.
     * @param updatePacientes Dados atualizados do paciente.
     * @return PacientesDTO Dados do paciente após a atualização.
     */
    PacientesDTO updatePacientes(Long pacienteId, PacientesDTO updatePacientes);

    /**
     * Exclui um paciente pelo seu ID.
     *
     * @param pacienteID ID do paciente a ser excluído.
     */
    void deletePaciente(Long pacienteID);
}
