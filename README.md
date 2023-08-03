# Projeto Frankenstein
<div align="center">
<p float="left">
 <img src="https://github.com/ifeslopes/projeto_frankenstein/blob/main/img.png" width="400" />
</p>
 </div>

O projeto Frankenstein é um crud simples, repositório destinado a fins didáticos, criado durante o meu estágio, onde busco aplicar o conhecimento adquirido ao longo desse período de aprendizado.

## Objetivo

O objetivo principal deste projeto é proporcionar uma oportunidade de praticar e aplicar os conceitos e técnicas estudados durante o estágio. Aqui, é possível explorar diversas temáticas, incluindo os seguintes tópicos que já foram aprendidos:
1. Utilização e configuração do application.properties.
2. Utilização do Maven gerenciador de build e dependências. 
3. Utilização de DTO (Data Transfer Object) para melhorar a comunicação entre as camadas da aplicação.
4. Uso do JPA (Java Persistence API) para facilitar o mapeamento objeto-relacional.
5. Implementação de Specification para criar consultas avançadas e dinâmicas no banco de dados.
6. Tratamento de exceções, garantindo uma resposta adequada e tratada para possíveis erros na aplicação.
7. Utilização do banco de dados H2 para fins de desenvolvimento e testes.
8. Implementação do Spring Security com JWT (JSON Web Tokens) para garantir a segurança da aplicação.
9. Realização de testes integrados para verificar a interação correta entre os componentes da aplicação.
10. Execução de testes unitários para assegurar o funcionamento correto de cada unidade de código.

## Estado do projeto

É importante mencionar que o projeto se encontra em estágio inicial e, por esse motivo, a maior parte dos códigos e a arquitetura podem estar desorganizados, sem tratamentos, correções ou simplificações. O propósito é focar na prática e no aprendizado, mesmo que isso signifique não seguir completamente os padrões de código limpo ou arquitetura sólida.


## Aviso

Lembre-se de que este é um projeto voltado para aprendizado e prática. Nem todos os aspectos seguirão os padrões tradicionais de código ou arquitetura. O objetivo principal é proporcionar uma oportunidade de desenvolvimento e aprimoramento de habilidades.

## Arquitetura de pasta
```
src
├── main
│   ├── java
│   │   └── com
│   │       └── home
│   │           └── crudPessoa
│   │               ├── CrudPessoaApplication.java
│   │               ├── config
│   │               │   ├── SecurityConfig.java
│   │               │   └── TestConfig.java
│   │               ├── controller
│   │               │   ├── PessoaController.java
│   │               │   └── handler
│   │               │       ├── ApiExceptonHandler.java
│   │               │       └── ErrorResponse.java
│   │               ├── dto
│   │               │   ├── CredenciaisDTO.java
│   │               │   ├── PessoaResponseDTO.java
│   │               │   └── PessoaResquestDTO.java
│   │               ├── entities
│   │               │   ├── Pessoa.java
│   │               │   ├── PessoaRepository.java
│   │               │   └── PessoaTeste.java
│   │               ├── enums
│   │               │   └── Perfil.java
│   │               ├── exception
│   │               │   └── DadosInvalidosEception.java
│   │               ├── mapper
│   │               │   └── PessoaMapper.java
│   │               ├── repositories
│   │               │   ├── PessoaRepositorie.java
│   │               │   ├── PessoaTesteRepository.java
│   │               │   └── spec
│   │               │       └── PessoaSpec.java
│   │               ├── security
│   │               │   ├── JWTAuthenticationFilter.java
│   │               │   ├── JWTAuthorizationFilter.java
│   │               │   ├── JWTUtil.java
│   │               │   └── UserSS.java
│   │               └── services
│   │                   ├── Pessoa2Service.java
│   │                   ├── PessoaService.java
│   │                   ├── PessoaServiceTeste.java
│   │                   └── UserDetailsServiceImpl.java
│   └── resources
│       ├── application-dev.properties
│       ├── application-test.properties
│       ├── application.properties
│       ├── static
│       └── templates
└── test
    └── java
        ├── com
        │   ├── example
        │   └── home
        │       └── crudPessoa
        │           ├── CrudPessoaApplicationTests.java
        │           ├── CrudPessoaApplicationTests.java:Zone.Identifier
        │           ├── PessoaServiceTest.java
        │           ├── PessoaTest.java
        │           ├── PessoaTestIntegriodadeIT.java
        │           ├── PessoaTesteIntegridadeMockitoIT.java
        │           ├── services
        │           │   └── PessoaServiceTesteTest.java
        │           ├── testUnutario
        │           │   └── StubPessoa.java
        │           └── testeIntegridade
        │               └── TestPessoaRepository.java
        └── resources
            └── application-testInte.properties

```
