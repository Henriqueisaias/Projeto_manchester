package br.com.projetoa3.projetoa3.pacientesEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table (name = "pacientes")
@Entity (name = "pacientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pacientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nome;
    private Integer idade;
    private Integer pressao;
    private Integer temperatura;

    public  Pacientes(PacientesRequestDTO data){
        this.nome = data.nome();
        this.idade = data.idade();
        this.pressao = data.pressao();
        this.temperatura = data.temperatura();
    }

}
