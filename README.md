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
* Rest-Assured - Responsável pelos validações de teste

## ESTRUTURA DO PROJETO

| Diretório                            | finalidade                         | 
|--------------------------------------|------------------------------------|
| src\main\java\com\EvertecTest\config  | Classe de configuração de ambiente |
| src\test\java\com\EvertecTest\feature | Classe de testes                   |
| report\allureReport                  | Report de execução dos testes      |

## Plano de Teste e Estratégia de Testes para API
* ### Objetivo do Teste:
    O objetivo deste teste é garantir que a API funcione corretamente, atendendo aos requisitos de funcionalidade, desempenho e segurança.

* ### Escopo do Teste:
  O teste abrangerá as principais funcionalidades da API, incluindo:

  * Autenticação e autorização.
  * Requisições e respostas dos endpoints.
  * Manipulação correta de dados.
  * Tratamento adequado de erros.

* ### Ambiente de Teste:
  * A API será testada nos seguintes ambientes:
    * Ambiente de teste produção.

* ### Estratégia de Teste:

  * Testes de Integração:

    * Testaremos a interação entre diferentes partes da API.
    Verificaremos se os componentes se comunicam corretamente e se as funcionalidades são integradas sem problemas.
  
  * Testes de Funcionalidade:

    * Testaremos os principais casos de uso da API, como criar, ler, e atualizar recursos.
      Verificaremos se as operações funcionam conforme esperado e se os dados são consistentes.

  * Testes de Exceção:

    * Verificaremos como a API lida com situações excepcionais, como entradas inválidas ou erros internos.
      Garantiremos que as mensagens de erro sejam claras e úteis para os desenvolvedores.

* ### Critérios de Saída:
  * Todos os casos de teste foram executados.
  * A taxa de sucesso dos testes é superior a 90%.
  * As principais funcionalidades estão funcionando conforme especificado.
  * As vulnerabilidades críticas foram documentadas.

* ### Recursos Necessários:
  * Acesso à documentação da API.
  * Ferramentas de teste, como JUnit, Postman, JMeter, etc.
  * Equipe de teste qualificada.

## Bugs identificados
```
  Bug_01 - Durante a Execução dos testes ao realizar a validação no cenário "obtendoTokenDeUsuarioNaApiAuthLogin200" o codigo de retorno esperado é o 201,
  porém está retornando 200, devengente do informado na documentação. 
  
  Bug_02 - Durante a Execução dos testes ao realizar a validação no cenário "CriandoProdutoApiAuthProducts200" o codigo de retorno esperado é o 201,
  porém está retornando 200, devengente do informado na documentação. 
  
  Bug_03 - Durante a Execução dos testes ao realizar a validação no cenário "CriandoProdutoDuplicadoApiAuthProducts" o codigo de retorno esperado é o 400,
  porém está retornando 200, pois se trata de uma inserção duplicada de item.
  
  Bug_04 - Durante a Execução dos testes ao realizar a validação no cenário "ConsultaApiAuthProductsPorIdInvalido" o codigo de retorno esperado é o 404,
  porém está retornando 200, pois se trata de uma consulta de item inválido.
  
  Bug_05 - Durante a Execução dos testes ao realizar a validação no cenário "ConsultaApiAuthProductsSemToken403" o codigo de retorno esperado é o 403,
  porém está retornando 401, pois se trata de uma consulta de produtos sem a permissão necessária..
```

## Melhorias identificado
```
  01 - Melhoria na documentação referente a codigo e mensagens de retorno, pois há metodos que contemplam apenas o fluxo principal.
  02 - Mapear no documento fluxos alternativos das rotas dos end-points, informando parametros como limit e offset e ids.
  03 - Incluir validação de metodo, pois end-points que são gets quando alterados para outro tipo retornam 301 quando deveria retornar 405
```

## LINKS DE APOIO

* [JSON para Classe Java](https://www.site24x7.com/pt/tools/json-para-java.html)

```
 Report HTML: build\reports\tests\test\index.html
```