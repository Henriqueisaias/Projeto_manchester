package br.com.projetoa3.entity;

//import br.com.projetoa3.dto.PacientesDTO;
//import br.com.projetoa3.dto.PacientesRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pacientes")
@EqualsAndHashCode(of = "id")
public class Pacientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_do_paciente")
    private String nome;

    @Column(name = "idade_do_paciente")
    private Integer idade;

    @Column(name = "sintomas_do_paciente")
    private String sintomas;

    @Column(name = "data_de_entrada")
    private LocalDateTime dataEntrada;

    @Column(name = "data_de_saida")
    private LocalDateTime dataSaida;

    @Column(name = "remedios_receitados")
    private String remediosReceitados;

    @Column(name = "risco")
    private String risco;



//    public  Pacientes(PacientesDTO data){
//        this.nome = data.nome();
//        this.idade = data.idade();
//        this.pressao = data.pressao();
//        this.sintomas = data.sintomas();
//    }

}
