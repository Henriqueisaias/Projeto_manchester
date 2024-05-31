package br.com.projetoa3.service.impl;

import br.com.projetoa3.dto.FilaDTO;
import br.com.projetoa3.entity.Fila;
import br.com.projetoa3.entity.Pacientes;
import br.com.projetoa3.exception.ResourceNotFoundException;
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
    private  final  ManchesterRepository manchesterRepository;

    //Lista estática que define a ordem de prioridade dos graus de risco.
    private static final List<String> PRIORIDADE_RISCO = List.of(
            "Emergência",
            "Muito Urgente",
            "Urgente",
            "Não Urgente",
            "Pouco Urgente"
    );

    @Override
    //Cria uma nova instância de Fila, configurando os atributos pacienteId e grauRisco.
    public FilaDTO addPacienteToFila(Long pacienteId, String grauRisco) {
        // Busca o paciente pelo ID no repositório de pacientes
        Pacientes paciente = manchesterRepository.findById(pacienteId)
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado"));

        // Cria uma nova instância de Fila e define seus atributos
        Fila fila = new Fila();
        fila.setPaciente(paciente);
        fila.setGrauRisco(grauRisco);
        fila.setPrioridade(getPrioridade(grauRisco));

        // Busca a maior posição atual para o grau de risco específico
        Integer maxPosicao = filaRepository.findByGrauRiscoOrderByPosicaoDesc(grauRisco).stream()
                .findFirst()
                .map(Fila::getPosicao)
                .orElse(0);

        // Define a posição do novo paciente como a próxima disponível
        fila.setPosicao(maxPosicao + 1);
        // Salva o novo registro de Fila no repositório
        Fila savedFila = filaRepository.save(fila);
        return mapToDTO(savedFila);
    }

    // Método para remover um paciente da fila
    @Override
    public void removePacienteFromFila(Long id) {
        filaRepository.deleteById(id);
    }

    // Método para obter todos os pacientes de uma fila específica por grau de risco
    @Override
    public List<FilaDTO> getPacientesByGrauRisco(String grauRisco) {
        List<Fila> filas = filaRepository.findByGrauRiscoOrderByPosicao(grauRisco);
        return filas.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    // Método para obter todos os pacientes da fila, ordenados por prioridade e posição
    @Override
    public List<FilaDTO> getAllPacientes() {
        List<Fila> filas = filaRepository.findAll();
        return filas.stream()
                .sorted(Comparator.comparingInt(f -> getPrioridade(f.getGrauRisco())))
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Método para converter a entidade Fila para DTO
    private FilaDTO mapToDTO(Fila fila) {
        FilaDTO filaDTO = new FilaDTO();
        filaDTO.setId(fila.getId());
        filaDTO.setPacienteId(fila.getPaciente().getId());
        filaDTO.setGrauRisco(fila.getGrauRisco());
        filaDTO.setPrioridade(getPrioridade(fila.getGrauRisco()));
        filaDTO.setPosicao(fila.getPosicao());

        //Método para pegar o nome do paciente e sintomas
        Pacientes pacientes = manchesterRepository.findById(fila.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com o ID:" + fila.getId()));
        filaDTO.setNomePaciente(pacientes.getNome());
        filaDTO.setSintomasPaciente(pacientes.getSintomas());
        filaDTO.setIdadePaciente(pacientes.getIdade());

        return filaDTO;
    }

    // Método para obter a prioridade com base no grau de risco
    private int getPrioridade(String grauRisco) {
        String grauRiscoLower = grauRisco.toLowerCase();
        switch (grauRiscoLower) {
            case "emergência":
                return 1;
            case "muito urgente":
                return 2;
            case "urgente":
                return 3;
            case "não urgente":
                return 4;
            case "pouco urgente":
                return 5;
            default:
                //Tratamento de exception
                throw new IllegalArgumentException("Grau de risco desconhecido: " + grauRisco);
        }
    }
}