
import styles from './Header.module.css'
import { Link } from 'react-router-dom';

export const Header = () => {
    return (
        <div className={styles.header}>
           
                <nav>
                    <ul>
                    <li><Link to="/form" className={styles.link}>Cadastro</Link></li>
                    <li><Link to="/historico" className={styles.link}>Historico de Pacientes</Link></li>
                    <li><Link to="/fila" className={styles.link}>Fila</Link></li>
                    </ul>
                </nav>
        </div>
    )
}


