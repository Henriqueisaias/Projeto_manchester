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

@AllArgsConstructor
@RestController
@RequestMapping("/pacientes")
public class PacientesController {

    private PacienteService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<PacientesDTO> createPacientes(@RequestBody PacientesDTO pacientesDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataEntradaFormatada = LocalDateTime.now().format(formatter);
        pacientesDTO.setDataEntrada(LocalDateTime.parse(dataEntradaFormatada, formatter));
        PacientesDTO savePacientes = service.createPaciente(pacientesDTO);
        return new ResponseEntity<>(savePacientes, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("{id}")
    public ResponseEntity<PacientesDTO> getPacienteById(@PathVariable("id") Long pacienteId) {
        PacientesDTO pacientesDTO = service.getPacienteById(pacienteId);
        return ResponseEntity.ok(pacientesDTO);

    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<PacientesDTO>> getAllPacientes() {
        List<PacientesDTO> allPacientes = service.getAllPacientes();
        return ResponseEntity.ok(allPacientes);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("{id}")
    public ResponseEntity<PacientesDTO> updatePacientes(@PathVariable("id") Long pacienteId,
                                                        @RequestBody PacientesDTO updatePacientes){
        PacientesDTO pacientesDTO = service.updatePacientes(pacienteId,updatePacientes);
        return ResponseEntity.ok(pacientesDTO);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePaciente(@PathVariable("id") Long pacienteID){
        service.deletePaciente(pacienteID);
        return ResponseEntity.ok("Paciente receitado com sucesso!");
    }
}