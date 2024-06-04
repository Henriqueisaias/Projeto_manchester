package br.com.projetoa3.service.impl;

import br.com.projetoa3.dto.FilaDTO;
import br.com.projetoa3.entity.Fila;
import br.com.projetoa3.entity.Pacientes;
import br.com.projetoa3.mapper.FilaMapper;
import br.com.projetoa3.repository.FilaRepository;
import br.com.projetoa3.repository.ManchesterRepository;
import br.com.projetoa3.service.FilaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FilaServiceImpl implements FilaService {

    private final FilaRepository filaRepository;
    private final ManchesterRepository manchesterRepository;

    @Override
    public FilaDTO addPacienteToFila(Long pacienteId, String grauRisco) {
        Pacientes paciente = manchesterRepository.findById(pacienteId)
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado com o ID: " + pacienteId));

        Fila fila = new Fila();
        fila.setPaciente(paciente);
        fila.setGrauRisco(grauRisco);

        // Set the priority based on the grauRisco
        int prioridade = determinePriority(grauRisco);
        fila.setPrioridade(prioridade);

        // Set the position in the fila
        fila.setPosicao(getNextPosition(prioridade));

        Fila savedFila = filaRepository.save(fila);
        return FilaMapper.mapToFilaDTO(savedFila);
    }

    @Override
    public void removePacienteFromFila(Long id) {
        filaRepository.deleteById(id);
        // Recalculate positions after removal
        recalculatePositions();
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
        switch (grauRisco.toLowerCase()) {
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

    private int determinePriority(String grauRisco) {
        switch (grauRisco.toLowerCase()) {
            case "emergência":
                return 1;
            case "muito urgente":
                return 2;
            case "urgente":
                return 3;
            case "pouco urgente":
                return 4;
            case "não urgente":
                return 5;
            default:
                throw new IllegalArgumentException("Grau de risco inválido: " + grauRisco);
        }
    }

    private int getNextPosition(int prioridade) {
        List<Fila> filas = filaRepository.findAll().stream()
                .filter(f -> f.getPrioridade() == prioridade)
                .sorted(Comparator.comparingInt(Fila::getPosicao))
                .collect(Collectors.toList());

        if (filas.isEmpty()) {
            return 1;
        } else {
            return filas.get(filas.size() - 1).getPosicao() + 1;
        }
    }

    private void recalculatePositions() {
        List<Fila> filas = filaRepository.findAll().stream()
                .sorted(Comparator.comparingInt(Fila::getPrioridade).thenComparing(Fila::getPosicao))
                .collect(Collectors.toList());

        for (int i = 0; i < filas.size(); i++) {
            Fila fila = filas.get(i);
            fila.setPosicao(i + 1);
            filaRepository.save(fila);
        }
    }
}
