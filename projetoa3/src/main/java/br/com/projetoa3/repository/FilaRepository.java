package br.com.projetoa3.repository;

import br.com.projetoa3.entity.Fila;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilaRepository extends JpaRepository<Fila, Long> {
    List<Fila> findByGrauRisco(String grauRisco);
}
