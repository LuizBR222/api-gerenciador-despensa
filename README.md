API de Gerenciamento de Despensa e Geladeira
Esta é a API back-end para um sistema de gerenciamento de itens domésticos, permitindo o controle de produtos na despensa, geladeira, congelador e lista de compras.

Como Executar a API Localmente
Siga estes passos para configurar e executar a API na sua máquina.

1. Pré-requisitos
   Antes de começar, garanta que você tem os seguintes programas instalados:

Java JDK 17 ou superior

Maven 3 ou superior

PostgreSQL (um servidor de banco de dados rodando localmente)

Uma IDE para Java, como IntelliJ IDEA ou VS Code (recomendado)

2. Configuração do Banco de Dados (Passo Essencial)
   Para que a API possa guardar os dados, ela precisa de se conectar a um banco de dados PostgreSQL.

a) Crie um Banco de Dados Vazio:
Abra a sua ferramenta de gerenciamento do PostgreSQL (como o pgAdmin) e crie um novo banco de dados. Por exemplo, pode chamá-lo de gerenciador_despensa_db.

b) Edite o Ficheiro de Configuração:
Dentro do projeto, encontre e abra o ficheiro de configurações no seguinte caminho:
src/main/resources/application.properties

c) Altere as Credenciais:
Dentro deste ficheiro, você precisa de alterar as 3 linhas a seguir para que correspondam à configuração do seu banco de dados local.

# Endereço do seu banco de dados.
# Altere "gerenciador_despensa_db" para o nome do banco que você criou.
spring.datasource.url=jdbc:postgresql://localhost:5432/gerenciador_despensa_db

# Seu nome de utilizador do PostgreSQL (geralmente "postgres").
spring.datasource.username=seu-usuario-aqui

# A sua senha do PostgreSQL.
spring.datasource.password=sua-senha-aqui

A linha abaixo é muito importante, pois faz com que a API crie as tabelas automaticamente no seu banco de dados na primeira vez que for executada. Deixe-a como está.

spring.jpa.hibernate.ddl-auto=update

3. Executando a Aplicação
   Depois de configurar o banco de dados, você pode iniciar a API:

Usando uma IDE (Método Fácil):

Abra o projeto na sua IDE (IntelliJ, VS Code, etc.).

Aguarde a IDE baixar todas as dependências do Maven.

Encontre a classe principal FridgeManagerApplication.java.

Clique com o botão direito sobre ela e selecione "Run".

Usando a Linha de Comando:

Abra um terminal na pasta raiz do projeto.

Execute o comando: mvn spring-boot:run

Se tudo estiver correto, você verá no console uma mensagem a dizer Tomcat started on port 8080 (http). Isto significa que a API está no ar!

4. Verificando os Endpoints
   Para testar se a API está a funcionar e a devolver dados, você pode usar o site de verificação incluído no projeto.

Navegue até a pasta docs no projeto.

Abra o ficheiro verificar.html no seu navegador.

Clique nos botões para ver os itens de cada área (Despensa, Geladeira, etc.).