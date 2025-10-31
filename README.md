# FerreiraLearn 📑

### Uma Plataforma Acadêmica Eficiente Desenvolvida em Java

A FerreiraLearn é um projeto acadêmico criado para estudos, cujo propósito principal era simples. Se utilizar uma conexão com banco de dados e construção seguindo a arquitetura MVC. O nosso grupo aperfeiçoou e melhorou a base do projeto, polindo e aprofundando-se no tema com as nossas diversas ideias tidas durante a criação do trabalho. Ideias essas que garantiram beleza e conforto ao site.

## Visão do Projeto

A idealização do projeto FerreiraLearn se relacionou fortemente com o conhecimento e experiências sobre banco de dados e as suas tecnologias, para produzir algo que é educativo e, ao mesmo tempo, útil para os usuários. Este trabalho de forma prática apresenta aplicações da Programação Orientada a Objetos e os seus princípios fundamentais, oferecendo organização, praticidade, desenvolvimento profundo e afins. É oferecido aos usuários uma experiência educativa capaz de realmente ensinar com os seus ótimos conteúdos fornecidos por um profissional, com um formato extremamente intuitivo, coerente e agradável. Para a equipe de desenvolvimento, o projeto foi originado de uma junção criativa de ideias e habilidades competentes na área, trabalhado em um prazo de entrega definido, onde futuramente pode dar mais espaço para atualizações que poderão adicionar novas funcionalidades e favorecer o núcleo do projeto que já é bastante polido, dando novos horizontes a FerreiraLearn.

## Screenshots

*Tela de início da plataforma*

    <imagem aqui>

*Testando login e plafaforma*

    <video aqui>

## Principais Funcionalidades

* ✅ **Autenticação Segura (Spring Security):** Sistema completo de Registro e Login. As senhas são criptografadas (BCrypt) e o acesso às rotas (`/`, `/course/...`) é protegido, com redirecionamento automático para usuários não autenticados.
* ✅ **Dashboard de Aluno:** Após o login, o usuário é direcionado para um dashboard (`/`) que lista os cursos disponíveis e exibe uma seção de "Instrutor" (simulando a Udemy).
* ✅ **Player de Curso Interativo:** Interface de duas colunas (`/course/...`) com o player de vídeo (YouTube Embed) e uma sidebar que lista todos os módulos e aulas do curso.
* ✅ **Sistema de Progresso Real:** O projeto vai além de apenas assistir. Inclui um botão "Marcar como Concluída" que salva o progresso do usuário no banco (MySQL) e atualiza dinamicamente a **Barra de Progresso** do curso, calculando a porcentagem real de conclusão.
* ✅ **Arquitetura MVC em Camadas:** O código é escalável, seguindo o padrão Model-View-Controller com camadas de Serviço (`service`) e Repositório (`repository`), permitindo que novas funcionalidades (como uma "Área do Professor") sejam adicionadas facilmente.

## Tecnologias Utilizadas

Este produto foi construído utilizando as seguintes tecnologias:

* **Back-end:**
    * Java (JDK 17)
    * Spring Boot (Framework principal)
    * Spring Security (Autenticação, Criptografia BCrypt, CSRF)
    * Spring Data JPA (Comunicação com o banco)
* **Front-end:**
    * Thymeleaf (Renderização das páginas no servidor)
    * HTML5 e CSS3
* **Banco de Dados:**
    * MySQL
* **Streaming de Vídeo:**
    * YouTube IFrame Player API (Embed)
* **IDE de Desenvolvimento:**
    * IntelliJ IDEA

## Como Executar o Projeto

Para executar a plataforma "FerreiraLearn" localmente, siga os passos abaixo. Este projeto usa **Spring Boot**, **Maven** e **MySQL**.

### 1\. Pré-requisitos

* **Java (JDK):** Versão 17 ou superior instalada.
* **MySQL:** Um servidor MySQL rodando localmente (na porta padrão `3306`).
* **Git:** Para clonar o repositório.

### 2\. Clone o Repositório

```bash
git clone https://github.com/AndreyCadmo/FerreiraLearn.git
cd FerreiraLearn
```

### 3\. Configure o Banco de Dados

1.  **Crie o Banco:** Abra seu cliente MySQL e crie um novo banco de dados (schema).
    ```sql
    CREATE DATABASE ferreiralearn;
    ```
2.  **Configure as Credenciais:**
    * Na pasta `src/main/resources/`, renomeie o arquivo `application.properties.example` para `application.properties`.
    * Abra o `application.properties` e preencha suas credenciais do MySQL (seu `username` e sua `password`).
    <!-- end list -->
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/ferreiralearn
    spring.datasource.username=root
    spring.datasource.password=SUA_SENHA_AQUI
    ```

### 4\. Crie as Tabelas (Primeira Execução)

O projeto usa **JPA/Hibernate** para gerenciar o banco. Para criar todas as tabelas (`users`, `courses`, `lesson_completions`, etc.) automaticamente na primeira vez que você rodar:

1.  No arquivo `application.properties`, mude temporariamente esta linha:
    * **Mude de:** `spring.jpa.hibernate.ddl-auto=validate`
    * **Para:** `spring.jpa.hibernate.ddl-auto=create`

### 5\. Execute o Projeto

Você pode rodar a aplicação de duas maneiras:

* **Pela sua IDE (Recomendado):**

    1.  Abra o projeto no IntelliJ.
    2.  Espere o Maven baixar todas as dependências (pode levar um minuto).
    3.  Encontre o arquivo `PlataformaDeCursoApplication.java` (em `src/main/java/...`).
    4.  Clique no botão "Run" (play) verde ao lado do nome da classe.

* **Pelo Terminal (Usando o Maven Wrapper):**

  ```bash
  # No Windows
  mvnw.cmd spring-boot:run

  # No Linux ou macOS
  ./mvnw spring-boot:run
  ```

### 6\. Pós-Execução

1.  **Popule o Banco:** Após o servidor rodar pela primeira vez (e criar as tabelas), você precisa **parar** o servidor e **inserir manualmente** os dados de pelo menos 1 curso, 1 módulo e 1 aula no seu banco MySQL. Sem isso, a plataforma abrirá, mas estará vazia.
2.  **Ajuste o `ddl-auto`:** Mude a linha no `application.properties` de volta para `spring.jpa.hibernate.ddl-auto=validate`. (Isso impede que o Spring apague seu banco toda vez que você reiniciar o app).
3.  **Acesse:** Reinicie o servidor e acesse `http://localhost:8080` no seu navegador.

## A Origem

Utilizando as orientações dadas pelo nosso professor na matéria Programação Orientada a Objetos, realizamos com êxito um site com base em conexão com banco de dados e a sua construção seguida a arquitetura MVC. Inicialmente, procuramos agir de forma ambiciosa, porém não tão trabalhosa, pois o prazo de entrega poderia acarretar em problemas durante a produção e execução do site como produto final. No início não se havia ainda uma base definida, mas graças ao professor, e algumas pequenas pesquisas, fomos capazes de achar o rumo perfeito para unificar a nossa criatividade e, ao mesmo tempo se desafiar no processo, dando-nos uma janela de oportunidades para desempenhar no trabalho. Com essa experiência, aprendemos que a perspectiva e o modo de pensar fora da caixa podem fazer a diferença, e mesmo numa situação de pressão, podemos ser capazes de nos virarmos utilizando as ferramentas que temos em mãos, dessa maneira, a nossa paixão e determinação se tornam imbatíveis. No fim, a consequência do nosso esforço foi a FerreiraLearn, sendo a oportunidade que agarramos e deixando-nos satisfeitos.

## Agradecimentos
* Um agradecimento especial ao professor **Paulo**, por nos conceder a liberdade criativa para transformar um requisito acadêmico em um projeto que nos orgulhamos de apresentar.

## Contribuintes
Este projeto foi idealizado e desenvolvido por uma equipe dedicada de estudantes.

* Andrey Cadmo Marques de Oliveira
* Luiz Henrique Ribeiro
* Nicolas Jeffery

## Licença

Este projeto está sob a licença MIT.
