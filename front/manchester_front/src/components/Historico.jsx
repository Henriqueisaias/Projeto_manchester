import GetRequest from "../hooks/GetRequest.js";
import { Lista } from "./Lista";
import { useEffect, useState } from "react";

export const Historico = () => {
  const [dados, setDados] = useState([]);
  const url = "http://localhost:8080/pacientes";

  useEffect(() => {
    const fetchData = async () => {
      const data = await GetRequest(url);
      if (data) {
        setDados(data);
      }
    };

    fetchData();
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
