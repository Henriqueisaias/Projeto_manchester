import styles from "./FormMed.module.css"
export const FormMed = ({dados}) => {

    const atual = dados.fila[0][0]
    
    return (
        <div className={styles.atual}>
           <form action="">
                <h2>Paciente atual</h2>
                <h3>Nome: {atual.nome}</h3>
                <p>Idade: {atual.idade} anos</p>
                <p>Risco: {atual.risco}</p>
                <textarea name="" id="" placeholder="Digite os remedios receitados">
                </textarea>
                <input className={styles.btnMed} type="submit"  value={"Enviar"}/>
            </form> 
        </div>
    )
}


