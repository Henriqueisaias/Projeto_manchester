import styles from "./Paciente.module.css";
import { FaUser } from "react-icons/fa";

function Paciente({ data }) {
  let corIcone = "";
  switch (data.grauRisco) {
    case "Emergência":
      corIcone = "red";
      break;
    case "Urgente":
      corIcone = "orange";
      break;
    case "Muito Urgente":
      corIcone = "orange";
      break;
    case "Pouco Urgente":
      corIcone = "yellow";
      break;
    case "Não Urgente":
      corIcone = "green";
      break;
    default:
      corIcone = "black"; // Cor padrão se não houver correspondência
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

export default Paciente;
