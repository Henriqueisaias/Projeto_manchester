import styles from "./Form.module.css";
import { useState } from "react"
import PostRequest from "../../hooks/PostRequest.js"


export const Form = () => {

 

  const [nome, setNome] = useState("")
  const [idade, setIdade] = useState(0)
  const [risco, setRisco] = useState("Emêrgencia")
  const [sint, setSint] = useState("")


  const resetForm = () => {

    setNome("")
    setIdade(0)
    setRisco("Emêrgencia")
    setSint("")
  }

    let paciente = useState({nome:"", idade: 0, risco:"", sintomas: ""});


    const handleName = (e) => {
        setNome(e.target.value);
    }
    const handleIdade = (e) => {
        setIdade(e.target.value);
    }
    const handleRisc = (e) => {
        setRisco(e.target.value)
    }
    const handleSint = (e) => {
       setSint(e.target.value)
    }


const enviar = (e) => {
e.preventDefault();

paciente = {nome:nome, idade:idade, grauRisco:risco, sintomas:sint}



const url = "http://localhost:8080/pacientes"
console.log(paciente)
PostRequest(paciente, url);


resetForm();


}


  return (
    <div className={styles.mainContainer}>
      <form>

        <div className={styles.main}>
          <h1>Cadastrar Paciente</h1>
          <div className={styles.inputDiv}>
            <label htmlFor="name">Nome do paciente:</label>
            <input
             onChange={(e) => handleName(e)}
              type="text"
              name="name"
              placeholder="Exemplo: João da silva"
              value={nome}
              required
            />
          </div>
          <div className={styles.inputDiv}>
            <label htmlFor="age">Idade do paciente:</label>
            <input
            onChange={(e) => handleIdade(e)}
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
            <label htmlFor="risco">Emergência </label>
            <input onChange={(e) => handleRisc(e)} type="radio" name="risco" value={"Emergência"}/>
          </div>

          <div className={styles.radioContainer}>
            <label htmlFor="risco"> Muito Urgente</label>
            <input onChange={(e) => handleRisc(e)} type="radio" name="risco" value={"Muito Urgente"} />
          </div>

          <div className={styles.radioContainer}>
            <label htmlFor="risco"> Urgente</label>
            <input onChange={(e) => handleRisc(e)} type="radio" name="risco" value={"Urgente"} />
          </div>

          <div className={styles.radioContainer}>
            <label htmlFor="risco"> Pouco Urgente</label>
            <input onChange={(e) => handleRisc(e)} type="radio" name="risco" value={"Pouco Urgente"} />
          </div>

          <div className={styles.radioContainer}>
            <label htmlFor="risco"> Não Urgente</label>
            <input onChange={(e) => handleRisc(e)} type="radio" name="risco" value={"Não Urgente"} />
          </div>
        </div>
        <div className={styles.sintomas}>
            <textarea onChange={(e) => handleSint(e)} name="sintomas" cols="30" rows="10" value={sint} placeholder="Sintomas do paciente...."></textarea>
        </div>

        <div className={styles.submit}>
          <input type="submit" onClick={ (e) => enviar(e)} className={styles.button} value={"Cadastrar"}/>
        </div>
      </form>
    </div>
  );
};
