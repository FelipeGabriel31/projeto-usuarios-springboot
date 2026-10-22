# Projeto Usuarios - Spring Boot, H2 e JPA (Versao para publicacao online)

Projeto Java Maven destinado ao Eclipse Enterprise, com endpoint `/usuarios` acessivel por URL publica quando hospedado no Render.

## Requisitos da atividade (16/10/2026)

- Java 17 e Spring Boot 3.5.16.
- Persistencia H2 via Spring Data JPA.
- `model/Usuario.java` e uma entidade JPA com `id`, `nome`, `sobrenome` e `cpf`.
- `configuration/UsuarioConfiguration.java` insere cinco usuarios ficticios no H2 quando a aplicacao inicia.
- `GET /usuarios` retorna todos os usuarios, em JSON.
- O projeto esta em ZIP, pronto para entregar e abrir no Eclipse.

## Importar no Eclipse Enterprise

1. Extraia `ProjetoUsuariosSpringBoot_Online.zip`.
2. No Eclipse: File > Import > Maven > Existing Maven Projects.
3. Selecione a pasta `ProjetoUsuariosSpringBoot_Online` que contem `pom.xml`.
4. Importe e aguarde a resolucao das dependencias.
5. Execute `UsuariosApplication.java` como Java Application ou Spring Boot App.

A execucao no Eclipse e um teste local. O endereco publico so existira quando a aplicacao for publicada em uma hospedagem.

## Publicar na internet (Render + GitHub)

1. Crie um repositorio no GitHub (github.com/new), publico ou privado.
2. Extraia o ZIP e envie **o conteudo interno da pasta do projeto** para a raiz do repositorio; `pom.xml`, `Dockerfile` e `render.yaml` precisam estar no mesmo nivel (na raiz). Em GitHub use **Add file > Upload files**. Envie tambem a pasta `src` completa. Nao envie o arquivo ZIP fechado como unico item do repositorio.
3. Acesse https://dashboard.render.com, conecte a conta GitHub (pode precisar autorizar o acesso ao repositorio).
4. Escolha **New > Blueprint**, selecione o repositorio que contem `render.yaml`.
5. Confira o servico web `usuarios-springboot-trabalho`, com **Free** como plano, e confirme a implantacao (Deploy/Apply).
6. Aguarde o estado **Live**. Copie a URL publica que o Render exibir. O seu endpoint sera essa URL com `/usuarios` ao final, por exemplo `https://<seu-subdominio>.onrender.com/usuarios`.
7. Abra o endereco publico pelo celular usando a internet movel para conferir se mostra a lista JSON com cinco usuarios.

**Atenção:** a URL do exemplo acima nao existe ate a publicacao e o subdominio real depende do nome atribuido pelo Render. Uma conta e a publicacao no servico externo sao necessarias; criar ou executar o ZIP por si so nao coloca o projeto na internet.

## Exemplo de resposta GET /usuarios

```json
[
  {"id":1,"nome":"Ana","sobrenome":"Souza","cpf":"00000000001"},
  {"id":2,"nome":"Bruno","sobrenome":"Lima","cpf":"00000000002"},
  {"id":3,"nome":"Carla","sobrenome":"Oliveira","cpf":"00000000003"},
  {"id":4,"nome":"Daniel","sobrenome":"Santos","cpf":"00000000004"},
  {"id":5,"nome":"Eduarda","sobrenome":"Costa","cpf":"00000000005"}
]
```

Os CPFs sao apenas dados ficticios de exemplo.

## Diferenca da versao anterior

- `application.properties` inclui `server.address=0.0.0.0` e `server.port=${PORT:8080}` para aceitar a porta de hospedagem.
- Console H2 desligado para nao expor a interface de administracao na internet.
- `Dockerfile` e `.dockerignore` para o ambiente de execucao externo.
- `render.yaml` configura um Web Service com plano Free e verificacao do endpoint `/usuarios`.

## Consideracoes

- O banco H2 e **em memoria**, portanto os registros sao reinicializados a cada reinicio. Os cinco usuarios sao recriados automaticamente pelo componente `UsuarioConfiguration`, o que atende ao trabalho.
- A Render pode colocar instancias gratuitas em repouso apos 15 minutos sem trafego; o primeiro acesso apos o repouso pode demorar a responder.
- Nunca publique CPFs reais, senhas ou outros dados pessoais nessa demonstracao.
- Caso use apenas Eclipse localmente, voce ainda precisara de hospedagem para obter URL publica acessivel por outras redes.
- Para executar testes: `mvn test` em um ambiente com Maven.
