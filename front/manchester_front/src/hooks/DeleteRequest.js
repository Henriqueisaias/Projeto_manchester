import axios from "axios";

const DeleteRequest = async (data) => {
  if (!data || typeof data !== 'object' || !data.id) {
    console.log("Dados inválidos para a requisição DELETE");
    return;
  }

  const urlDelete = `http://localhost:8080/fila/removePacienteFila/${data.id}`;

  try {
    const response = await axios.delete(urlDelete);
    console.log('Resposta do servidor via DELETE:', response.data);
    return response.data; // Retorno opcional, dependendo do uso da função
  } catch (err) {
    console.log('Erro ao enviar dados via DELETE:', err.message);
    throw err; // Lança o erro para que possa ser tratado pela função chamadora
  }
}

export default DeleteRequest;
