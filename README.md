### Olá, seja bem vindo!
Nosso objetivo ao desenvolver o sistema é melhorar a eficiência do atendimento hospitalar.
Implementando o protocolo de Manchester, nosso sistema fornece uma forma do paciente mais crítico ser prontamente atendido à medida que o menos urgente é dimensionado de acordo com a gravidade do caso.
Além disso, o sistema ajuda a economizar tempo que pode ser utilizado para a comunicação entre diferentes setores hospitalares.
O nosso sistema foi desenvolvido em Java, o sistema possui um backend completo, um banco de dados que armazena todas as informações dos pacientes e suas classificações,
e uma interface de usuário intuitiva que permite ao médico realizar a triagem de maneira rápida e eficiente.

## BACK-END

API de Pacientes
Introdução
A API de Pacientes gerencia informações de pacientes e suas prioridades na fila usando o Sistema de Triagem de Manchester. Permite operações CRUD e organiza a fila automaticamente com base no nível de risco dos pacientes.

### Pré-Requesitos

- Java 17
- Spring Boot
- Banco de Dados: H2 (configurável para MySQL, PostgreSQL)

### Instalação
Clone o repositório da aplicação utlizando o Git Bash ou Git Desktop
```bash
git clone https://github.com/Henriqueisaias/Projeto_manchester.git
```
Garanta um inicialização limpa da aplicação usando o comando no terminal da sua IDE:
```shell
./mvnw clean install
```
Agora Execute a aplicação:
```shell
./mvnw spring-boot:run
```
### Tutorial de como Inicializar a aplicação do BACK-END com PostgreSQL
- https://youtu.be/gq0zZlazQ_U

Configurações da conexão do banco de dado
Edite application.properties em src/main/resources conforme necessário que estiver na sua database.

### Exemplo de configuração para usar o POSTGRESQL

```shell

spring.datasource.url=jdbc:postgresql://localhost:5432/projeto_manchester
spring.datasource.username=postgres
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update

```

### Exemplo de configuração para usar o H2 - Banco de dados Local
Edite application.properties em src/main/resources para application.yml

```shell

spring:
    datasource:
        url: jdbc:h2:mem:pacientes
        driverClassName: org.h2.Driver
        username: sa
        password:
    jpa:
        database-platform: org.hibernate.dialect.H2Dialect
        properties.hibernate.show_sql: true
        properties.hibernate.format_sql: true
    h2:
        console:
            enabled: true
            path: /h2

        
```
E Adicione a dependencia do h2-database
```shell
	<dependency>
		<groupId>com.h2database</groupId>
		<artifactId>h2</artifactId>
		<scope>runtime</scope>
	</dependency>
```

Após iniciar a aplicação entre nesse link:
- http://localhost:8080/h2/login.do?jsessionid=eddb8a89aa7aa6d54ff3d1106e75388c

Coloque as seguintes configurações na página que foi aberta:
```shell
JDBC URL:	jdbc:h2:mem:pacientes
User Name:	
sa
```

Caso tenha dúvidas ou problemas para startar a aplicação, mude a branch para a "back-end-H2-new-method-Fila", ela está 100% configurada para usar o H2
- https://github.com/Henriqueisaias/Projeto_manchester/tree/back-end-H2-new-method-Fila

### Endpoints Principais

Esses são os endpoints principais da entidade Paciente e Fila.

| Tipo              | Descrição                                                                           | Endpoint URL             | Funcional|
| ----------------- | ----------------------------------------------------------------------------------- | ------------------------ | ----------- |
| `GET BY ID`       | Obter Paciente por ID                                                               | `GET` /pacientes/{id}    |    ✔️      |
| `GET ALL`         | Obter Todos os Pacientes                                                            | `GET` /pacientes         |    ✔️      |
| `PUT`             | Atualizar Paciente                                                                  | `PUT` /pacientes/{id}    |    ✔️      |
| `POST`            | Criar Paciente e o Adiciona na FIla                                                 | `POST` /pacientes        |    ✔️      |
| `DELETE`          | Deletar Paciente                                                                    | `DELETE` /pacientes/{id} |    ✔️      |
| `GET FILA`        | Obter Todos os Pacientes que estão na Fila                                          | `GET ` /fila             |    ✔️      |



### json Reponse

```shell
{
  "nome": "John Doe Updated",
  "idade": 31,
  "sintomas": "Febre alta e tosse",
  "remediosReceitados": "Paracetamol e Ibuprofeno",
  "grauRisco": "Muito Urgente"
}
```


## Conclusão
A API de Pacientes facilita a gestão de informações e priorização de pacientes na fila conforme o Sistema de Triagem de Manchester.


## FRONT-END
Introdução
O cliente é uma interface gráfica em React para gerenciar pacientes de um pronto-socorro, utilizando o protocolo de Manchester. Ele recebe, exibe e envia dados para a API, além de manter dados de pacientes para consultas futuras.

### Pré-requisitos
-Node.js: Necessário para acessar os pacotes npm
-Navegador com acesso à internet

#### Instale as dependências:
```bash
cd front/manchester_front
npm install
```

#### Execute a aplicação:
```
npm run dev
```
Construir a aplicação para fazer o deploy:
```
npm run build
```

#### Bibliotecas Principais
-React-router: Gerencia a navegação entre componentes.
-Axios: Simplifica as requisições à API.

### Componentes Principais

#### App.jsx: 
Componente principal com a base dos componentes e implementação do React-Router.
Header.jsx: Links de navegação do React-Router.

#### FormCadastro.jsx:
Formulário para cadastro de pacientes, enviando dados via POST.

#### FilaComponent.jsx: 
Gerencia a fila de pacientes, atualizando os dados via polling a cada 1000 ms.

#### Lista.jsx: 
Mapeia e exibe os pacientes na fila.

#### FormMed.jsx:
Atualiza e remove pacientes da fila, enviando dados de medicamentos via PUT e DELETE.

#### PacienteFila.jsx:
Exibe os dados dos pacientes na fila com cores baseadas no grau de risco.

#### HistoricoComponent.jsx:
Gerencia o histórico de pacientes, filtrando dados conforme a busca.

#### PacienteHistorico.jsx:
Similar ao PacienteFila, mas com dados históricos fixos.

## Hooks Principais
#### GetRequest:
Recebe dados da API.

#### DeleteRequest: 
Deleta um paciente da fila.

#### PutRequest:
Atualiza o campo de remédios receitados.

#### PostRequest:
Adiciona um paciente à fila e ao histórico.

#### Conclusão
O front-end do Projeto de Pacientes fornece uma interface intuitiva para gerenciar informações de pacientes e suas prioridades na fila.



