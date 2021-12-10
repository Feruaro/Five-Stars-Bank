<img align="right" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/foto.jpg"/>

## Vamos para uma breve explicação do código:

### Models:

---------

* **Models:** (anotações dos atributos dos models, @NotNull por exemplo, para comunicar ao banco de dados os limites de cada campo)

  * **Cliente =** atributos do Cliente, construtores, getters e setters;

  * **Conta =** atributos da Conta, construtores, getters e setters;

  * **Contato =** atributos do Contato, construtores, getters e setters;

  * **Endereco =** atributos do Endereco, construtores, getters e setters;

  * **Movimentacao =** atributos da Movimentacao, construtores, getters e setters;

  * **Saldo =** atributos do Saldo, construtores, getters e setters;

  * **SaldoPK =** classe para chave composta;

    ​

* **Models - DTO:** 

  * DTO - Objeto de Transferência de Dados - utilizado para fazer a comunicação entre Client e Controller, ao invés de utilizar o model diretamente;

  * anotações dos atributos dos DTO, @NotEmpty por exemplo, servem como validações dos dados que o usuário informar, por causa das configurações da validação na classe ExceptionHandler é necessário a criação dessas anotações para capturar e tratar as exceptions;

  * **ClienteDTO =** classe para o método Cadastrar do Cliente, nessa classe possui os atributos das classes Cliente, Endereco e Contato, assim podemos fazer o cadastro do cliente abrangendo essas 3 classes | utiliza a anotação @ClienteCadastro;

  * **ClienteDTO2  =** classe para o método Atualizar do Cliente, nessa classe possui somente os atributos que podem ser atualizados | utiliza a anotação @ClienteAtualizacao;

  * **ContatoDTO =** classe para o método Adicionar do Contato | utiliza a anotação @ContatoAdicionar;

  * **EnderecoDTO =** classe para o método Adicionar do Endereco| utiliza a anotação @EnderecoAdicionar;

  * **ExtratoDTO =** classe para o método exibirExtrato da Conta;

  * **MovimentacaoDTO =** classe para o método Incluir da Movimentacao | utiliza a anotação @MovimentacaoIncluir;

    ​

* **Models - ENUM:**

  * Método *toEnum* = recebe um número e converte para Enum -  todas as classes possuem;

  * **DebitoCredito =** 1-Debito | 2-Credito -> utilizado para informar na movimentação;

  * **StatusConta =** 1-Ativo (assim que cadastra a conta) | 2-Inativo (quando utilizado o método inativarConta);

  * **StatusEnderecoContato =** 1-Ativo (assim que adiciona o contato) | 2-Inativo (quando utilizado o método inativarContato)  |  1-Ativo (assim que adiciona o endereço) | 2-Inativo (quando utilizado o método inativarEndereco);

  * **TipoCliente =** 1-PF | 2-PJ  ->  para gerenciar o tipo de pessoa e verificar os documentos informados;

  * **TipoTransacao =** temos 5 tipos de transações possíveis;

    ​

### Controllers:

--------

* **Controllers:**

  * Utiliza a anotação @RestController e se comunica com Client e Service;

  * **ClienteController =** classe com os métodos de CRUD (cadastrar, buscar / listar, atualizar e deletar), e no método cadastrar temos implementado o criar tópico, criar assinatura e mandar e-mail;

  * **ContaController =** classe com os métodos de cadastrar, inativarConta e exibirExtrato;

  * **ContatoController =** classe com os métodos de adicionar e inativarContato;

  * **EnderecoController =** classe com os métodos de adicionar e inativarEndereco;

  * **MovimentacaoController =** classe com os métodos de incluir e listarMovimentacao;

    ​

* **Controllers - Exceptions:**

  * **ExceptionHandlerController =** gerenciador das Exceptions, quando é lançado uma exception ele intercepta e faz o tratamento que foi implementado para cada tipo de Exception;
  * **StandardError =** (StandardError = erro padrão) classe com os atributos de status http, mesagem do erro e tempo, então podemos instanciar um objeto dessa classe e utilizar para fazer o tratameto de exception na classe ExceptionHandlerController, a qual quando lançar uma exception a mesma intercepta e retorna um objeto de erro padrão, com os devidos atributos; Exception que estão implementadas para retornar esse erro:
    * ObjetoNaoEncontradoException;
    * ContaInativaException;
    * StatusInativoException;
  * **FieldMessage =** (FieldMessage  = "mensagem de campo") essa classe é utilizada para as exception de validação, possui os atributos nome_campo e mensagem_erro, então quando é informado um dado inválido, é retornado qual o campo, como por exemplo cpf_cpnj, e retorna o motivo de ser inválido;
  * **ValidationError =** extende da classe FielMessage, e utilizamos essa classe para retornar uma lista de FielMessage, a classe possui o método addError que serve para isso, pois o usuário pode informar mais de um campo inválido, então usamos para isso, para retornar um ou mais erros de validação;

  ​

### Repositories:

--------

* **Repositories:**

  * Utiliza a anotação @Repository e se comunica com o banco de dados;
  * Implementam a classe JpaRepository<Classe,Tipo_PK>, como utilizamos como interface não implementamos nenhum método nessa classe;
  * **ClienteRepository**;
  * **ContaRepository**;
  * **ContatoRepository**;
  * **EnderecoRepository**;
  * **MovimentacaoRepository**;
  * **SaldoRepository**;

  ​

### Service:

---------

* **Service:**	

  * Utiliza a anotação @Service e se comunica com Controller e Repository;

  * **ClienteService**:

    * Métodos:
      * Buscar : recebe o id do cliente e retorna um Cliente, caso não tenha nenhum cliente com esse id lança a exception ObjetoNaoEncontradoException;
      * Listar : lista todos os clientes armazenados no banco de dados;
      * Salvar : recebe um objeto Cliente e o salva no banco de dados;
      * ConverterDTOCadastrar : recebe um objeto ClienteDTO e salva os dados informados nos respectivos objetos, que são Cliente, Contato e Endereco, e retorna um objeto Cliente;
      * Cadastrar : recebe o objeto Cliente, que foi convertido do método anterior, e salva no banco de dados, salva Contato e Endereco também;
      * Atualizar : recebe um objeto ClienteDTO2, converte em um objeto Cliente e salva as alterações no banco de dados;
      * Deletar: recebe um id de cliente, verifica se tem esse cliente no banco de dados, utiliza o método VerificarContas  e o deleta, caso não tenha o cliente no banco de dados lança a exception ObjetoNaoEncontradoException, e caso o cliente tenha alguma conta ativa lança a exception ContaInativaException;
      * VerificarContas : recebe um objeto Cliente e verifica se todas as contas daquele cliente estão inativas, se tiver conta ativa retorna true, se não retorna false; 
      * MensagemEmail : retorna o corpo da mensagem enviado quando o cliente efetua o cadastro;

  * **ContaService**:

    * Métodos:
      * Buscar : recebe o id da conta e retorna um objeto Conta, caso não tenha nenhuma conta com esse id lança a exception ObjetoNaoEncontradoException;
      * Listar : lista todas as contas armazenadas no banco de dados;
      * Salvar : recebe um objeto Conta e o salva no banco de dados;
      * Cadastrar : recebe o um id de cliente e verifica se existe esse cliente no banco de dados, caso não lança a exception ObjetoNaoEncontradoException. Caso tenha o cliente é instanciado um objeto de Conta e salva as informações sobre nos atributos e depois salva no banco de dados, e depois intancia um objeto Saldo e também salva no banco de dados;
      * GeradorNumeroConta : gere um número de 6 dígitos e de forma aleatória para o atributo numero_conta, é verificado se já possui alguma conta no banco de dados com esse número gerado, caso sim é gerado outro número, se não retorna esse número;
      * InativarConta : recebe um id de conta, verifica se possui essa conta no banco de dados e altera o atributo status para inativo, caso não tenha nenhuma conta com esse id lança a exception ObjetoNaoEncontradoException;
      * ExibirExtrato : recebe um id de conta, verifica se possui essa conta no banco de dados e caso não tenha nenhuma conta com esse id lança a exception ObjetoNaoEncontradoException, se possui a conta esse método formata e retorna um objeto ExtratoDTO, para exibir um extrato daquela conta informada dentro de um período de dias;
      * VerificarDatas : verifica se a data final do período informado for maior que a data de abertura da conta, retorna a data de abertura como final do período, se não retorna a data final do período;
      * ListarMovimentações : retorna uma lista de movimentações, dentro do período informado;
      * CalcularSaldoFinal : recebe essa lista do método anterior e faz os calculos do saldo, verificando os valores de cada transacao e se foi credito ou debito naquela conta;

  * **ContatoService**:

    * Métodos:
      * Buscar : recebe o id de contato e retorna um objeto Contato, caso não tenha nenhum contato com esse id lança a exception ObjetoNaoEncontradoException;
      * Listar : lista todas os contatos armazenados no banco de dados;
      * Salvar : recebe um objeto Contato e o salva no banco de dados;
      * SalvarLista : recebe uma lista de objeto Contato e o salva no banco de dados;
      * Adicinar: recebe o id do cliente e retorna um Cliente, caso não tenha nenhum cliente com esse id lança a exception ObjetoNaoEncontradoException, caso tenha o cliente pegamos o objeto ContatoDTO e convertemos para um objeto Contato e salvamos na lista de contato daquele cliente e salvamos o contato no banco de dados;
      * ConverterDTO : converte um objeto ContatoDTO em um objeto Contato, retornando o mesmo;
      * InativarContato :  recebe o id de contato e verifica se possui algum contato com esse id, caso não tenha nenhum contato com esse id lança a exception ObjetoNaoEncontradoException, caso tenha o contato é feita a verificação com o método QntdContatosInativosalterado, se o retorno for maior que 1 fazemos a alteração do status para inativo e salva as alterações no banco de dados, caso o status desse contato já esteja inativo lança a exception StatusInativoException, e caso o retorno do método seja menor que 1 lança essa mesma exception;
      * QntdContatosInativos : recebe um objeto Cliente e verifica quantos contatos inativos aquele cliente possui, e retorna essa quantidade, fazendo a subtração do tamanho total da lista e da quantidade de contatos inativos;

  * **EnderecoService**: todos os métodos do Endereco são iguais ao do Contato;

  * **MovimentacaoService**:

    * Métodos:
      * Buscar : recebe o id de movimentação e retorna um objeto Movimentacao, caso não tenha nenhuma movimentação com esse id lança a exception ObjetoNaoEncontradoException;
      * Listar : retorna uma lista de Movimentacao;
      * ConverterDTO : recebe um MovimentacaoDTO e converte em Movimentacao e retorna o objeto;
      * Incluir : recebe o id da conta, verifica no banco de dados se possui aquela conta, caso não tenha nenhuma conta com esse id lança a exception ObjetoNaoEncontradoException, caso tenha a conta e a mesma está ativa é salvo o objeto Movimentacao, que foi convertido pelo método anterior e o salvo no banco de dados, caso a conta esteja inativa lança a exception ContaInativaException;
      * GerarAssuntoEmail : recebe um objeto Movimentacao e retorna o assunto para enviar no e-mail quando é feita uma transação;
      * GerarMensagemEmail : recebe um objeto Movimentacao e retorna o corpo do e-mail para enviar no e-mail quando é feita uma transação;

  * **SaldoService**:

    * Métodos:
      * Buscar : recebe uma data e uma conta, instancia a chave composta do saldo e retorna um objeto Saldo, caso não tenha nenhum saldo com essa chave composta lança a exception ObjetoNaoEncontradoException;
      * Salvar : recebe um objeto Saldo e o salva no banco de dados;

  * **SNSEmailService**:

    * Métodos:
      * CriarTopico : faz uma requisação da AWS para criar um tópico - SNS - com o nome que informamos e retorna um ARN;
      * AdicionarAssinaturaTopico : cria uma requisação de assinatura para um tópico, passamos como parâmetro o ARN (criado no tópico), o protocolo (no nosso caso é "email") e o email do cliente, e envia um email para esse email informada para confirmar a assinatura;
      * EnviarEmail : envia email para o ARN informado, e passamos como parâmetro o ARN (criado no tópico), o corpo do email e o assunto;

    ​

* **Service - Exceptions:**

  * **ContaInativaException =** possui dois retornos personalizados;

    * sem parâmetro é para quando tentamos deletar um cliente que possui uma ou mais contas ativas;
    * e com parâmetro (id) e para quando tentamos fazer uma movimentação numa conta inativa;

  * **ObjetoNaoEncontradoException**:

    * possui um retorno personalizado, que recebe como parâmetro uma String e utilizamos quando procuramos um objeto no banco de dados e ele não é encontrado;

  * **StatusInativoException =** possui dois retornos personalizados;

    * com um parâmetro (tipo) é para quando tentamos excluir um contato ou endereco, mas só temos 1 contato ou endereço ativo na lista daquele cliente;
    * com dois parâmetros (tipo, id) é para quando tentamos inativa um endereco ou contato que já está inativo;

    ​

* **Service - Validation:**

  * **ClienteAtualizacao =** anotação criada para validação da atualização de cliente, é utilizada na classe ClienteDTO2;

  * **ClienteAtualizacaoValidator =** classe que "gerencia / valida" a anotação @ClienteAtualizaçao;

    * Todos os campos que forem informados de forma inválida, capturamos o erro com a classe FieldMessage, e adicionamos numa lista de FieldMessage, e se está lista tiver um ou mais erros lançam esses erros, se não é feita a atualização do cliente;

  * **ClienteCadastro =** anotação criada para validação do cadastro de cliente, é utilizada na classe ClienteDTO;

  * **ClienteCadastroValidator =** classe que "gerencia / valida" a anotação @ClienteCadastro;

    * Nela temos as validações de cpf / cnpj (utilizamos a classe ValidaDocumentosCPF_CNPJ para validar), telefone, e campos únicos;
    * Todos os campos que forem informados de forma inválida, capturamos o erro com a classe FieldMessage, e adicionamos numa lista de FieldMessage, e se está lista tiver um ou mais erros lançam esses erros, se não é feita a atualização do cliente;

  * **ContatoAdicinar =** anotação criada para validação do adicionar do contato, é utilizada na classe ContatoDTO;

  * **ContatoAdicionarValidator =** classe que "gerencia / valida" a anotação @ContatoAdicinar;

    * Todos os campos que forem informados de forma inválida, capturamos o erro com a classe FieldMessage, e adicionamos numa lista de FieldMessage, e se está lista tiver um ou mais erros lançam esses erros, se não é feita a atualização do cliente;

  * **EnderecoAdicionar =** anotação criada para validação do adicionar do endereco, é utilizada na classe EnderecoDTO;

  * **EnderecoAdicionarValidator =** classe que "gerencia / valida" a anotação @EnderecoAdicionar;

    * Todos os campos que forem informados de forma inválida, capturamos o erro com a classe FieldMessage, e adicionamos numa lista de FieldMessage, e se está lista tiver um ou mais erros lançam esses erros, se não é feita a atualização do cliente;

  * **MovimentacaoIncluir =** anotação criada para validação do incluir da movimentacao, é utilizada na classe MovimentacaoDTO;

  * **MovimentacaoIncluirValidator =** classe que "gerencia / valida" a anotação @MovimentacaoIncluir;

    * Todos os campos que forem informados de forma inválida, capturamos o erro com a classe FieldMessage, e adicionamos numa lista de FieldMessage, e se está lista tiver um ou mais erros lançam esses erros, se não é feita a atualização do cliente;

    ​

* **Service - Validation - Utils:**

  * **ValidaDocumentosCPF_CNPJ =** classe com cálculos de validação de cpf e cnpj, com a nomenclatura correta (isValid) para utilizamos nas classes Validator;

  ​

### Config:

----------

* **SNS - Config:**
  * **AWSSNSConfig =** configuração do SNS da AWS, informamos a chave de acesso e a chave secreta de acesso do token security, e qual a região;
* **Swagger - Config:**
  * **SwaggerConfig =** configuração da documentação Swagger do projeto;