import axios from "axios";

const PutRequest = async (data, url) => {
  if (!data || typeof data !== 'object' || !data.id) {
    return;
  }

  const putPaciente = { id : data.id,
  nome: data.nomePaciente,
  sintomas: data.sintomasPaciente,
  idade: data.idadePaciente,
  "remediosReceitados" : data.remediosReceitados
  } 

  console.log("Dados enviados para a requisição PUT:", putPaciente);

  try {
    const response = await axios.put(url, putPaciente);
    console.log('Resposta do servidor via PUT:', response.data);
  } catch (err) {
    console.log('Erro ao enviar dados via PUT:', err.message);
    throw err;
  }

}

export default PutRequest;



