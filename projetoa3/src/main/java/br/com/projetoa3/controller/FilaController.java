package br.com.projetoa3.controller;

import br.com.projetoa3.dto.FilaDTO;
import br.com.projetoa3.service.FilaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/fila")
public class FilaController {

    private final FilaService filaService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/grauRisco/{grauRisco}")
    public List<FilaDTO> getPacientesByGrauRisco(@PathVariable String grauRisco){
        return filaService.getPacientesByGrauRisco(grauRisco);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/all")
    public List<FilaDTO> getAllPacientes() {
        return filaService.getAllPacientes();
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/add")
    public FilaDTO addPacienteToFila(@RequestBody FilaDTO filaDTO) {
        return filaService.addPacienteToFila(filaDTO.getPacienteId(), filaDTO.getGrauRisco());
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/removePacienteFila/{id}")
    public void removePacienteFromFila(@PathVariable Long id) {
        filaService.removePacienteFromFila(id);
    }
}
