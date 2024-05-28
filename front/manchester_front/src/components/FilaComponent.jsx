
import Paciente from "./Paciente"
import styles from "./FilaComponent.module.css"
import { FormMed } from './FormMed';

const dados = {



    "fila": [
        [
            {"nome": "João", "idade": 25, "risco": "emergência", "sintomas": "febre"},
            {"nome": "Mariana", "idade": 28, "risco": "emergência", "sintomas": "dor de garganta"},
            {"nome": "Rafael", "idade": 27, "risco": "emergência", "sintomas": "convulsões"},
            {"nome": "Aline", "idade": 31, "risco": "emergência", "sintomas": "alergia"},
            {"nome": "Marcelo", "idade": 37, "risco": "emergência", "sintomas": "infarto"},
            {"nome": "Isabela", "idade": 36, "risco": "emergência", "sintomas": "depressão"}
        ],
        [
            {"nome": "Maria", "idade": 30, "risco": "urgente", "sintomas": "tosse"},
            {"nome": "Lucas", "idade": 32, "risco": "urgente", "sintomas": "falta de ar"},
            {"nome": "Fernanda", "idade": 29, "risco": "urgente", "sintomas": "diarreia"},
            {"nome": "Marcos", "idade": 26, "risco": "urgente", "sintomas": "enjoo"},
            {"nome": "Camila", "idade": 23, "risco": "urgente", "sintomas": "dor muscular"},
            {"nome": "Rodrigo", "idade": 24, "risco": "urgente", "sintomas": "ansiedade"}
        ],
        [
            {"nome": "Pedro", "idade": 40, "risco": "pouco urgente", "sintomas": "dor de cabeça"},
            {"nome": "Ana", "idade": 35, "risco": "pouco urgente", "sintomas": "vômitos"},
            {"nome": "Juliana", "idade": 38, "risco": "pouco urgente", "sintomas": "dor nas costas"},
            {"nome": "Gustavo", "idade": 33, "risco": "pouco urgente", "sintomas": "fadiga"},
            {"nome": "Natália", "idade": 41, "risco": "pouco urgente", "sintomas": "irritabilidade"}
        ],
        [
            {"nome": "Carlos", "idade": 22, "risco": "não urgente", "sintomas": "dor abdominal"}
        ]
    ]
};

export const FilaComponent = () => {
    return (
        <>
        <FormMed dados={dados}/>
        <div>
           <h1 className={styles.title}>Fila de pacientes</h1>
           {dados.fila.map((pacientesArray, index) => (<div key={index}>
               {pacientesArray.map((paciente, idx) => (<Paciente key={idx} data={paciente}/>))}
           </div>))}
        </div>
        </>
    )
}
