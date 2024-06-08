import GetRequest from "../../hooks/GetRequest.js";
import { Lista } from "./lista/Lista.jsx";
import { useEffect, useState } from "react";
import  Styles  from "./HistoricoComponent.module.css"

export const HistoricoComponent = () => {
  const [dados, setDados] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");
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

  const handleSearchChange = (event) => {
    setSearchTerm(event.target.value);
  };

  const filteredDados = searchTerm
    ? dados.filter(dado => dado.nome.toLowerCase().includes(searchTerm.toLowerCase()))
    : dados;

  return (
    <>
      <div className={Styles.busca}>
        <input
          type="text"
          placeholder="Buscar pelo nome"
          value={searchTerm}
          onChange={handleSearchChange}
        />
      </div>
      {filteredDados.length === 0 ? (
        <div>
          <h1>Sem dados para exibir</h1>
        </div>
      ) : (
        <div>
          <Lista dados={filteredDados} />
        </div>
      )}
    </>
  );
};
