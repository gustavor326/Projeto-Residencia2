# API de Gestão de Clientes e Faturas

Esta é uma API desenvolvida em Java com Spring Boot para gerenciar informações de clientes, faturas e pagamentos. A aplicação permite o CRUD completo para cada entidade, incluindo operações específicas, como busca por CPF, ativação/desativação lógica de faturas e atualização automática do status de faturas com base nos pagamentos realizados.

## Tecnologias Utilizadas

- **Java 11+**
- **Spring Boot 2.5+**
- **JPA / Hibernate** para ORM
- **SQLServer**
- **Maven** para gerenciamento de dependências

## Estrutura da Aplicação

A aplicação está organizada nos seguintes pacotes:

- `controllers`: Contém os controllers (endpoints) que expõem a API.
- `model.entities`: Define as classes de entidade (Cliente, Fatura, Pagamento, StatusFatura).
- `model.repositories`: Contém os repositórios JPA para acesso e manipulação das entidades no banco de dados.
- `services`: Contém a lógica de negócio para manipulação das entidades (ClienteService, FaturaService, PagamentoService).

## Endpoints da API

Abaixo estão os principais endpoints para cada entidade.

### Cliente

- `POST /api/cliente`: Cria um novo cliente.
- `GET /api/cliente`: Lista todos os clientes.
- `GET /api/cliente/{id}`: Obtém um cliente pelo ID.
- `GET /api/cliente/nome/{parteNome}`: Busca clientes por parte do nome.
- `GET /api/cliente/cpf/{cpf}`: Busca cliente pelo CPF.
- `PUT /api/cliente/{id}`: Atualiza um cliente existente.
- `DELETE /api/cliente/fisica/{id}`: Deleta fisicamente um cliente pelo ID.

### Fatura

- `POST /api/fatura`: Cria uma nova fatura.
- `GET /api/fatura`: Lista todas as faturas.
- `GET /api/fatura/{id}`: Obtém uma fatura pelo ID.
- `GET /api/fatura/id/{clienteId}`: Busca faturas por ID de cliente.
- `GET /api/fatura/cpf/{cpf}`: Busca faturas pelo CPF do cliente.
- `PUT /api/fatura/{id}`: Atualiza uma fatura.
- `DELETE /api/fatura/logica/{id}`: Exclui logicamente uma fatura (define `faturaAtiva` como `false`).
- `DELETE /api/fatura/fisica/{id}`: Exclui fisicamente uma fatura.

### Pagamento

- `POST /api/pagamento`: Registra um novo pagamento.
- `GET /api/pagamento`: Lista todos os pagamentos.
- `GET /api/pagamento/{id}`: Obtém um pagamento pelo ID.
- `GET /api/pagamento/cpf/{cpf}`: Busca pagamentos pelo CPF do cliente.
- `PUT /api/pagamento/{id}`: Atualiza um pagamento existente.

## Regras de Negócio

1. **Pagamentos**: Quando um pagamento é registrado, o valor é adicionado à fatura correspondente, e o status da fatura é atualizado automaticamente para `PAGO` se o valor total de pagamentos for igual ou superior ao valor da fatura.
2. **Status da Fatura**: O status de uma fatura pode ser `PENDENTE`, `PAGO`, ou `VENCIDO`.
3. **Exclusão Lógica**: Faturas podem ser excluídas logicamente, alterando o campo `faturaAtiva` para `false`, o que indica que a fatura não deve ser considerada em listagens ativas, mas ainda está armazenada no banco.

## Configuração e Execução

### Pré-requisitos

- Java 11 ou superior
- Maven
- Banco de dados SQLServer configurado

### Executando o Projeto

1. Clone este repositório:
   git clone https://github.com/seuusuario/seurepositorio.git
