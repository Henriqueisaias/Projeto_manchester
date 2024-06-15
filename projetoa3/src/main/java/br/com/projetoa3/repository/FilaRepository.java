package br.com.projetoa3.repository;

import br.com.projetoa3.entity.Fila;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interface de repositório para a entidade Fila.
 */
public interface FilaRepository extends JpaRepository<Fila, Long> {

    /**
     * Retorna uma lista de filas ordenadas por posição para um determinado grau de risco.
     * @param grauRisco O grau de risco para o qual as filas devem ser recuperadas.
     * @return Uma lista de filas ordenadas por posição para o grau de risco especificado.
     */
    List<Fila> findByGrauRiscoOrderByPosicao(String grauRisco);

    /**
     * Retorna uma lista de filas ordenadas por posição decrescente para um determinado grau de risco.
     * @param grauRisco O grau de risco para o qual as filas devem ser recuperadas.
     * @return Uma lista de filas ordenadas por posição decrescente para o grau de risco especificado.
     */
    List<Fila> findByGrauRiscoOrderByPosicaoDesc(String grauRisco);

}