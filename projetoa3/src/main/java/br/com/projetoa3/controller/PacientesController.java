package br.com.projetoa3.controller;

import br.com.projetoa3.dto.PacientesRequestDTO;
import br.com.projetoa3.dto.PacientesResponseDTO;
import br.com.projetoa3.repository.ManchesterRepository;
import br.com.projetoa3.entity.Pacientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacientesController {
    @Autowired
    private ManchesterRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void cadastrarPaciente(@RequestBody PacientesRequestDTO data){
       Pacientes pacientesData = new Pacientes(data);
       repository.save(pacientesData);
       return;
    }
    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
        public List<PacientesResponseDTO> getAll(){

          List<PacientesResponseDTO> pacientesList = repository.findAll().stream().map(PacientesResponseDTO::new).toList();
             return pacientesList;
        }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping
        public void deletaPaciente(@RequestBody PacientesRequestDTO data){
          Pacientes pacientesData = new Pacientes(data);
           repository.delete(pacientesData);
        }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping
          public Pacientes atualizaPaciente(@RequestBody PacientesRequestDTO data){
            Pacientes pacientesData = new Pacientes(data);
            return repository.save(pacientesData);
         } 
}