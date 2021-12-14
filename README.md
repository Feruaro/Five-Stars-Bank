<img align="right" height="220em" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Logotipo%20Brilho%20Minimalista%20Chic%20.png"/>

# Bem-vindos ao Five Stars Bank :moneybag:

* Projeto desenvolvido para o banco Five Stars Bank, uma API para gerenciar as transações da nova plataforma que o banco está construindo. O sistema deve permitir cadastro de novos clientes, incluindo dados pessoais e dados para contato. O cliente deve ser atrelado a uma conta bancária e registrar histórico de transações entre as contas. 

* [Requisitos](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/requisitos_projeto.md)

  ​

| Sumário                                  | Informações                              |
| ---------------------------------------- | ---------------------------------------- |
| [Apresentação](#Apresentação)            | Tudo sobre os slides da apresentação a banca final |
| [Organização](#Organização)              | Tudo sobre a metodologia que utilizamos para organizar e dividir as funções |
| [Modelagem](#Modelagem)                  | Tudo sobre a modelagem do projeto        |
| [Banco de dados](#Bando-de-Dados---MySQL) | Tudo sobre o banco de dados utilizado e o script |
| [Documentação](#Documentação)            | Tudo sobre a documentação do projeto, utilizamos o Swagger |
| [AWS](#AWS)                              | Tudo sobre os serviços da AWS que utilizamos |
| [Projeto](#Projeto)                      | Tudo sobre informações do projeto com foco no back end |
| [Endpoint](#Endpoint)                    | Tudo sobre as funções de cada endpoint   |
| [Front end](#Front-end)                  | Tudo sobre o front end do projeto        |
| [Tecnologias](#Tecnologias)              | Tudo sobre as tecnologias utilizadas para a elaboração do projeto |
| [Squad](#Squad)                          | Tudo sobre a squad e os meios de contato com todos |

### 📅 Apresentação:

------------

* [Apresentação](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/Apresenta%C3%A7%C3%A3o_Banco_Pan.pdf)  

  ​

<img src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Apresentacao/1.jpg"/>



### 📂 Organização:

---------

* [Quadro Kanban - convite](https://trello.com/invite/b/WDxoUFpc/32cdd819c1cbc949e44a1bd175c74b85/kanban-5-stars-bank)

  ​

<img src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Trello/1.jpg"/>

<img src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Trello/2.jpg"/>

<img src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Trello/3.jpg"/>

<img src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Trello/4.jpg"/>



### ✏️ Modelagem:

--------

* **MER:**

![MER](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/mer_final.jpg)

* **DER:**

![DER](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/der_final.jpg)

* **Diagrama de classes:**

![dc](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/digrama_classes_final.jpg)



### 🖥️ Bando de Dados - MySQL:

--------

* [Script](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/script_database.sql)

  ​

### 📚 Documentação:

------

- Swagger - `/swagger-ui.html`:

- [Documentação SwaggerUI - pdf](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/SwaggerUI.pdf)

- [Documentação - pdf](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/Documenta%C3%A7%C3%A3o.pdf)

  ​

<img src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Swagger/swagger.jpg"/>



### ☁️ AWS:

------

- [AWS com EC2 e em Beanstalk](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/Elasti_%20Beanstalk.md)

- [SNS](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/SNS_Simple_Notification_Service.md)

- [API Gateway](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/API_Gateway.md)

- [Pipeline](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/Pipeline.md)

- [Lambda](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/Lambda.md)

  ​

### 🧑‍💻 Projeto:

--------

* [Sobre o código](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/explicacao_codigo.md)

* [Tratamento de exceptions](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/tratamento_exception.md)

* [Lista de endpoints](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/lista_%20endpoints.md)

* [Lista de JSON](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/lista_json.md)

  ​



### ⚙️ Endpoints:

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



### 📱 Front end:

---------

* Desenho no Figma do nosso [front end](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/Frontend.md)

  ​

 <img align="left" height="400em" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Front/1.jpg"/>

<img align="left" height="400em" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Front/5.jpg"/>

<img align="left" height="400em" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Front/32.jpg"/>

<img align="left" height="400em" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Front/33.jpg"/>



### 💻 Tecnologias:

---

Tecnologias e ferramentas utilizadas para desenvolver o projeto:



* [Trello](https://trello.com/)

* [Draw.io](https://app.diagrams.net/)

* [Java 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)

* [IDE - Eclipse](https://www.eclipse.org/downloads/)

* [Spring Boot](https://start.spring.io/)

* [Maven](https://mvnrepository.com/)

* [Postman](https://www.postman.com/) e [Imsomnia](https://insomnia.rest/download)

* [MySQL Worchbenk](https://www.mysql.com/products/workbench/)

* [Git](https://git-scm.com/downloads) e [GitHub](https://github.com/) 

* [AWS Elastic Beanstalk](https://docs.aws.amazon.com/pt_br/elasticbeanstalk/latest/dg/Welcome.html)

* [AWS SNS (Simple Notification Service)](https://docs.aws.amazon.com/pt_br/sns/latest/dg/welcome.html)

* [AWS API Gateway](https://docs.aws.amazon.com/pt_br/apigateway/latest/developerguide/welcome.html)

* [AWS CodePipeline](https://docs.aws.amazon.com/pt_br/codepipeline/latest/userguide/welcome.html)

* [AWS Lambda ](https://docs.aws.amazon.com/pt_br/lambda/latest/dg/welcome.html)

* [Figma](https://www.figma.com/)

  ​

### 👩‍💻 Squad:

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