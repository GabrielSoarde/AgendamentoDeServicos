# Sistema de Agendamento de Serviços

Este projeto é um **Sistema de Agendamento de Serviços** desenvolvido com **Spring Boot**. Ele permite gerenciar agendamentos de clientes para serviços, incluindo funcionalidades para adicionar, editar, excluir e listar agendamentos.

## Tecnologias Utilizadas

- **Backend:**
  - Spring Boot (Java)
  - JPA (Java Persistence API) para persistência de dados
  - PostgreSQL como banco de dados

## Requisitos

- **Git**: Para clonar o repositório.
- **Java 17 ou superior**: Para rodar o Spring Boot.
- **PostgreSQL**: Para configurar e utilizar o banco de dados.

## Como Rodar o Projeto

### 1. Configuração do Banco de Dados

Este sistema utiliza o PostgreSQL como banco de dados. Antes de rodar o projeto, você precisa configurar o acesso ao banco de dados corretamente.

#### Editando o arquivo de configuração

O sistema utiliza o arquivo `application.properties` ou `application.yml` para configurar a conexão com o banco de dados. Esse arquivo está localizado em `src/main/resources`.

## Configuração
### Banco de Dados
1. Crie um banco de dados **PostgreSQL** com o nome **Agendamentos**:
   
       CREATE DATABASE Agendamentos;

## Dependências
As principais dependências estão listadas no **pom.xml**. Não esqueça de rodar o maven para baixar as dependências.

     mvn clean install

# Rodando o Projeto

1. Clone este repositório:
 
        git clone https://github.com/GabrielSoarde/AgendamentoDeServicos.git
        cd AgendamentoDeServicos
   
2. Configure as variáveis de ambiente:
   
- Abra o terminal (CMD) e digite:

      $env:BDNAME="NOME DO BANCO DE DADOS"
      $env:USER="SEU EMAIL"
      $env:PASSWORD="SUA SENHA"
  
- Para verificar se está tudo correto, digite no terminal (CMD):

      echo $env:BDNAME
      echo $env:USER
      echo $env:PASSWORD
  
3. Compile e execute o projeto:
   
        mvn spring-boot:run
   
# Como Utilizar o Postman para Testar a API

## Passos para Configurar o Postman

#### 1. Instalar o Postman

Se você ainda não tem o Postman instalado, faça o download e instale-o no seu computador a partir de https://www.postman.com/downloads/

#### 2. Criar uma Nova Requisição

1. Abra o **Postman**.
2. Clique no botão **New** no canto superior esquerdo e selecione **Request**.
3. Na janela que aparecer, escolha um nome para a requisição, adicione uma descrição se necessário, e clique em **Save**.

## Testando a API com o Postman

#### **1. Listar Agendamentos**

- **Método HTTP**: `GET`
- **URL**: `http://localhost:8080/scheduling`

1. No Postman, selecione o método `GET`.
2. Insira a URL `http://localhost:8080/scheduling`.
3. Clique em **Send**.
4. O Postman deve retornar uma lista de todos os agendamentos cadastrados.

#### **2. Obter um Agendamento Específico**

- **Método HTTP**: `GET`
- **URL**: `http://localhost:8080/scheduling/{id}`

1. No Postman, selecione o método `GET`.
2. Substitua `{id}` pela ID do agendamento que deseja consultar. Exemplo: `http://localhost:8080/scheduling/1`.
3. Clique em **Send**.
4. O Postman deve retornar os dados do agendamento com o ID informado.

#### **3. Criar um Novo Agendamento**

- **Método HTTP**: `POST`
- **URL**: `http://localhost:8080/scheduling`
- **Body**: JSON

1. No Postman, selecione o método `POST`.
2. Insira a URL `http://localhost:8080/scheduling`.
3. Vá para a aba **Body** e selecione a opção **raw**.
4. No campo de texto, insira o JSON com as informações do agendamento, como o exemplo abaixo:

```json
{
    "client": {
      "name": "João",
      "email": "joao@example.com",
      "phone": "(11) 98765-4321"
    },
    "date": "2024-12-01",
    "time": "10:00",
    "service": "Tatuagem",
    "price": 200.00
}
```

## Atualizar um Client:

1. No Postman, selecione o método `PUT`.
2. Na URL `http://localhost:8080/scheduling` insira o id do cliente que será atualizado:
`http://localhost:8080/scheduling/1`
3. Vá para a aba **Body** e selecione a opção **raw**.
4. No campo de texto, insira o JSON com as informações a serem atualizadas, como o exemplo abaixo:
```
{
    "client": {
      "name": "Carlos Ronaldo", 
      "email": "carlos.ronaldo@example.com", 
      "phone": "(11) 98765-4567"
    },
    "date": "2025-06-10",
    "time": "13:00",
    "service": "Piercing",
    "price": 60.00
}
```
e clique en SEND. O Postman deve retornar a confirmação de que o agendamento foi atualizado.

## Deletar um Client:
1. No Postman, selecione o método `DELETE`.
2. Na URL insira `http://localhost:8080/scheduling/{id}` subistituindo {id} pelo numero desejado.
3. Clique em SEND e o Postman deve retornar uma confirmação de que o agendamento foi deletado.



