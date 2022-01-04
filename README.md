# Estudo API - Projeto Tema Livre - Jogos / Plataformas / Generos

A API aqui apresentada serve para demonstrar os conhecimentos obtidos durante o curso de API.

A API de tema livre aqui exposta se baseia na relação de três entidades :

- Jogos
- Plataformas
- Generos

Sendo a entidade Principal Jogos que possui um gênero e tem a possibilidade de possuir multiplas plataformas relacionadas a um determinado Jogo.

## Como Utilizar

``` 
Faça o clone do repositório
Abra o projeto em sua IDE de preferencia e rode o projeto. 
Após a build estar completa, abra seu navegador e vá para a seguinte URL: http://localhost:8080/
Você será redirecionado para o Swagger onde poderá testar a API direto no navegador. 
Para liberar o uso das funcionalidades você deverá realizar uma autenticação no método POST autenticacao-controller, digite uma das seguintes contas cadastradas e clique em 'try it out':

login: admin@gmail.com password: 1234 (Terá autorização como **ADMIN**)
login: usuario@gft.com password: 1234 (Terá autorização como USUARIO, podendo apenas utilizar métodos **GET**)

O método irá retornar um token, copie o conteúdo sem as aspas "" e clique no botão 'Authorize' na parte direita superior da página do swagger. 

No campo value coloque a palavra 'Bearer ' + token, e clique em authorize. 
Agora todos os métodos serão liberados de acordo com a autorização do usuario que solicitou o token.
```

## Metodos REST

Caso queira utilizar uma ferramenta própria como o Postman também é possível. Com o projeto rodando abra o Postman e solicite o token de utilização fazendo um POST no caminho http://localhost:8080/v1/auth e passando no body um dos logins mencionados acima. Será então retornado um token de utilização para ser colocado na aba 'Authorization'.

Métodos disponíveis:

- Generos
  - http://localhost:8080/v1/generos (POST / GET)
  - http://localhost:8080/v1/generos/{id} (GET / PUT / DELETE)
- Plataformas
  - http://localhost:8080/v1/plataformas (POST / GET)
  - http://localhost:8080/v1/plataformas/{id} (GET/PUT/DELETE)
- Jogos
  - http://localhost:8080/v1/jogos (POST/GET)
  - http://localhost:8080/v1/jogos/{id} (GET/PUT/DELETE)

