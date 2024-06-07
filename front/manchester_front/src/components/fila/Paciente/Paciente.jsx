import styles from "./Paciente.module.css";
import { FaUser } from "react-icons/fa";
import PropTypes from "prop-types";

export const Paciente = ({ data }) => {
  let corIcone = "";
  switch (data.grauRisco) {
    case "Emergência":
      corIcone = "#FF0000";
      break;
    case "Urgente":
      corIcone = "#FFFF00";
      break;
    case "Muito Urgente":
      corIcone = "#FFA500";
      break;
    case "Pouco Urgente":
      corIcone = "#008000";
      break;
    case "Não Urgente":
      corIcone = "#0000FF";
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
        <p><strong>Nome:</strong> {data.nomePaciente}</p>
        <p><strong>Idade:</strong> {data.idadePaciente} anos</p>
        <p><strong>Risco:</strong> {data.grauRisco}</p>
        <p><strong>sintomas:</strong> {data.sintomasPaciente}</p>
      </div>
    </div>
  );
}

Paciente.propTypes = {
  data: PropTypes.object.isRequired
}
