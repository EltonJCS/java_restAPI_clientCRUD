# Projeto
API REST com funcionalidades de CRUD utilizando o microframework Spark.

## Explicação
O sistema é composto por quatro arquivos:
  1. **Client**: Classe de domínio para cliente com propriedades (id, nome, CPF, endereço, cidade e estado) e métodos (getters e setters).
  2. **ClientService**: Serviço que providencia a funcionalidade CRUD (criar, ler, atualizar e deletar).
  3. **ClientController**: Responsável por lidar com as solicitações recebidas, utilizando o Spark para roteamento.
  4. **Main**: Para iniciar o aplicativo é necessário criar um método principal (main()). Dentro do main cria-se uma instância do serviço (ClientService) que é passada como argumento para uma instância do controlador (ClientController).

## Rotas
Para criar, acessar, atualizar e excluir objetos da classe cliente, os seguintes métodos de requisição e URL são usadas:
| Método de requisição | Rota | Uso |
| ------ | ------ | ------ |
| POST | /clients | Cria um novo cliente |
| GET | /clients | Retorna uma lista de todos os clientes |
| GET | /clients/\<id\> | Retorna um cliente específico |
| PUT | /clients/\<id\> | Atualiza informações de um cliente específico |
| DELETE | /clients/\<id\> | Deleta um cliente específico |

O Spark iniciará um servidor Jetty incorporado que escuta na porta 4567. As rotas podem ser testadas na seguinte URL: **http://localhost:4567/clients**.

---

### API REST
Uma API, ou Interface de Programação de Aplicações, é um conjunto de regras que definem como aplicativos ou dispositivos podem se conectar e se comunicar entre si. Uma API REST é uma API que está em conformidade com os princípios de design do REST (Transferência Representacional de Estado). Por esse motivo, as APIs REST às vezes são chamadas de APIs RESTful.

### CRUD (Create, Read, Update and Delete)
Criar, Ler, Atualizar e Excluir (CRUD) são as quatro funções básicas que os modelos devem ser capazes de fazer.
Quando estamos construindo APIs, queremos que nossos modelos forneçam quatro tipos básicos de funcionalidade. O modelo deve ser capaz de criar, ler, atualizar e excluir recursos. Os cientistas da computação geralmente se referem a essas funções pelo acrônimo CRUD. Um modelo deve conseguir executar no máximo essas quatro funções para ser completo.
Em um ambiente REST, o CRUD geralmente corresponde aos métodos HTTP: POST, GET, PUT e DELETE, respectivamente. Esses são os elementos fundamentais de um sistema de armazenamento persistente.

### Spark
Spark é um microframework para aplicações web de software de código livre e aberto (FOSS) escrita em Java. Foi projetado para facilitar e agilizar a criação de APIs. Ele permite definir rotas e despachá-las para funções que responderão quando esses caminhos forem solicitados. Isso é feito em código usando uma interface direta, sem a necessidade de arquivos de configuração XML ou anotações.

## Referências
https://www.ibm.com/cloud/learn/rest-apis  
https://www.codecademy.com/article/what-is-crud  
https://dzone.com/articles/building-simple-restful-api  
