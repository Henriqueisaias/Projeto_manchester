import { useEffect, useState } from "react";
import { Paciente } from "../Paciente/Paciente.jsx";
import styles from "./FilaComponent.module.css";
import { FormMed } from "../FormMed/FormMed.jsx";
import GetRequest from "../../../hooks/GetRequest.js";

export const FilaComponent = () => {
  const [dados, setDados] = useState([]);
  const url = "http://localhost:8080/fila/all";

  const [click, setClick] = useState(0);
  const incrementClick = () => {
    setClick(click + 1);
  };

  useEffect(() => {
    let isMounted = true;
    let timeoutId;

    const fetchData = async () => {
      try {
        const data = await GetRequest(url);
        if (isMounted && data) {
          setDados(data);
        }
      } catch (error) {
        console.error("Erro ao buscar dados:", error);
      } finally {
        
        if (isMounted) {
          timeoutId = setTimeout(fetchData, 1000);
        }
      }
    };

    fetchData();

    return () => {
      isMounted = false;
      clearTimeout(timeoutId);
    };
  }, [click]);

  return (
    <>
      {dados.length < 0 ? (
        <div>
          <h1>Sem pacientes para mostrar</h1>
        </div>
      ) : (
        <>
          {" "}
          <FormMed dados={dados} func={incrementClick} />
          <div>
            <h1 className={styles.title}>Proximos Pacientes</h1>
            {dados.slice(1).map((paciente) => (
              <Paciente key={paciente.id} data={paciente} />
            ))}
          </div>
        </>
      )}
    </>
  );
};
