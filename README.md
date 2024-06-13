Nosso objetivo ao desenvolver o sistema é melhorar a eficiência do atendimento hospitalar.
Implementando o protocolo de Manchester, nosso sistema fornece uma forma do paciente mais crítico ser prontamente atendido à medida que o menos urgente é dimensionado de acordo com a gravidade do caso.
Além disso, o sistema ajuda a economizar tempo que pode ser utilizado para a comunicação entre diferentes setores hospitalares.
O nosso sistema foi desenvolvido em Java, o sistema possui um backend completo, um banco de dados que armazena todas as informações dos pacientes e suas classificações,
e uma interface de usuário intuitiva que permite ao médico realizar a triagem de maneira rápida e eficiente.


API de Pacientes
Introdução
A API de Pacientes gerencia informações de pacientes e suas prioridades na fila usando o Sistema de Triagem de Manchester. Permite operações CRUD e organiza a fila automaticamente com base no nível de risco dos pacientes.

Pré-requisitos
Java 17
Spring Boot
Banco de Dados: H2 (configurável para MySQL, PostgreSQL)
Instalação
Clone o repositório:
bash

git clone https://github.com/Henriqueisaias/Projeto_manchester.git
Construa o projeto:
bash

./mvnw clean install
Execute a aplicação:
bash

./mvnw spring-boot:run
Configuração
Edite application.properties em src/main/resources conforme necessário.

Endpoints Principais
Criar Paciente
POST /pacientes
json

{
  "nome": "John Doe",
  "idade": 30,
  "sintomas": "Febre alta",
  "remediosReceitados": "Paracetamol",
  "grauRisco": "Emergência"
}
Obter Paciente por ID
GET /pacientes/{id}
Obter Todos os Pacientes
GET /pacientes
Atualizar Paciente
PUT /pacientes/{id}
json

{
  "nome": "John Doe Updated",
  "idade": 31,
  "sintomas": "Febre alta e tosse",
  "remediosReceitados": "Paracetamol e Ibuprofeno",
  "grauRisco": "Muito Urgente"
}
Deletar Paciente
DELETE /pacientes/{id}
Obter Pacientes na Fila
GET /fila
Conclusão
A API de Pacientes facilita a gestão de informações e priorização de pacientes na fila conforme o Sistema de Triagem de Manchester.


Cliente de Pacientes
Introdução
O cliente é uma interface gráfica em React para gerenciar pacientes de um pronto-socorro, utilizando o protocolo de Manchester. Ele recebe, exibe e envia dados para a API, além de manter dados de pacientes para consultas futuras.

Pré-requisitos
Node.js: Necessário para acessar os pacotes npm
Navegador com acesso à internet
Instalação
Clone o repositório:
git clone https://github.com/Henriqueisaias/Projeto_manchester.git

Instale as dependências:
bash
cd manchester_front
npm install

Execute a aplicação:
npm run dev

Para fazer o deploy:
npm run build

Bibliotecas Principais
React-router: Gerencia a navegação entre componentes.
Axios: Simplifica as requisições à API.

Componentes Principais

App.jsx: Componente principal com a base dos componentes e implementação do React-Router.
Header.jsx: Links de navegação do React-Router.

FormCadastro.jsx: Formulário para cadastro de pacientes, enviando dados via POST.

FilaComponent.jsx: Gerencia a fila de pacientes, atualizando os dados via polling a cada 1000 ms.

Lista.jsx: Mapeia e exibe os pacientes na fila.

FormMed.jsx: Atualiza e remove pacientes da fila, enviando dados de medicamentos via PUT e DELETE.

PacienteFila.jsx: Exibe os dados dos pacientes na fila com cores baseadas no grau de risco.

HistoricoComponent.jsx: Gerencia o histórico de pacientes, filtrando dados conforme a busca.

PacienteHistorico.jsx: Similar ao PacienteFila, mas com dados históricos fixos.

Hooks Principais
GetRequest: Recebe dados da API.

DeleteRequest: Deleta um paciente da fila.

PutRequest: Atualiza o campo de remédios receitados.

PostRequest: Adiciona um paciente à fila e ao histórico.

Conclusão
O front-end do Projeto de Pacientes fornece uma interface intuitiva para gerenciar informações de pacientes e suas prioridades na fila.



