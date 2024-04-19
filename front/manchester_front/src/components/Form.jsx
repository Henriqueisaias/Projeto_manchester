import  "./Form.css"
import { useState } from "react"

export const Form = () => {

   


    return (
        <div className="main-container">
            <form action="">
                <div className="input-div">
                    <label htmlFor="name">Nome do paciente:</label>
                    <input type="text" name="name" placeholder="Exemplo: João da silva"/>
                </div>
                <div className="input-div">
                    <label htmlFor="age">Idade do paciente:</label>
                    <input type="Number" name="age" placeholder="Exemplo: 29 anos" min={1}/>
                </div>
                <div className="submit"><input className="button" type="submit" value={"Cadastra paciente"} max={150}/></div>
            </form>
        </div>
    )
}
