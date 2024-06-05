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
    return response.data;
  } catch (err) {
    document.window.alert("Erro ao cadastrar paciente")
    throw err;
  }
}

export default DeleteRequest;
