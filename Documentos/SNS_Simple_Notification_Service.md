<img align="right" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/SNS/foto.jpg"/>

## SNS - Simple Notification Service:

* Passo a passo de como resolvemos implementar o serviço de notificação da AWS, utilizando o protocolo "email"

  ​

### Configurações no código:

--------

* Adicionamos as seguintes dependências no arquivo [pom.xml](https://github.com/Feruaro/Five-Stars-Bank/blob/main/FiveStarsBank/pom.xml):

  ​

[Spring Cloud AWS Starter](https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-aws/2.2.6.RELEASE)

[Spring Cloud AWS Messaging Starter](https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-aws-messaging/2.2.6.RELEASE)

<img align="center" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/SNS/1_sns.jpg"/>

* Criamos uma classe de configuração -  [AWSConfig](https://github.com/Feruaro/Five-Stars-Bank/blob/main/FiveStarsBank/src/main/java/br/com/fivestarsbank/BlueBank/config/sns/AWSSNSConfig.java):

  ​

> Nessa classe informamos a chave de acesso e chave de acesso secreta (Security credentials) e qual a região

<img align="center" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/SNS/2_sns.jpg"/>

* Depois de adicionar as dependências e fazer as devidas configurações decidimos de que forma iríamos implementar o service de notificação utilizando o protocolo "email" no nosso projeto, e a nossa decisão foi utilizar no cadastro do cliente e no cadastro de transação entre contas. Então primeiramente criamos a classe [SNSService](https://github.com/Feruaro/Five-Stars-Bank/blob/main/FiveStarsBank/src/main/java/br/com/fivestarsbank/BlueBank/service/SNSEmailService.java) a qual os outros services poderiam utilizar:

  ​

<img align="center" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/SNS/3_sns.jpg"/>

### Implementação no cadastro do cliente:

----------

* Implementamos na classe [ClienteService](https://github.com/Feruaro/Five-Stars-Bank/blob/main/FiveStarsBank/src/main/java/br/com/fivestarsbank/BlueBank/service/ClienteService.java) a criação do topic e subscription no topic, no método cadastrar, então quando o cliente fazer o cadastro no sistema, utilizamos o e-mail informado:



<img align="center" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/SNS/4_sns.jpg"/>

* Depois implementamos um método GET na classe [ClienteController](https://github.com/Feruaro/Five-Stars-Bank/blob/main/FiveStarsBank/src/main/java/br/com/fivestarsbank/BlueBank/controllers/ClienteController.java) a qual envia um e-mail ao topic a qual o cliente confirmou a subscription que confirma o seu cadastro no sistema:

  ​

<img align="center" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/SNS/5_sns.jpg"/>

<img align="center" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/SNS/6_sns.jpg"/>

### Implementação no cadastro de transação entre contas:

--------

* Implementamos na classe [MovimentacaoService](https://github.com/Feruaro/Five-Stars-Bank/blob/main/FiveStarsBank/src/main/java/br/com/fivestarsbank/BlueBank/service/MovimentacaoService.java) no método incluir o envio de e-mail ao topic a qual o cliente confirmou a subscription, no e-mail consta as principais informações sobre a transação realizada na conta do cliente: 

  ​

<img align="center" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/SNS/7_sns.jpg"/>

<img align="center" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/SNS/8_sns.jpg"/>



### Endpoints - Cliente:

-------

* POST - `/clientes`:

  ​

![cadastro cliente](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/cadastro_cliente.jpg)

![email](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/cadastro_cliente2.jpg)

<img src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/cadastro_cliente3.jpg"/>

* GET - `/clientes/enviarSNS/{id}`:

  ​

![sns email](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/enviar_email.jpg)

![email](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/enviar_email2.jpg)

### Endpoints - Movimentacao:

-------

* POST - `/movimentacoes/{id}`:

  ​

![incluir](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/incluir_movi2.jpg)

![email incluir 1](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/incluir_movi_email.jpg)