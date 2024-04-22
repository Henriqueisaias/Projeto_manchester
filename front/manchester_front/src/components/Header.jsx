
import styles from './Header.module.css'

export const Header = () => {
    return (
        <div className={styles.header}>
           
                <nav>
                    <ul>
                        <li>Cadastro</li>
                        <li>Historico de Pacientes</li>
                        <li>Fila</li>
                    </ul>
                </nav>
        </div>
    )
}


