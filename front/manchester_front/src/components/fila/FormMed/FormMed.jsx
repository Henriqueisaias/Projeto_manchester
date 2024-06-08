import { useState } from "react";
import styles from "./FormMed.module.css";
import PutRequest from "../../../hooks/PutRequest.js";
import DeleteRequest from "../../../hooks/DeleteRequest.js";
import { PacienteFila } from "../Paciente/PacienteFila.jsx";
import PropTypes from "prop-types";

export const FormMed = ({ dados, func }) => {
  const atual = dados && dados.length > 0 ? dados[0] : null;
  const [remedios, setRemedios] = useState("");

  const id = atual ? atual.id : "";
  const url = id ? `http://localhost:8080/pacientes/${id}` : "";

  const handleRemedios = (e) => {
    setRemedios(e.target.value);
  };

  const enviarRemedios = async (e) => {
    e.preventDefault();
    if (atual) {
      try {
        atual.remediosReceitados = remedios;
        await PutRequest(atual, url);
        await DeleteRequest(atual);
        window.alert(`Atendimento do paciente finalizado`);
        func();

        setRemedios("");
      } catch (error) {
        console.error("Erro ao enviar dados:", error);
      }
    }
  };

  return (
    <div className={styles.atual}>
      <form onSubmit={enviarRemedios}>
        <h2>Paciente atual:</h2>
        {atual ? (
          <>
            <PacienteFila data={atual} />
            <textarea
              value={remedios}
              onChange={handleRemedios}
              placeholder="Digite os remedios a receitar"
              required
            ></textarea>
            <input className={styles.btnMed} type="submit" value={"Enviar"} />
          </>
        ) : (
          <p>Nenhum paciente na fila</p>
        )}
      </form>
    </div>
  );
};

FormMed.propTypes = {
  dados: PropTypes.array.isRequired,
  func: PropTypes.func.isRequired,
};
