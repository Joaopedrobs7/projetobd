# Backend do Projeto

## Pré-requisitos

- Java **inferior à versão 24** (por compatibilidade com o Lombok)
- MySQL Server 
- Intelij/Eclipse

## Passos para execução

1. **Baixe e importe o banco de dados**:  
   [Dump SQL do projeto](https://drive.google.com/file/d/1nUjk2Yo1l-IX2_09CaQ3Ambx8SPHtjWc/view?usp=sharing)

2. **Configure o arquivo `application.properties`** com a senha do seu MySQL:

   ```properties
   spring.datasource.username=root
   spring.datasource.password=SUA_SENHA_AQUI
   ```

3. **Rode o backend** iniciando o `ProjetobdApplication`:

   ![image](https://github.com/user-attachments/assets/548c48d5-5172-4cf0-8e5a-a22591b0c5d8)

   O backend estará disponível em: [http://localhost:8080](http://localhost:8080)


4. **Teste com nosso front :) (ou teste via postman)** : [Front End](https://github.com/Joaopedrobs7/bd-front)
