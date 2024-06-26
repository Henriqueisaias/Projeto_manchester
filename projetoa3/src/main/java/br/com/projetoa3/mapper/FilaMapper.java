package br.com.projetoa3.mapper;

import br.com.projetoa3.dto.FilaDTO;
import br.com.projetoa3.entity.Fila;

/**
 * Classe de utilidade para mapear entre as entidades Fila e FilaDTO.
 */
    public class FilaMapper {

    /**
     * Converte uma entidade Fila para um DTO FilaDTO.
     *
     * @param fila Entidade Fila a ser convertida.
     * @return FilaDTO DTO contendo os dados da entidade Fila.
     */
        public static FilaDTO mapToFilaDTO(Fila fila) {
            FilaDTO filaDTO = new FilaDTO();
            filaDTO.setId(fila.getId());
            filaDTO.setPacienteId(fila.getPaciente().getId());
            filaDTO.setGrauRisco(fila.getGrauRisco());
            filaDTO.setPosicao(fila.getPosicao());
            filaDTO.setPrioridade(fila.getPrioridade());
            return filaDTO;
        }

    /**
     * Converte um DTO FilaDTO para uma entidade Fila.
     *
     * @param filaDTO DTO a ser convertido.
     * @return Fila Entidade contendo os dados do DTO.
     */
        public static Fila mapToFila(FilaDTO filaDTO) {
            Fila fila = new Fila();
            fila.setId(filaDTO.getId());
            // Aqui você precisará buscar o paciente pelo ID e setar na entidade Fila
            fila.setGrauRisco(filaDTO.getGrauRisco());
            fila.setPosicao(filaDTO.getPosicao());
            fila.setPrioridade(filaDTO.getPrioridade());
            return fila;
        }
    }
