
package br.com.projetoa3.service;

import br.com.projetoa3.dto.PacientesRequestDTO;
import br.com.projetoa3.dto.PacientesResponseDTO;

public interface PacienteService {
    PacientesResponseDTO createPaciente(PacientesRequestDTO pacientesRequestDTO); 

}
