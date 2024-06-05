import styles from "./Form.module.css";
import { useState } from "react";
import PostRequest from "../../hooks/PostRequest.js";

export const Form = () => {
  const [nome, setNome] = useState("");
  const [idade, setIdade] = useState(0);
  const [risco, setRisco] = useState("Emergência");
  const [sint, setSint] = useState("");

  const resetForm = () => {
    setNome("");
    setIdade(0);
    setRisco("Emergência");
    setSint("");
  };

  const handleName = (e) => {
    setNome(e.target.value);
  };
  const handleIdade = (e) => {
    setIdade(e.target.value);
  };
  const handleRisc = (e) => {
    setRisco(e.target.value);
  };
  const handleSint = (e) => {
    setSint(e.target.value);
  };

  const enviar = async (e) => {
    e.preventDefault();
  
    const paciente = {
      nome: nome,
      idade: idade,
      grauRisco: risco,
      sintomas: sint,
    };
  
    const url = "http://localhost:8080/pacientes";
    console.log("Dados do paciente a ser enviado:", paciente);
  
    try {
      const response = await PostRequest(paciente, url);
      console.log(response);
  
      if (response.status === 201) { // Verifica se o status da resposta é 201 (Created)
        window.alert("Paciente cadastrado com sucesso");
      } else {
        window.alert(`Erro ao cadastrar paciente: ${response.statusText}`);
      }
    } catch (err) {
      window.alert(`Erro ao enviar os dados: ${err.message}`);
    }
  
    resetForm();
  };
  

  return (
    <div className={styles.mainContainer}>
      <form onSubmit={enviar}>
        <div className={styles.main}>
          <h1>Cadastrar Paciente</h1>
          <div className={styles.inputDiv}>
            <label htmlFor="name">Nome do paciente:</label>
            <input
              onChange={handleName}
              type="text"
              name="name"
              placeholder="Exemplo: João da Silva"
              value={nome}
              required
            />
          </div>
          <div className={styles.inputDiv}>
            <label htmlFor="age">Idade do paciente:</label>
            <input
              onChange={handleIdade}
              type="number"
              name="age"
              placeholder="Exemplo: 29 anos"
              min={1}
              value={idade}
              required
            />
          </div>
        </div>

        <div className={styles.radio}>
          <div className={styles.radioContainer}>
            <label htmlFor="risco">Emergência</label>
            <input
              onChange={handleRisc}
              type="radio"
              name="risco"
              value="Emergência"
              checked={risco === "Emergência"}
            />
          </div>
          <div className={styles.radioContainer}>
            <label htmlFor="risco">Muito Urgente</label>
            <input
              onChange={handleRisc}
              type="radio"
              name="risco"
              value="Muito Urgente"
              checked={risco === "Muito Urgente"}
            />
          </div>
          <div className={styles.radioContainer}>
            <label htmlFor="risco">Urgente</label>
            <input
              onChange={handleRisc}
              type="radio"
              name="risco"
              value="Urgente"
              checked={risco === "Urgente"}
            />
          </div>
          <div className={styles.radioContainer}>
            <label htmlFor="risco">Pouco Urgente</label>
            <input
              onChange={handleRisc}
              type="radio"
              name="risco"
              value="Pouco Urgente"
              checked={risco === "Pouco Urgente"}
            />
          </div>
          <div className={styles.radioContainer}>
            <label htmlFor="risco">Não Urgente</label>
            <input
              onChange={handleRisc}
              type="radio"
              name="risco"
              value="Não Urgente"
              checked={risco === "Não Urgente"}
            />
          </div>
        </div>
        <div className={styles.sintomas}>
          <textarea
            onChange={handleSint}
            name="sintomas"
            cols="30"
            rows="10"
            value={sint}
            placeholder="Sintomas do paciente...."
            required
          ></textarea>
        </div>
        <div className={styles.submit}>
          <input type="submit" className={styles.button} value="Cadastrar" />
        </div>
      </form>
    </div>
  );
};
