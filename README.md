# EvertecTest



## PRÉ-REQUISITOS

Requisitos de software e hardware necessários para executar este projeto de automação

* Java 17 JDK
* Gradle 8.2
* Intellij IDE
* Plugins do Intellij
    * Lombok

## DOWNLOAD DO PROJETO PARA SUA MÁQUINA LOCAL
```
git clone https://gitlab.com/javasicred/EvertecTest.git
```

## COMANDO PARA EXECUTAR OS TESTES

Com o prompt de comando acesse a pasta do projeto, onde esta localizado o arquivo build.gradle.kts, execute o comando
abaixo para rodar os testes automatizados.

```
./gradlew clean test 
```

## FRAMEWORKS UTILIZADOS

Abaixo está a lista de frameworks utilizados nesse projeto

* Java Faker - Responsável pela geracao de dados sintéticos
* Rest-Assured - Responsável pelos validações de teste de API
* Selenium 4 - Responsável pelos validações de teste Web

## ESTRUTURA DO PROJETO

| Diretório                             | finalidade                               | 
|---------------------------------------|------------------------------------------|
| src\main\java\com\EvertecTest\config  | Classe de configuração de ambiente       |
| src\main\java\com\EvertecTest\core    | Classe de configuração do Selenium       |
| src\main\java\com\EvertecTest\support | Classe de configuração do BrowserFactory |
| src\test\java\com\EvertecTest\feature | Classe de testes                         |
| src\test\java\com\EvertecTest\page    | Classe de Classe de suporte PageObject   |
| report\allureReport                   | Report de execução dos testes            |

## Plano de Teste e Estratégia de Testes para API
* ### Objetivo do Teste:
  * O objetivo deste teste é garantir que a API funcione corretamente, atendendo aos requisitos de funcionalidade, desempenho e segurança.
  
  * O objetivo deste teste WEB é garantir que a consulta realizada no blog retorne conforme esperado

* ### Escopo do Teste:
  O teste abrangerá as principais funcionalidades da API, incluindo:

  * Consulta de dados por raças gerais.
  * Consulta de imagens por raça definida.
  * Consulta de Imagens aleatórias por raça definida

  O teste abrangerá as principais funcionalidades da Pagina Web, incluindo:

  * Consulta de assunto específico.
  * Consulta sem assunto

* ### Ambiente de Teste:
  * Será testada nos seguintes ambientes:
    * Ambiente de teste produção.

* ### Estratégia de Teste:

  * Testes de Integração:

    * Testaremos a interação entre diferentes partes.
    Verificaremos se os componentes se comunicam corretamente e se as funcionalidades são integradas sem problemas.
  
  * Testes de Funcionalidade:

    * Testaremos os principais casos de uso como consulta.
      Verificaremos se as operações funcionam conforme esperado e se os dados são consistentes.

  * Testes de Exceção:

    * Verificaremos como as aplicações lidam com situações excepcionais, como entradas inválidas ou erros internos.
      Garantiremos que as mensagens de erro sejam claras e úteis para os desenvolvedores.

* ### Critérios de Saída:
  * Todos os casos de teste foram executados.
  * A taxa de sucesso dos testes é superior a 90%.
  * As principais funcionalidades estão funcionando conforme especificado.
  * As vulnerabilidades críticas foram documentadas.

* ### Recursos Necessários:
  * Acesso à documentação da API.
  * Acesso à Pagina Agibank.
  * Ferramentas de teste, como JUnit, Postman, JMeter, etc.
  * Equipe de teste qualificada.



## LINKS DE APOIO

* [JSON para Classe Java](https://www.site24x7.com/pt/tools/json-para-java.html)

```
 Report HTML: build\reports\tests\test\index.html
```