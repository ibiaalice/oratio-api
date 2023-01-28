# 👩‍💻 Oratio 
## Introdução 
 Olá, este repositório possui o projeto back-end do Oratio. Mas o que é o **Oratio**? 
 Oratio é o projeto de organização de avaliações de projetos de conclusões de curso para o Curso de Ciência da Computação da Universidade Federal de Campina Grande. Atualmente este projeto está em fase de **MVP** (versão mínima do produto). Sendo apenas um projeto em desenvolvimento. 
 
## Como inicializar o projeto? 

Para inicializar o projeto, é necessário algumas especificações. É necessário ter em sua máquina o **Java SDK 11**.

Inicialmente, clone o repositório.
``` bash
git clone https://github.com/ibiaalice/oratio-api
```

Após clonado o projeto, entre na pasta **oratio** e instale as dependências do website.
``` bash
cd oratio-api
```
para compilar o arquivo .jar 
```java
mvn package
```

para executar o arquivo do projeto 
```java
java -jar oratio-api.jar
```

caso você precise executar sem o empacotamento, utilize o seguinte comando
```java 
mvn spring-boot:run
```

pronto, você pode utilizar as rotas  em **localhost:8080/** ou o endereço que você configurar. 
