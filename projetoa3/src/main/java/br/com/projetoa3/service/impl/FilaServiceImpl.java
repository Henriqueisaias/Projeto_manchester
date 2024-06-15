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

/**
 * Implementação do serviço de gerenciamento de fila de pacientes.
 */
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

    /**
     * Adiciona um paciente à fila de acordo com o grau de risco.
     *
     * @param pacienteId ID do paciente a ser adicionado.
     * @param grauRisco Grau de risco do paciente.
     * @return FilaDTO Dados da fila após adicionar o paciente.
     */
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

    /**
     * Remove um paciente da fila.
     *
     * @param id ID do paciente a ser removido.
     */
    @Override
    public void removePacienteFromFila(Long id) {
        filaRepository.deleteById(id);
    }

    /**
     * Obtém todos os pacientes de uma fila específica por grau de risco.
     *
     * @param grauRisco Grau de risco dos pacientes a serem buscados.
     * @return Lista de FilaDTO contendo os dados dos pacientes.
     */
    @Override
    public List<FilaDTO> getPacientesByGrauRisco(String grauRisco) {
        List<Fila> filas = filaRepository.findByGrauRiscoOrderByPosicao(grauRisco);
        return filas.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    /**
     * Obtém todos os pacientes da fila, ordenados por prioridade e posição.
     *
     * @return Lista de FilaDTO contendo os dados de todos os pacientes na fila.
     */
    @Override
    public List<FilaDTO> getAllPacientes() {
        List<Fila> filas = filaRepository.findAll();
        return filas.stream()
                .sorted(Comparator.comparingInt(f -> getPrioridade(f.getGrauRisco())))
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Converte a entidade Fila para DTO.
     *
     * @param fila Entidade Fila a ser convertida.
     * @return FilaDTO Dados convertidos da fila.
     * @throws ResourceNotFoundException Se o paciente não for encontrado.
     */
    private FilaDTO mapToDTO(Fila fila) {
        FilaDTO filaDTO = new FilaDTO();
        filaDTO.setId(fila.getId());
        filaDTO.setPacienteId(fila.getPaciente().getId());
        filaDTO.setGrauRisco(fila.getGrauRisco());
        filaDTO.setPrioridade(getPrioridade(fila.getGrauRisco()));
        filaDTO.setPosicao(fila.getPosicao());

        Pacientes pacientes = manchesterRepository.findById(fila.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com o ID:" + fila.getId()));
        filaDTO.setNomePaciente(pacientes.getNome());
        filaDTO.setSintomasPaciente(pacientes.getSintomas());
        filaDTO.setIdadePaciente(pacientes.getIdade());

        return filaDTO;
    }

    /**
     * Obtém a prioridade com base no grau de risco.
     *
     * @param grauRisco Grau de risco do paciente.
     * @return Prioridade numérica associada ao grau de risco.
     * @throws IllegalArgumentException Se o grau de risco for desconhecido.
     */
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
                throw new IllegalArgumentException("Grau de risco desconhecido: " + grauRisco);
        }
    }
}