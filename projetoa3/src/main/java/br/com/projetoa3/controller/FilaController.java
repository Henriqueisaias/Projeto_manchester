package br.com.projetoa3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoa3.service.FilaService;

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
