import styles from "./Paciente.module.css";
import { FaUser } from "react-icons/fa";
import PropTypes from "prop-types";

export const Paciente = ({ data }) => {
  let corIcone = "";
  switch (data.grauRisco) {
    case "Emergência":
      corIcone = "#E51300";
      break;
    case "Urgente":
      corIcone = "#E5DC00";
      break;
    case "Muito Urgente":
      corIcone = "#E66E01";
      break;
    case "Pouco Urgente":
      corIcone = "#3DE556";
      break;
    case "Não Urgente":
      corIcone = "#08C3E5";
      break;
    default:
      corIcone = "#E4E3DA";
  }

  return (
    <div className={styles.paciente}>
      <div className={styles.userdiv}>
        <FaUser className={styles.user} style={{ backgroundColor: corIcone }} />
      </div>
      <div className={styles.dados}>
        <h3>Nome: {data.nomePaciente}</h3>
        <p>Idade: {data.idadePaciente} anos</p>
        <p>Risco: {data.grauRisco}</p>
        <p>sintomas: {data.sintomasPaciente}</p>
      </div>
    </div>
  );
}

Paciente.propTypes = {
  data: PropTypes.object.isRequired
}
