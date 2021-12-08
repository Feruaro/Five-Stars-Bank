## Tratamento de Exceptions:

* Separamos nosso tratamento de Exceptions nas camadas Controller e Service.

  ​

### Controllers - Exceptions:

------

* **ExceptionHandlerController =** gerenciador das Exceptions, quando é lançado uma exception ele intercepta e faz o tratamento que foi implementado para cada tipo de Exception;


* **StandardError =** (StandardError = erro padrão) classe com os atributos de status http, mesagem do erro e tempo, então podemos instanciar um objeto dessa classe e utilizar para fazer o tratameto de exception na classe ExceptionHandlerController, a qual quando lançar uma exception a mesma intercepta e retorna um objeto de erro padrão, com os devidos atributos; Exception que estão implementadas para retornar esse erro:

  * ObjetoNaoEncontradoException;
  * ContaInativaException;
  * StatusInativoException;

* **FieldMessage =** (FieldMessage  = "mensagem de campo") essa classe é utilizada para as exception de validação, possui os atributos nome_campo e mensagem_erro, então quando é informado um dado inválido, é retornado qual o campo, como por exemplo cpf_cpnj, e retorna o motivo de ser inválido;

* **ValidationError =** extende da classe FielMessage, e utilizamos essa classe para retornar uma lista de FielMessage, a classe possui o método addError que serve para isso, pois o usuário pode informar mais de um campo inválido, então usamos para isso, para retornar um ou mais erros de validação;

  ​

### Service - Exceptions:

------

* **ContaInativaException =** possui dois retornos personalizados;
  * sem parâmetro é para quando tentamos deletar um cliente que possui uma ou mais contas ativas;
  * e com parâmetro (id) e para quando tentamos fazer uma movimentação numa conta inativa;

- **ObjetoNaoEncontradoException**:
  - possui um retorno personalizado, que recebe como parâmetro uma String e utilizamos quando procuramos um objeto no banco de dados e ele não é encontrado;
- **StatusInativoException =** possui dois retornos personalizados;
  - com um parâmetro (tipo) é para quando tentamos excluir um contato ou endereco, mas só temos 1 contato ou endereço ativo na lista daquele cliente;
  - com dois parâmetros (tipo, id) é para quando tentamos inativa um endereco ou contato que já está inativo;