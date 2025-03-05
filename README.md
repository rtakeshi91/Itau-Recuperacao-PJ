**Itau-Recuperacao-PJ**
**Case Itau - Recuperação PJ - ENGENHARIA TI SR**

**PASSO 1 -Desenvolvimento da solução**
Você deverá desenhar e desenvolver, em poucos dias, uma solução que atenda aos requisitos dados.
Faz parte da problemática, entender o desafio proposto e elaborar um desenho de solução que o resolva.

**PASSO 2 -Apresentação da Solução**
Você será convidado a nos apresentar sua solução e realizar uma demonstração dela. Para nós, é mais importante
entender como você chegou a esta solução, do que o resultado do exercício em si (existem inúmeras soluções
corretas), então queremos entender qual foi a solução escolhida por você.
Caso tenha alguma dúvida ao ler este desafio, esteja à vontade para nos perguntar!

**Cenário**
Em um cenário que você é um engenheiro de sistemas que será encarregado por liderar uma iniciativa de
modernização de todo um legado dos sistemas de recuperação de crédito (cobrança e renegociação) (legado de 10-
20 anos).
As principais funções que temos hoje no sistema são: ações que cobram o cliente e funcionalidades para renegociar
as dívidas e facilitar os pagamentos e que praticamente rodam, em sua totalidade, no ambiente mainframe (COBOL,
Assembler, DB2, VSAM). O seu desafio será buscar recortes (desacoplar funcionalidades) e desenhar uma proposta
de solução técnica (apresente peças técnicas e o papel de cada uma delas) de forma que resolva a necessidade de
negócio.
A plataforma atual é um sistema monolítico, com alto acoplamento e processamento batch que provê as informações
dos canais on-line do banco.
A ideia da plataforma que buscamos é ser o mais on-line possível, tendo em vista que a evolução e lançamento de
produtos é constante nesse mercado e o comportamento do consumidor é sazonal.

**Informações importantes**
1. Caso não tenha conhecimento das funcionalidades crie algumas premissas para realizar o seu exercício e explicite
em seu desenho.
2. Modernização do legado significa aplicar tecnologias novas e emergentes que simplifiquem e acelerem as soluções
técnicas, valorizando o desacoplamento das funcionalidades com a criação de peças simples, performáticas e que
tenham reuso.
3. Fazer uma apresentação livre, minimamente contendo:
Relatório Técnico explicando de forma sumarizada, considerando:
I. Diagrama de arquitetura
II. Publique os códigos gerados (em Java), em seu perfil do https://github.com/
▪ Cite no relatório: O seu perfil github e a(s) URL(s) onde se encontram os códigos gerados
III. Referências utilizadas, se aplicável.
IV. Demais itens que você julgar relevante (framework ou técnicas de teste, metodologias, padrões etc.)

**Requisitos:**
• Modernizar legado dos sistemas de Cobrança e Renegociação.
• Aplicar tecnologias novas e emergentes;
• Simplificar as soluções técnicas;
• Acelerar as soluções técnicas;
• Desacoplamento das funcionalidades;
• Peças simples;
• Peças performáticas;
• Peças que tenham reuso;
• Codifique uma funcionalidade;

**Funcionalidades:**
• Ações de cobrança ao cliente (carta, SMS, e-mail, outros possíveis);
• Negativação junto aos birôs de crédito (Serasa, SPC, BVS, outros possíveis);
• Funcionalidades de renegociação (agrupamento da dívida e simulação de pagamento, oferta de produtos,
efetivação acordo, entre outros);
• Funcionalidades de pagamento (emissão e pagamento de boletos, débito em conta, entre outros).


**SOLUÇÃO**
**Resumo:** Realizei o desenvolvimento em padrão hexagonal, construindo as controladoras para interagir com o Front-End assim como deixei a aplicação pronta para execução de rotinas cron como envio de Cobrança. Todo o código fonte está sem regra de negócio, somente a navegação dentre as camadas da aplicação, as regras de negócio podem ser acrescentadas posteriormente e as tecnologias envolvidas também podem ser substituídas. O código-fonte foi construído com auxílio de IA para reduzir o tempo de desenvolvimento e para solucionar alguns problemas com dependências. A aplicação também está pré-configurada para ser hospedada em cluster EKS.Construí a aplicação com a premissa de que as entidades necessárias para a aplicação estariam sendo replicadas via RTL da base legado para a base da aplicação ou que a base legado seria completamente migrada para a nova base de dados.

**Testes:** Não pude implementar testes de forma mais abrangente, mas já temos os testes unitários de todas as adapters existentes no projeto, em questão de continuidade e futuro da aplicação/produto, seguiria a seguinte estratégia:
Amadurecendo os requisitos técnicos da aplicação, construiria os testes de integração;
Conhecendo mais profundamente as regras de negócio, construiria os testes de aceitação;
Com a aplicação já em ambiente de testes, iniciaria a construção dos teste de comportamento, performance e mocking para já começar a prever problemas em ambiente Produtivo;
Após a aplicação estar em ambiente produtivo, mapear todas as eventuais exceções e ocorrências e construir testes específicos para os cenários encontrados;

**Autenticação:** Também desenvolvi uma controladora não-autenticada com um método para gerar um token JWT mediante login/senha informado no frontEnd. O Token ao ser recuperado pelo cliente deve ser fornecido no header dos outros métodos das outras controladoras.

**Padrões de desenvolvimento aplicados na solução:**
Adapter Pattern;
Facade Pattern;
Service Layer Pattern;
Dependency Injection Pattern;
Use Case Pattern;
Command Pattern;
Data Transfer Object (DTO);
Repository Pattern;
Entity Pattern;

**Tecnologias utilizadas no desenvolvimento:**
Java 21;
Gradle 7.6;
H2 Database;
Springboot 3.x;
Swagger;
JUnit e Mockito;
JWT;
SLF4J e Logback;
Micrometer + Prometheus;
Spring Cloud Sleuth + OpenTelemetry;
Grafana/Kibana;
Amazon EKS/ECR/SQS (todos pré-configurados, não criei clusters nem filas para realizar a parametrização na aplicação);
