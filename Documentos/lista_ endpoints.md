### Lista de Endpoints:

------------------

| Endpoints               | Método | Funcionalidade                           |
| ----------------------- | ------ | ---------------------------------------- |
| /clientes/{id}          | GET    | Exibe todas as informações do cliente    |
| /clientes               | GET    | Exibe as informações de todos os clientes |
| /clientes/snsEmail/{id} | GET    | Envia o e-mail de confirmação do cadastro do cliente |
| /clientes               | POST   | Cadastra o cliente                       |
| /clientes/{id}          | PUT    | Atualiza as informações do cliente       |
| /clientes/{id}          | DELETE | Exclui um cliente e todas suas informações |
| /enderecos/{id}         | POST   | Adiciona um endereço a um cliente existente |
| /enderecos/{id}         | PUT    | Exclui um endereço de algum cliente      |
| /contatos/{id}          | POST   | Adiciona um contato a um cliente existente |
| /contatos/{id}          | PUT    | Exclui um contato de algum cliente       |
| /contas/{id}            | POST   | Cadastra conta a um cliente existente    |
| /contas/{id}            | PUT    | Fechar a conta do cliente existente      |
| /contas/{id}/{periodo}  | GET    | Exibe o extrato de uma conta a partir de um periodo de dias |
| /movimentacoes/{id}     | GET    | Listar movimentações da conta de um cliente |
| /movimentacoes/{id}     | POST   | Cadastra uma transação relacionada a conta de um cliente, e envia um e-mail com as informações da transação |
| /swagger-ui.html        |        | Documentação Swagger                     |



