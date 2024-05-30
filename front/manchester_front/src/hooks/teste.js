import axios from "axios";

const PutRequest = async (data, url) => {
  // Verifica se os dados são válidos para a requisição PUT
  if (!data || typeof data !== 'object' || !data.id) {
    console.log("Dados inválidos para a requisição PUT");
    return;
  }

  try {
    const response = await axios.put(url, data); // Corrigi a ordem dos parâmetros
    console.log('Dados enviados via PUT:', response.data);
    return response.data; // Retorno opcional, dependendo do uso da função
  } catch (err) {
    console.log('Erro ao enviar dados via PUT:', err.message);
    throw err; // Lança o erro para que possa ser tratado pela função chamadora
  }
};

// Exemplo de uso
const data = {
  id: 1,
  nome: 'Exemplo',
  idade: 25,
  // Outros dados conforme necessário para a requisição PUT
};

const url = 'http://localhost:8080/pacientes/1'; // URL do endpoint no backend

// Chamada da função PutRequest
PutRequest(data, url)
  .then((responseData) => {
    // Tratar a resposta se necessário
    console.log('Resposta do backend:', responseData);
  })
  .catch((error) => {
    // Tratar o erro se necessário
    console.error('Erro ao enviar requisição PUT:', error);
  });
