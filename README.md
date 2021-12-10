<img align="right" height="220em" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Logotipo%20Brilho%20Minimalista%20Chic%20.png"/>

# Bem-vindos ao Five Stars Bank :moneybag:

* Projeto desenvolvido para o banco Five Stars Bank, uma API para gerenciar as transações da nova plataforma que o banco está construindo. O sistema deve permitir cadastro de novos clientes, incluindo dados pessoais e dados para contato. O cliente deve ser atrelado a uma conta bancária e registrar histórico de transações entre as contas.

* [Requisitos](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/requisitos_projeto.md)

  ​

### Organização:

---------

* [Quadro Kanban - convite](https://trello.com/invite/b/WDxoUFpc/32cdd819c1cbc949e44a1bd175c74b85/kanban-5-stars-bank)

* *espaço para foto do quadro - colocar no sab*

  ​

### MER:

--------

![MER](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/mer_final.jpg)



### DER:

----

![DER](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/der_final.jpg)



### Diagrama de Classes:

-------

![dc](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/digrama_classes_final.jpg)



### Bando de Dados - MySQL:

--------

* [Script](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/script_database.sql)

  ​

### Documentação:

------

- [Swagger](http://fivestarsbank-env.eba-ppa5qcjh.us-west-1.elasticbeanstalk.com/swagger-ui.html)

  ​

### AWS:

------

- [AWS com EC2 e em Beanstalk](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/Elasti_%20Beanstalk.md)

- [SNS](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/SNS_Simple_Notification_Service.md)

- [API Gateway](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/API_Gateway.md)

- [Pipeline](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/Pipeline.md)

- [Lambda](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/Lambda.md)

  ​

### Projeto:

--------

* [Explicação sobre o código](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/explicacao_codigo.md)


* [Lista de endpoints](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/lista_%20endpoints.md)

* [Lista de JSON](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/lista_json.md)

* [Tratamento de exceptions](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/tratamento_exception.md)

* [vídeo do projeto]()

  ​

### Endpoints:

-----

* POST - `/clientes`


![cadastro cliente](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/cadastro_cliente.jpg)

![email](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/cadastro_cliente2.jpg)

<img align="center" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/cadastro_cliente3.jpg"/>

* GET - `/clientes/snsEmail/{id}`

![sns email](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/enviar_email.jpg)

![email](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/enviar_email2.jpg)

* POST - `/enderecos/{id}`

![adicionar end](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/adicionar_endereco.jpg)

* PUT - `/enderecos/{id}`

![inativar end](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/inativar_endereco.jpg)

![inativar end exception](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/inativar_endereco_exception2.jpg)

![inativar end exception](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/inativar_endereco_exception.jpg)

* GET - `/clientes`

<img align="center" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/listar_clientes_aws.jpg"/>

* GET - `/clientes?size=1&page=1`

![listar](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/listar_clientes_pag1.jpg)

* PUT - `/clientes/{id}`

![atualizar](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/atualizar_cliente.jpg)

* GET - `/clientes/{id}`

<img align="center" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/buscar_cliente.jpg"/>

<img align="center" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/buscar_cliente2.jpg"/>

<img align="center" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/buscar_cliente_exception.jpg"/>

* POST - `/contas/{id}`

![cadastro conta](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/cadastrar_conta.jpg)

* POST - `/movimentacoes/{id}`

![incluir](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/incluir_movi.jpg)

![incluir](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/incluir_movi2.jpg)

![email incluir 1](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/incluir_movi_email.jpg)

* GET - `/movimentacoes/{id}?size=3&page=0`

![lista movi 1](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/listar_movi.jpg)

<img align="center" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/listar_movi2.jpg"/>

* GET - `/contas/{id}/{periodo}`

![extrato](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/extrato.jpg)

<img align="center" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/extrato2.jpg"/>

* DELETE - `/clientes/{id}`

![deletar exception](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/deletar_cliente_exception.jpg)

* PUT - `/contas/{id}`

![fechar conta](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/fechar_conta.jpg)

* POST - `/movimentacoes/{id}`

![incluir exception](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/incluir_movi_exception.jpg)

* DELETE - `/clientes/{id}`

![deletar](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/deletar_cliente.jpg)

<img align="center" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Endpoints/deletar_cliente2.jpg"/>


### Tecnologias:

---

Tecnologias e ferramentas utilizadas para desenvolver o projeto:

* Trello -> quadro Kanban utilizado para organização da squad;

* Draw.io -> ferramenta para desenho do diagramas;

* IDE - Eclipse -> IDE de desenvolvimento do back end;

* Postman e Imsomnia -> API Client utilizado para testes da API;

* MySQL Worchbenk -> ferramenta utilizada para o gerenciamento e testes do banco de dados;

* Git -> utilizado para o controle de versões do código e da documentação;

* GitHub -> utilizada para armazenar as versões do código e documentações do projeto;

* Elastic Beanstalk -> serviço utilizada para implantação da API;

* SNS (Simple Notification Service) -> serviço de notificação que utilizamos para entrega de e-mails aos clientes;

* API Gateway -> ferramenta de gerenciamento de API;

* AWS Builder -> serviço básico de gerenciamento de imagens;

* Lambda -> programa orientado a eventos;

  ​

### Squad Five Stars Bank:

-------

* Fábio Pedroza:  [linkedin](https://www.linkedin.com/in/f%C3%A1bio-pedroza-analistaprotheus/) |  [GitHub](https://github.com/fabiopedroza)

* Fernanda Ayres Ruaro:  [linkedin](https://www.linkedin.com/in/fernanda-ruaro/) |  [GitHub](https://github.com/Feruaro)

* Itaici Plessmann de Carvalho:  [linkedin](https://www.linkedin.com/in/itaici-plessmann-de-carvalho-45413b42/) |  [GitHub](https://github.com/itaici)

* Letícia dos Santos:  [linkedin](https://www.linkedin.com/in/ldsleticia/) |  [GitHub](https://github.com/ldsleticia)

* Rodrigo Medeiros da Silva:  [linkedin](https://www.linkedin.com/in/rodrigomedeiros89/) |  [GitHub](https://github.com/MedeirosRodrigo)

  ​

---------------

<img align="left" height="150em" width="145em" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/squad/Fabio.png"/>

<img align="left" height="150em" width="145em" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/squad/fernanda.jpg"/>

<img align="left" height="150em" width="145em" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/squad/itaici.png"/>

<img align="left" height="150em" width="145em" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/squad/Le.jpg"/>

<img align="left" height="150em" width="145em" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/squad/Rodrigo.jpg"/>