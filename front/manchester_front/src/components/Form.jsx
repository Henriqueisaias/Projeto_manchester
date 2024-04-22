import styles from "./Form.module.css"
// import { useState } from "react"

export const Form = () => {

   

    return (
        <div className={styles.mainContainer}>
            <form action="">
                <div className={styles.inputDiv}>
                    <label htmlFor="name">Nome do paciente:</label>
                    <input type="text" name="name" placeholder="Exemplo: João da silva" required/>
                </div>
                <div className={styles.inputDiv}>
                    <label htmlFor="age">Idade do paciente:</label>
                    <input type="Number" name="age" placeholder="Exemplo: 29 anos" min={1} required/>
                </div>
                <div className={styles.submit}><input className={styles.button} type="submit" value={"Cadastrar paciente"} max={150}/></div>
            </form>
        </div>
    )
}
