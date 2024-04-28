import styles from "./Form.module.css";
import { useState } from "react"
import PostRequest from "../hooks/PostRequest.js"

export const Form = () => {

    const [paciente, setPaciente] = useState({nome:"", idade: 0, risco:"", sintomas: ""})

    const handleName = (e) => {
        setPaciente({...paciente, nome: e.target.value})
        console.log(paciente.nome)
    }
    const handleAge = (e) => {
        setPaciente ( {...paciente, idade: e.target.value})
        console.log(paciente.idade)
    }
    const handleRisc = (e) => {
        setPaciente({...paciente, risco: e.target.value})
        console.log(paciente.risco)
    }
    const handleSint = (e) => {
       setPaciente({...paciente, sintomas: e.target.value})
        console.log(paciente.sintomas)
    }


const enviar = (e) => {
e.preventDefault();

const url = 'aqui voce põe a url'
PostRequest(paciente, url);

setPaciente({nome:"", idade: 0, risco:"", sintomas: ""})

}


  return (
    <div className={styles.mainContainer}>
      <form action="">
        <div className={styles.inputDiv}>
          <label htmlFor="name">Nome do paciente:</label>
          <input
            onChange={(e) => handleName(e)}
            type="text"
            name="name"
            placeholder="Exemplo: João da silva"
            required
          />
        </div>
        <div className={styles.inputDiv}>
          <label htmlFor="age">Idade do paciente:</label>
          <input
          onChange={(e) => handleAge(e)}
            type="number"
            name="age"
            placeholder="Exemplo: 29 anos"
            min={1}
            required
          />
        </div>
        <div className={styles.radio}>
          <div className={styles.radioContainer}>
            <label htmlFor="risco">Emergência </label>
            <input onChange={(e) => handleRisc(e)} type="radio" name="risco" value={"emergencia"} />
          </div>

          <div className={styles.radioContainer}>
            <label htmlFor="risco"> Muito Urgente</label>
            <input onChange={(e) => handleRisc(e)} type="radio" name="risco" value={"muitoUrgente"} />
          </div>

          <div className={styles.radioContainer}>
            <label htmlFor="risco"> Urgente</label>
            <input onChange={(e) => handleRisc(e)} type="radio" name="risco" value={"urgente"} />
          </div>

          <div className={styles.radioContainer}>
            <label htmlFor="risco"> Pouco Urgente</label>
            <input onChange={(e) => handleRisc(e)} type="radio" name="risco" value={"poucoUrgente"} />
          </div>

          <div className={styles.radioContainer}>
            <label htmlFor="risco"> Não Urgente</label>
            <input onChange={(e) => handleRisc(e)} type="radio" name="risco" value={"naoUrgente"} />
          </div>
        </div>
        <div className={styles.sintomas}>
            <textarea onChange={(e) => handleSint(e)} name="sintomas" cols="30" rows="10" placeholder="Sintomas do paciente...."></textarea>
        </div>

        <div className={styles.submit}>
          <button onClick={ (e) => enviar(e)} className={styles.button}>cadastrar paciente</button>
        </div>
      </form>
    </div>
  );
};
