package br.com.projetoa3.service.impl;

import br.com.projetoa3.dto.FilaDTO;
import br.com.projetoa3.entity.Fila;
import br.com.projetoa3.entity.Pacientes;
import br.com.projetoa3.mapper.FilaMapper;
import br.com.projetoa3.repository.FilaRepository;
import br.com.projetoa3.repository.ManchesterRepository; // Importe o ManchesterRepository
import br.com.projetoa3.service.FilaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FilaServiceImpl implements FilaService {

    private final FilaRepository filaRepository;
    private final ManchesterRepository manchesterRepository; // Ajuste o nome do repositório

    @Override
    public FilaDTO addPacienteToFila(Long pacienteId, String grauRisco) {
        Pacientes paciente = manchesterRepository.findById(pacienteId)
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado com o ID: " + pacienteId));

        Fila fila = new Fila();
        fila.setPaciente(paciente);
        fila.setGrauRisco(grauRisco);

        Fila savedFila = filaRepository.save(fila);
        return FilaMapper.mapToFilaDTO(savedFila);
    }

    @Override
    public void removePacienteFromFila(Long id) {
        filaRepository.deleteById(id);
    }

    @Override
    public List<FilaDTO> getPacientesByGrauRisco(String grauRisco) {
        List<Fila> filas = filaRepository.findByGrauRisco(grauRisco);
        return filas.stream()
                .map(FilaMapper::mapToFilaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<FilaDTO> getAllPacientes() {
        List<Fila> filas = filaRepository.findAll();
        return filas.stream()
                .map(FilaMapper::mapToFilaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FilaDTO addPacienteComGrauRisco(Long pacienteId, String grauRisco) {
        switch (grauRisco) {
            case "emergência":
            case "muito urgente":
            case "urgente":
            case "pouco urgente":
            case "não urgente":
                return addPacienteToFila(pacienteId, grauRisco);
            default:
                throw new IllegalArgumentException("Grau de risco inválido: " + grauRisco);
        }
    }
}
