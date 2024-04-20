package br.com.projetoa3.entity;

import br.com.projetoa3.dto.PacientesRequestDTO;
import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "pressao_do_paciente")
    private String pressao;

    @Column(name = "temperatura_do_paciente")
    private String temperatura;

    public  Pacientes(PacientesRequestDTO data){
        this.nome = data.nome();
        this.idade = data.idade();
        this.pressao = data.pressao();
        this.temperatura = data.temperatura();
    }

}
