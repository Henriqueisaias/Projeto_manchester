package br.com.projetoa3.controller;

import br.com.projetoa3.dto.PacientesDTO;
import br.com.projetoa3.service.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Controller para gerenciar operações relacionadas aos pacientes.
 */
@AllArgsConstructor
@RestController
@RequestMapping("/pacientes")
public class PacientesController {

    private PacienteService service;

    /**
     * Cria um novo paciente e adiciona à fila automaticamente.
     *
     * @param pacientesDTO Dados do paciente a ser criado.
     * @return ResponseEntity contendo o paciente criado e o status HTTP.
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<PacientesDTO> createPacientes(@RequestBody PacientesDTO pacientesDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataEntradaFormatada = LocalDateTime.now().format(formatter);
        pacientesDTO.setDataEntrada(LocalDateTime.parse(dataEntradaFormatada, formatter));
        PacientesDTO savePacientes = service.createPaciente(pacientesDTO);

        return new ResponseEntity<>(savePacientes, HttpStatus.CREATED);
    }

    /**
     * Obtém os detalhes de um paciente específico pelo ID.
     *
     * @param pacienteId ID do paciente a ser recuperado.
     * @return ResponseEntity contendo os dados do paciente e o status HTTP.
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("{id}")
    public ResponseEntity<PacientesDTO> getPacienteById(@PathVariable("id") Long pacienteId) {
        PacientesDTO pacientesDTO = service.getPacienteById(pacienteId);
        return ResponseEntity.ok(pacientesDTO);
    }

    /**
     * Lista todos os pacientes.
     *
     * @return ResponseEntity contendo a lista de todos os pacientes e o status HTTP.
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<PacientesDTO>> getAllPacientes() {
        List<PacientesDTO> allPacientes = service.getAllPacientes();
        return ResponseEntity.ok(allPacientes);
    }

    /**
     * Atualiza os detalhes de um paciente específico e preenche a data de saída.
     *
     * @param pacienteId ID do paciente a ser atualizado.
     * @param updatePacientes Dados atualizados do paciente.
     * @return ResponseEntity contendo os dados do paciente atualizado e o status HTTP.
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("{id}")
    public ResponseEntity<PacientesDTO> updatePacientes(@PathVariable("id") Long pacienteId,
                                                        @RequestBody PacientesDTO updatePacientes){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataSaidaFormatada = LocalDateTime.now().format(formatter);
        updatePacientes.setDataSaida(LocalDateTime.parse(dataSaidaFormatada, formatter));

        PacientesDTO pacientesDTO = service.updatePacientes(pacienteId,updatePacientes);

        return ResponseEntity.ok(pacientesDTO);
    }

    /**
     * Remove um paciente do sistema pelo ID.
     *
     * @param pacienteID ID do paciente a ser removido.
     * @return ResponseEntity contendo a mensagem de sucesso e o status HTTP.
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePaciente(@PathVariable("id") Long pacienteID){
        service.deletePaciente(pacienteID);
        return ResponseEntity.ok("Paciente receitado com sucesso!");
    }
}