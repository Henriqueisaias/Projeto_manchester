package br.com.projetoa3.repository;

import br.com.projetoa3.entity.Fila;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilaRepository extends JpaRepository<Fila, Long> {
    List<Fila> findByGrauRiscoOrderByPosicao(String grauRisco);
    List<Fila> findByGrauRiscoOrderByPosicaoDesc(String grauRisco);  // Método adicional

}
