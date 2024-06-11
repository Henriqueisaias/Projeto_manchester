package br.com.projetoa3;

import br.com.projetoa3.entity.Fila;
import br.com.projetoa3.entity.Pacientes;
import br.com.projetoa3.exception.ResourceNotFoundException;
import br.com.projetoa3.repository.FilaRepository;
import br.com.projetoa3.repository.ManchesterRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class Projetoa3ApplicationTests {

	@Test
	void testFilaRepository() {
		// Criação de uma lista de filas fictícia para teste
		List<Fila> filas = new ArrayList<>();
		filas.add(new Fila(1L, new Pacientes(), "Alto", 1, 1));
		filas.add(new Fila(2L, new Pacientes(), "Médio", 2, 2));

		// Mock do FilaRepository
		FilaRepository filaRepository = Mockito.mock(FilaRepository.class);
		when(filaRepository.findAll()).thenReturn(filas);

		// Teste do método findAll
		List<Fila> result = filaRepository.findAll();
		assertEquals(2, result.size());
		assertEquals("Alto", result.get(0).getGrauRisco());
		assertEquals("Médio", result.get(1).getGrauRisco());
	}

	@Test
	void testManchesterRepository() {
		// Mock do ManchesterRepository (como não temos métodos personalizados, apenas estamos testando a herança de JpaRepository)
		ManchesterRepository manchesterRepository = Mockito.mock(ManchesterRepository.class);

		// Como JpaRepository tem métodos por padrão, vamos apenas verificar se os métodos estão acessíveis
		manchesterRepository.findAll();
		manchesterRepository.findById(1L);
		manchesterRepository.save(new Pacientes());
		manchesterRepository.deleteById(1L);
	}

	@Test
	void testResourceNotFoundException() {
		ResourceNotFoundException exception = new ResourceNotFoundException("Teste de exceção");

		assertEquals("Teste de exceção", exception.getMessage());
	}
}

