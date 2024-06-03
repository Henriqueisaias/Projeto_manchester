import axios from 'axios';

const GetDadosFila = async (url) => {
  try {
    const response = await axios.get(url);
    return response.data;
  } catch (error) {
    console.error('Erro ao obter os dados:', error.message);
    return null;
  }
};

export default GetDadosFila;
