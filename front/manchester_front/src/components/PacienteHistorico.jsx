import { FaUser } from "react-icons/fa";
import styles from "./PacienteHistorico.module.css"

export const PacienteHistorico = ({ data }) => {
  return (
    <div>
      <div className={styles.paciente}>
        <FaUser className={styles.user} />
        <div className={styles.dados}>
          <h3>Nome: {data.nome}</h3>
          <p>Idade: {data.idade} anos</p>
          <p>Data de Entrada: {data.data_entrada}</p>
          <p>Data de Saída: {data.data_saida}</p>
          <p>Remédios Receitados: {data.remedios_receitados}</p>
          <p>Sintomas: {data.sintomas}</p>
        </div>
      </div>
    </div>
  );
};
