package br.com.projetoa3.repository;

import br.com.projetoa3.entity.Pacientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManchesterRepository extends JpaRepository<Pacientes, Long>{
}
