import GetRequest from "../../hooks/GetRequest.js";
import { Lista } from "./Lista";
import { useEffect, useState } from "react";

export const Historico = () => {
  const [dados, setDados] = useState([]);
  const url = "http://localhost:8080/pacientes";

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
        console.error('Erro ao buscar dados:', error);
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
  }, []);

  return (
    <>
      {dados.length < 0 ? (
        <div>
          <h1>Sem Historico para mostrar</h1>
        </div>
      ) : (
        <div>
          <Lista dados={dados} />
        </div>
      )}
    </>
  );
};
