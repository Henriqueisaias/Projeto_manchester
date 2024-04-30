
function Paciente(data) {
    return (
        <div>
            <h3>{data.nome}</h3>
            <p>{data.idade}</p>
            <p>{data.sintomas}</p>
        </div>
    )
}

export default Paciente
