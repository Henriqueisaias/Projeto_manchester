import { PacienteHistorico } from "./PacienteHistorico"
import styles from "./Lista.module.css"

export const Lista = () => {

    const dados = [
        {
          "id": 1,
          "data_entrada": "2024-04-27 13:25:33",
          "data_saida": "2024-04-28 11:30:00",
          "idade": 34,
          "nome": "João Silva",
          "remedios_receitados": "Paracetamol, Dipirona",
          "sintomas": "Dor de cabeça"
        },
        {
          "id": 2,
          "data_entrada": "2024-04-30 20:17:00",
          "data_saida": "2024-05-02 09:45:00",
          "idade": 42,
          "nome": "Maria Oliveira",
          "remedios_receitados": "Ibuprofeno, Vitamina C",
          "sintomas": "Gripe"
        },
        {
          "id": 3,
          "data_entrada": "2024-05-24 18:21:27",
          "data_saida": "2024-05-28 14:20:00",
          "idade": 56,
          "nome": "Carlos Santos",
          "remedios_receitados": "Analgesico, Anti-inflamatório",
          "sintomas": "Fratura no braço"
        },
        {
          "id": 4,
          "data_entrada": "2024-06-10 10:45:12",
          "data_saida": "2024-06-12 16:00:00",
          "idade": 29,
          "nome": "Ana Pereira",
          "remedios_receitados": "Anti-histamínico, Corticosteroide",
          "sintomas": "Alergia"
        },
        {
          "id": 5,
          "data_entrada": "2024-07-05 08:30:00",
          "data_saida": "2024-07-07 10:10:00",
          "idade": 38,
          "nome": "Pedro Lima",
          "remedios_receitados": "Anti-hipertensivo, Diurético",
          "sintomas": "Pressão alta"
        },
        {
          "id": 6,
          "data_entrada": "2024-08-15 15:12:45",
          "data_saida": "2024-08-18 08:45:00",
          "idade": 47,
          "nome": "Mariana Costa",
          "remedios_receitados": "Antibiótico, Expectorante",
          "sintomas": "Infecção respiratória"
        },
        {
          "id": 7,
          "data_entrada": "2024-09-20 09:55:21",
          "data_saida": "2024-09-22 13:30:00",
          "idade": 61,
          "nome": "Paulo Mendes",
          "remedios_receitados": "Analgésico, Relaxante muscular",
          "sintomas": "Dor nas costas"
        },
        {
          "id": 8,
          "data_entrada": "2024-10-18 14:30:10",
          "data_saida": "2024-10-20 11:20:00",
          "idade": 44,
          "nome": "Fernanda Almeida",
          "remedios_receitados": "Analgésico, Anti-inflamatório",
          "sintomas": "Enxaqueca"
        },
        {
          "id": 9,
          "data_entrada": "2024-11-12 11:20:00",
          "data_saida": "2024-11-14 09:00:00",
          "idade": 50,
          "nome": "Ricardo Rodrigues",
          "remedios_receitados": "Antipirético, Anti-inflamatório",
          "sintomas": "Febre"
        },
        {
          "id": 10,
          "data_entrada": "2024-12-01 16:40:55",
          "data_saida": "2024-12-03",
          "idade": 36,
          "nome": "Cristina Ribeiro",
          "remedios_receitados": "Analgesico, Anti-inflamatório",
          "sintomas": "Dor de garganta"
        }
      ]
      
      return (
        <div>
          <h1>Historico de Pacientes</h1>
          {dados.map((paciente, index) => (
            <PacienteHistorico key={index} data={paciente} />
          ))}
        </div>
      );
    };