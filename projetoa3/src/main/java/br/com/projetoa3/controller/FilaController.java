package br.com.projetoa3.controller;

import br.com.projetoa3.dto.FilaDTO;
import br.com.projetoa3.service.FilaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador para gerenciar a fila de pacientes.
 */
@AllArgsConstructor
@RestController
@RequestMapping("/fila")
public class FilaController {

    private final FilaService filaService;

    /**
     * Recupera a lista de pacientes agrupados por grau de risco.
     *
     * @param grauRisco Grau de risco dos pacientes a serem recuperados.
     * @return Lista de FilaDTO contendo os pacientes do grau de risco especificado.
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/grauRisco/{grauRisco}")
    public List<FilaDTO> getPacientesByGrauRisco(@PathVariable String grauRisco){
        return filaService.getPacientesByGrauRisco(grauRisco);
    }

    /**
     * Recupera a lista de todos os pacientes na fila.
     *
     * @return Lista de FilaDTO contendo todos os pacientes na fila.
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/all")
    public List<FilaDTO> getAllPacientes() {
        return filaService.getAllPacientes();
    }

    /**
     * Adiciona um paciente à fila.
     *
     * @param filaDTO Dados do paciente a ser adicionado à fila.
     * @return FilaDTO Dados do paciente após ser adicionado à fila.
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/add")
    public FilaDTO addPacienteToFila(@RequestBody FilaDTO filaDTO) {
        return filaService.addPacienteToFila(filaDTO.getPacienteId(), filaDTO.getGrauRisco());
    }

    /**
     * Remove um paciente da fila pelo seu ID.
     *
     * @param id ID do paciente a ser removido da fila.
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/removePacienteFila/{id}")
    public void removePacienteFromFila(@PathVariable Long id) {
        filaService.removePacienteFromFila(id);
    }
}
