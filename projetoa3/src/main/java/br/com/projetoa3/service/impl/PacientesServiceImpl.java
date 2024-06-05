package br.com.projetoa3.service.impl;

import br.com.projetoa3.dto.PacientesDTO;
import br.com.projetoa3.entity.Pacientes;
import br.com.projetoa3.exception.ResourceNotFoundException;
import br.com.projetoa3.mapper.PacientesMapper;
import br.com.projetoa3.repository.ManchesterRepository;
import br.com.projetoa3.service.FilaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import br.com.projetoa3.service.PacienteService;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class PacientesServiceImpl implements PacienteService{

    private ManchesterRepository manchesterRepository;
    private FilaService filaService;
    @Override
    public PacientesDTO createPaciente(PacientesDTO pacientesDTO) {

        Pacientes pacientes = PacientesMapper.mapToPacientes(pacientesDTO);
        Pacientes savePacientes = manchesterRepository.save(pacientes);

        filaService.addPacienteToFila(savePacientes.getId(), savePacientes.getGrauRisco());

        return PacientesMapper.mapToPacientesDTO(savePacientes);
    }

    @Override
    public PacientesDTO getPacienteById(Long pacienteId) {
        Pacientes pacientes = manchesterRepository.findById(pacienteId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Paciente não existe com o ID passado: " + pacienteId));

        return PacientesMapper.mapToPacientesDTO(pacientes);
    }

    @Override
    public List<PacientesDTO> getAllPacientes() {
        List<Pacientes> allPacientes = manchesterRepository.findAll();
        return allPacientes.stream().map((pacientes) -> PacientesMapper.mapToPacientesDTO(pacientes))
                .collect(Collectors.toList());
    }

    @Override
    public PacientesDTO updatePacientes(Long pacienteId, PacientesDTO updatePacientes) {
        Pacientes pacientes = manchesterRepository.findById(pacienteId).orElseThrow(
                () -> new ResourceNotFoundException("Paciente não existe com o Id passado" + pacienteId));

        pacientes.setNome(updatePacientes.getNome());
        pacientes.setIdade(updatePacientes.getIdade());
        pacientes.setSintomas(updatePacientes.getSintomas());
        pacientes.setRemediosReceitados(updatePacientes.getRemediosReceitados());
        pacientes.setDataSaida(updatePacientes.getDataSaida());

       Pacientes updatePacientesObj = manchesterRepository.save(pacientes);

        return PacientesMapper.mapToPacientesDTO(updatePacientesObj);
    }

    @Override
    public void deletePaciente(Long pacienteId) {
        Pacientes pacientes = manchesterRepository.findById(pacienteId).orElseThrow(
                () -> new ResourceNotFoundException("Paciente não existe com o Id passado" + pacienteId));

        manchesterRepository.deleteById(pacienteId);
    }

}
