import { FaUser } from "react-icons/fa";
import styles from "./PacienteHistorico.module.css"
import PropTypes from "prop-types";

export const PacienteHistorico = ({ data }) => {
  return (
    <div >
      <div className={styles.paciente}>
        <FaUser className={styles.user} />
        <div className={styles.dados}>
          <p><strong>Nome:</strong> {data.nome}</p>
          <p><strong>Idade:</strong> {data.idade} anos</p>
          <p><strong>Data de Entrada:</strong> {data.dataEntrada}</p>
          <p><strong>Data de Saída: </strong>{data.dataSaida}</p>
          <p><strong>Remédios Receitados:</strong> {data.remediosReceitados}</p>
          <p><strong>Sintomas:</strong> {data.sintomas}</p>
        </div>
      </div>
    </div>
  );
};


PacienteHistorico.propTypes =
{data : PropTypes.object.isRequired}
