package br.com.projetoa3.mapper;

import br.com.projetoa3.dto.FilaDTO;
import br.com.projetoa3.entity.Fila;

public class FilaMapper {
    public static FilaDTO mapToFilaDTO(Fila fila) {
        return new FilaDTO(
                fila.getId(),
                fila.getPaciente().getId(),
                fila.getGrauRisco(),
                fila.getPosicao(),
                fila.getPrioridade()
        );
    }

    public static Fila mapToFilaEntity(FilaDTO filaDTO) {
        Fila fila = new Fila();
        fila.setId(filaDTO.getId());
        // Aqui você precisará definir a lógica para mapear o resto dos campos
        return fila;
    }
}
