
import axios from 'axios';

const PostRequest = async (data, url) => {
  try {
    const response = await axios.post(url, data);
    console.log('Resposta do servidor via POST:', response);
    return response;
  } catch (err) {
    console.log('Erro ao enviar dados via POST:', err.message);
    throw err;
  }
};

export default PostRequest;
