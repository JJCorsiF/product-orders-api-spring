# product-orders-api-spring
Esta é uma API para cadastro e consulta de pedidos. Foi desenvolvida e testada com o Java 1.8, utilizando o framework Spring.

## Setup
Para instalar a aplicação, primeiro acesse o diretório onde a aplicação rodará e clone a aplicação:

```bash
$ git clone git@github.com:JJCorsiF/product-orders-api-spring.git
```

## Configurando a aplicação
Para que a aplicação possa funcionar corretamente, é necessário ter instalado o JDK ou OpenJDK 1.8.x. É necessário ter também um banco de dados MySQL criado e rodando e um usuário com acesso a esse banco.

Para criar e configurar um banco de dados e um usuário com acesso a esse banco, execute os seguintes comandos:

```bash
$ mysql -u root -p -e "CREATE DATABASE IF NOT EXISTS <NOME DO BANCO DE DADOS DA APLICACAO>;"
$ mysql -u root -p -e "CREATE USER IF NOT EXISTS '<NOME DO USUÁRIO COM ACESSO AO BANCO>'@'localhost' IDENTIFIED BY '<SENHA DO USUARIO DO BANCO DE DADOS>';"
$ mysql -u root -p -e "GRANT ALL PRIVILEGES ON <NOME DO BANCO DE DADOS DA APLICACAO>.* TO '<NOME DO USUÁRIO COM ACESSO AO BANCO>'@'localhost';"
$ mysql -u root -p -e "FLUSH PRIVILEGES;"
$ mysql -u root -p -e "USE <NOME DO BANCO DE DADOS DA APLICACAO>;"
```

Para configurar a aplicação, no arquivo "src/main/resources/application.properties" substitua o trecho onde aparecem as propriedades abaixo com as informações do banco de dados de sua máquina/servidor:

```.properties
spring.datasource.url = jdbc:mysql://localhost:3306/<NOME DO BANCO DE DADOS DA APLICACAO>?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
spring.datasource.username = <NOME DO USUÁRIO COM ACESSO AO BANCO>
spring.datasource.password = <SENHA DO USUARIO DO BANCO DE DADOS>

# Outras configurações foram omitidas para brevidade
```

## Instalando as dependências
Para baixar e instalar as dependências da aplicação, na linha de comando acesse o diretório da aplicação e digite:

```bash
$ ./mvnw dependency:resolve
$ ./mvnw compile
```

## 

## Acessando a aplicação
Quando a aplicação iniciar, a API estará disponível em http://127.0.0.1:8080/.

As seguintes rotas estão disponíveis:
- *Listar todos os pedidos*: GET /pedidos

- *Listar Pedido por Número de Controle*: GET /pedidos/{numeroDeControle}

- *Listar Pedidos por Data de Cadastro*: GET /pedidos/data_cadastro/{dataDeCadastro}

- *Listar Pedidos por Código do Cliente*: GET /pedidos/cliente/{codigoDoCliente}

- *Adicionar Pedidos*: POST /pedidos

Exemplo do corpo da requisição (deve ter "Content-Type: application/json" no cabeçalho da requisição):
```json
[
	{
		"numeroDeControle": 5345,
		"nomeDoProduto": "Um produto muito bom",
		"precoDoProduto": 20.0,
		"codigoDoCliente": "12345"
	},
	{
		"numeroDeControle": 3325,
		"dataDeCadastro": "2020-09-24",
		"nomeDoProduto": "Curso de Java",
		"precoDoProduto": 200.0,
		"codigoDoCliente": "54321",
		"quantidadeDeProdutos": 10
	}
]
```
