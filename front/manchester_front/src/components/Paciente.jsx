
import styles from './Paciente.module.css'
import {FaUser} from 'react-icons/fa'


function Paciente({data}) {

    let corIcone ='';
    switch(data.risco)  {
        case 'emergência':
            corIcone = 'red';
            break;
        case 'urgente':
            corIcone = 'orange';
            break;
        case 'pouco urgente':
            corIcone = 'yellow';
            break;
        case 'não urgente':
            corIcone = 'green';
            break;
        default:
            corIcone = 'black'; // Cor padrão se não houver correspondência
    }


    return (
        <div className={styles.paciente}>
            <FaUser className={styles.user} style={{backgroundColor : corIcone}}/>
            <div className={styles.dados} >
                <h3>Nome: {data.nome}</h3>
                <p>Idade: {data.idade} anos</p>
                <p>Risco: {data.grauRisco}</p>
            </div>
        </div>
    )
}

export default Paciente
