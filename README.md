# Folder Creator

Este projeto é uma aplicação Java que permite ao usuário criar pastas em um diretório de sua escolha, utilizando uma interface gráfica simples.

## Funcionalidades
- **Escolha de diretório**: Permite ao usuário selecionar o local onde deseja criar a pasta.
- **Criação de pastas**: Cria uma pasta com o nome escolhido pelo usuário no diretório selecionado.
- **Mensagens de status**: Exibe mensagens indicando o sucesso ou erro durante a criação da pasta.

## Pré-requisitos

- [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (versão 8 ou superior)
- Editor de código ou IDE (por exemplo, [Eclipse](https://www.eclipse.org/), [IntelliJ IDEA](https://www.jetbrains.com/idea/), ou qualquer outro de sua escolha)
- [Git](https://git-scm.com/) para clonar o repositório (opcional)

## Como Executar

### 1. Clonar o Repositório

Se você tiver Git instalado, abra o terminal e execute o comando:

> git clone https://github.com/dbcfilho/folder-creator.git

### 2. Compilar o Projeto
Se estiver usando o terminal, navegue até o diretório onde o projeto foi clonado e execute os seguintes comandos para compilar:

> javac CriadorDePastas.java GerenciadorDePastas.java

### 3. Executar o Programa
Depois da compilação bem-sucedida, execute o seguinte comando para iniciar a aplicação:

> java CriadorDePastas

### 4. Usar a Aplicação
- Ao abrir a aplicação, você verá uma janela pedindo para inserir o nome da pasta e escolher o diretório onde a pasta será criada.
- Clique no botão "Escolher Caminho" para selecionar o diretório desejado.
- Digite o nome da pasta e clique em "Criar Pasta".
- Uma mensagem de status será exibida, indicando o sucesso ou erro durante a criação da pasta.

### 5. Estrutura do Projeto
- CriadorDePastas.java: Contém a interface gráfica da aplicação e interage com o usuário.
- GerenciadorDePastas.java: Contém a lógica para a criação de pastas e a verificação de erros.
