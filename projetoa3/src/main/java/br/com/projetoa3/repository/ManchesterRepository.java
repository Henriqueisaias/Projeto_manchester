package br.com.projetoa3.repository;

import br.com.projetoa3.entity.Pacientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface de repositório para a entidade Pacientes, utilizando o padrão Manchester.
 */
@Repository
public interface ManchesterRepository extends JpaRepository<Pacientes, Long> {
}