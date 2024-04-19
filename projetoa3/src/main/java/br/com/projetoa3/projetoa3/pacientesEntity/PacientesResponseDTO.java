package br.com.projetoa3.projetoa3.pacientesEntity;

public record PacientesResponseDTO(Long id, String nome, Integer idade, Integer pressao, Integer temperatura) {
    public  PacientesResponseDTO(Pacientes pacientes){
        this(pacientes.getId(), pacientes.getNome(), pacientes.getTemperatura(), pacientes.getPressao(), pacientes.getIdade());

    }
}
