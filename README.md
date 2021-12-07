<img align="right" height="220em" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/Logotipo%20Brilho%20Minimalista%20Chic%20.png"/>

# Bem-vindos ao Five Stars Bank :moneybag:

* Projeto desenvolvido para o banco fictício BlueBank, uma API para gerenciar as transações da nova plataforma que o banco está construindo. O sistema deve permitir cadastro de novos clientes, incluindo dados pessoais e dados para contato. O cliente deve ser atrelado a uma conta bancária e registrar histórico de transações entre as contas.

* [Requisitos](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/requisitos_projeto.md)

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

### Projeto:

--------

* [Explicação sobre o código](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/explicacao_codigo.md)


* [Lista de endpoints](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/lista_%20endpoints.md)

* [Lista de JSON](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/lista_json.md)

* [Tratamento de exceptions](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Documentos/tratamento_exception.md)

  ​

### Endpoints:

-----

* POST - `/clientes`


![cadastro cliente](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/cadastro_cliente.jpg)

![email](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/cadastro_cliente2.jpg)

<img align="center" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/cadastro_cliente3.jpg"/>

* GET - `/clientes/snsEmail/{id}`

![sns email](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/enviar_email.jpg)

![email](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/enviar_email2.jpg)

* POST - `/enderecos/{id}`

![adicionar end](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/adicionar_endereco.jpg)

* PUT - `/enderecos/{id}`

![inativar end](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/inativar_endereco.jpg)

![inativar end exception](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/inativar_endereco_exception2.jpg)

![inativar end exception](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/inativar_endereco_exception.jpg)

* GET - `/clientes`

<img align="center" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/listar_clientes_aws.jpg"/>

* GET - `/clientes?size=1&page=1`

![listar](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/listar_clientes_pag1.jpg)

* PUT - `/clientes/{id}`

![atualizar](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/atualizar_cliente.jpg)

* GET - `/clientes/{id}`

<img align="center" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/buscar_cliente.jpg"/>

<img align="center" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/buscar_cliente2.jpg"/>

<img align="center" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/buscar_cliente_exception.jpg"/>

![buscar exception](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/buscar_cliente_exception2.jpg)

* POST - `/contas/{id}`

![cadastro conta](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/cadastrar_conta.jpg)

* POST - `/movimentacoes/{id}`

![incluir](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/incluir_movi.jpg)

![incluir](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/incluir_movi2.jpg)

![email incluir 1](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/incluir_movi_email.jpg)

* GET - `/movimentacoes/{id}?size=3&page=0`

![lista movi 1](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/listar_movi.jpg)

<img align="center" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/listar_movi2.jpg"/>

* GET - `/contas/{id}/{periodo}`

![extrato](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/extrato.jpg)

<img align="center" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/extrato2.jpg"/>

* DELETE - `/clientes/{id}`

![deletar exception](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/deletar_cliente_exception.jpg)

* PUT - `/contas/{id}`

![fechar conta](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/fechar_conta.jpg)

* POST - `/movimentacoes/{id}`

![incluir exception](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/incluir_movi_exception.jpg)

* DELETE - `/clientes/{id}`

![deletar](https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/deletar_cliente.jpg)

<img align="center" src="https://github.com/Feruaro/Five-Stars-Bank/blob/main/Imagens/deletar_cliente2.jpg"/>

### AWS:

------

* [AWS com EC2 e em Beanstalk - vídeo]()

* [Lambda]()

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