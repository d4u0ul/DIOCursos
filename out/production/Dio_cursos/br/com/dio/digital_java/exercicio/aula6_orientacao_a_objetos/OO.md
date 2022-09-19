# Orientação à objetos

## INTRODUÇÃO
PE VS POO

O Paradigma Estruturado tem uma representação mais simplista ou mais limitada, já a orientada a objetos tem representações mais realistas, se aproximando muito mais da realidade.

O PE foca em operações(funções) e dados ou seja como fazer, já o POO foca na modelagem de entidades e nas interações entre estas, ou seja o que fazer.

Quanto mais alto nível a programação se torna mais fácil o que facilita na construção do código.

**Vantagens da POO**

- Melhor Coesão - Conceito inerente a programação de todos os tipos, assim como uma redação todas as ideias devem trabalhar em conjunto, logo as unidades de código devem ter responsabilidades bem definidas.
- Melhor Acomplamento - Conceito da programação como um todo - a POO permite que se faça da melhor forma possível 
- Diminuição do Gap Semtântico - è uma diferença de uma representação mundoRealXmundoComputacional - devidos às limitações as PE tem um gap muito maior 
- Coletor de lixo - GarbageCollector - A medida que vamos programando e o sistema vai trabalhando as linguagens de POO tem mecanismos que vão limpando a memória com dados que não se utilizarão mais na execução. No PE, o próprio programador que tem de ficar analisando constantemente se a memória está perto de esgotar para liberar mais memória.

Em resumo:

![img.png](img.png)

Os objetos são entidades do mundo real que se relacionam, de acordo com a forma na qual as estruturas se interligam.

## FUNDAMENTOS

O que é OO?

A orientação a objetos é um paradigma de análise, projeto e programação de sistemas de software baseado na composição e interação entre diversas unidades de software chamadas objetos.

Para programar em OO, devemos dominar alguns pilares dentre eles:

- **ABSTRAÇÃO** - Processo pelo qual se isolam características de um objeto considerando os que tenham em comum certos grupos de objetos

Por exemplo, para cadeiras podemos pensar em 3 coisas

pernas, assento e encosto 

Várias cadeiras podem ter esses parâmetros como cadeiras de praia, de aula, de cozinha, mas se pensarmos em um braço nem todas cadeiras têm, por exemplo a de praia e a de aula talvez tenham , mas a de cozinha muito provavelmente não terá.

- **REUSO** - É a capacidade de criar novas unidades de código a partir de outras já existentes

Por exemplo, como vemos acima o reuso dos parâmetros da definição de uma cadeira. Na POO, há várias maneiras além da abastração de se garantir o reuso.

- **ENCAPSULAMENTO** - Capacidade de esconder complexidades e proteger dados 

Evitar o acesso de maneira indevida a determinadas partes do código de maneira muito facilitada.

Para garantir o uso destes 3 pilares, muitos outros conceitos virão, mas com estes 3 conceitos básicos já resumem o necessário para usar em qlq linguagem de programação.

### Exercício- Levando em consideração uma loja online de livros, modele uma entidade livro.

1) Separando as características:

![img_1.png](img_1.png)

Temos muitas e cada uma delas nos ajuda a definir qual livro estamos tratando. Porém, são muitos detalhes, devemos então diminuir para deixar caracterísitcas mais gerais que possam ser realmente utilizados numa aplicação de loja online.

2) Diminuindo as caracterísitcas 

![img_2.png](img_2.png)

Tiramos detalhes como gramatura, cor do papel, quem quer comprar um livro normalmente não busca essas caracterísiticas.

Mas, se pensarmos no lado , por exemplo da editora caracterísitcas como essas(gramatura, peso e colcoaração do papel) são muito importantes então as caracterísitcas deveriam ser diminuidas para:

![img_3.png](img_3.png)

Então, a necessidade da modelagem que está sendo feita influencia diretamente nos atributos que precisamos definir para modelar a entidade.

3) Finalizando a proposta

![img_4.png](img_4.png)

Em resumo, podemos deixar desse jeito. Quando vamos programar um SW devemos nos preocupar com as necessidades que temos hj, se pensarmos muito no futuro desenvolveremos coisas que talvez nem usemos. Em resumo, vai se gastar muito tempo e dinheiro em coisas desnecessárias.

É muito comum que os SW vão se desenvolvendo com o tempo, pois com o tempo acaba se entendendo cada vez mais as regras de negócio.

## ESTRUTURA

Nessa aula, será apresentado os conceitos que criam as estruturas básicas da OO;
TUdo na OO começa a partir destes conceitos.

### - Classe: 

Embora o nome do paradigma seja orientação a objetos, na verdade tudo começa com uma classe que é uma unidade mínima e básica.

Classe *é uma estrutura que abstrai um conjuntode objetos com caracterísiticas similares.* Uma classe define o comportamento de seus objetos através de métodos e os estados possiveis deste objetos através de atributos.
Em outros temos, uma classe descreve os serviços providos por seus objetos e queis informações eles podem armazenar.

![img_5.png](img_5.png)

Entidades concretas e abstratas são representadas pelas classes.

#### Dicas na criação das clases:

- Substantivos
- Nomes significativos 
- Contexto deve ser considerado

Por exemplo, pessoa é uma entidade que existe em muitos sistemas e é extremamente genérico. 
Se pensarmos em um sistema de uma loja Pessoa pode ser melhor representada pela Entidade Cliente. 
Numa escola, Pessoa pode ser Aluno, Professor etc, mesmo que pessoa seja mais geral, mas o contexto deixa claro que devemos ser mais específicos neste cado.

Código

![img_7.png](img_7.png)

### Exercicio - crie a classe Carro

### - Atributo

É o elemento de uma classe responsável por definir (caracterizar o conceito do mundo real) sua estrutura de dados. O conjunto destes será responsável por representar suas caracterpisticas e fará parte dos objetos criados a partir da classe

![img_8.png](img_8.png)

### Atributo X Variável

A: O que é próprio e peculiar a aluém ou a alguma coisa

V: Sujeito a variações ou mudanças que pode variar, incostante e instável.

#### Dicas na criação dos atributos:

- Substantivos e adjetivos
- Nomes significativos
- Contexto deve ser considerado
- Abstração - limitar o necessário
- Tipos Adequados 

![img_9.png](img_9.png)

### EXERCÍCIO2

Defina 3 atributos de um Carro cor modelo e capacidade do tanque


### - Método

É uma porção de código(sub-rotina) que é disponibilizada pela classe.
Este pe executado quando é feita uma requisição a ele.
Um método serve para identificar quais serviçoes, ações, que a classe oferece.
Eles são responsáveis por definir e realizar um determinado comportamento.

![img_10.png](img_10.png)

Veja que Bola saiu pq não temos lógica envolvida como métodos para bola

![img_11.png](img_11.png)

#### Dicas na criação dos atributos:

- Verbos - Ações/Comportamentos
- Nomes significativos
- Contexto deve ser considerado

![img_12.png](img_12.png)

Há dois métodos especiasis que merecem destaque:

- Construtor: Constrói objetos a partir das nossas classes 

![img_13.png](img_13.png)

- Destrutor: Auxilia a destruição do objeto  - o proprio garbagecollctor chama o destrutor para liberar recursos

![img_14.png](img_14.png)

- Sobrecarga - Mudar a assinatura de acordo com a necessidade
    
  Sobrecarga = nome+parâmetros

![img_15.png](img_15.png)

### Exercicio3
Defina 1 método para calcular o valor totral para encher o tanque recebendo o valor da gasolina


- Objeto

Embora o nome do paradigma seja orientação a objetos, primeiro passamos pela classe, atributos e métodos.

Um objeto é a representação de um conceito/entidade do mundo real, que pode ser física(bola,carro, árvore etc.) ou conceitual(viagem, estoque, compra etc.) e possui um significado bem definido para um determinado softwre.
Para esse conceito/entidade, deve ser definida inicialmente uma classe a partir da qual posteriormente serão instanciados objetos distintos.

![img_16.png](img_16.png)



- Mensagem

É o processo de ativação de um método de um objeto.
Isto ocorre quando uma requisição(chamada) a esse método é realizada, assim disparando a execução de seu comportametno descrito pela sua classe, casso a requisição não seja um método estático.

A troca de mensagens entre as entidades é que faz o sistema funcionar. 

![img_17.png](img_17.png)

Exercício 4 
Crie Objetos Carro e use métodos set/get para definir valores

# AULA4

1. Apresentar os conceitos que ajudam a criar entidades a partir
   de outras entidades:
   - Herança
   
     É o relacionamento entre classes em que uma classe chamada de subclasse (classe filha, classe derivada) é uma extensão, um subtipo, de outra classe chamada de superclasse (classe pai, classe mãe, classe base). Devido a isto, a subclasse consegue
     reaproveitar os atributos e métodos dela. Além dos que
     venham a ser herdados, a subclasse pode definir
     seus próprios membros.

  ![img_18.png](img_18.png)

Tipos de herança:
- Simples

    ![img_19.png](img_19.png)

- Múltipla

    ![img_20.png](img_20.png)

![img_21.png](img_21.png)

Herança Upcast e Downcast

![img_22.png](img_22.png)

![img_23.png](img_23.png)

### Polimorfismo

    A mesma ação, se comportando diferente.

![img_24.png](img_24.png)

Formas de processar distintas uma das outras.
Temos o mesmo método se comportando de maneiras distintas.

### Sobrescrita

"A mesma ação, podendo se comportar diferente. "
![img_25.png](img_25.png)

Conta COrrente e Universitária não sobrescrevem exibirSaldo();

### polimorfismo X sobrescrita

São bem parecidos, mas conceitualmente são dierentes
No polimorfismo é obrigado o comportamento diferente, na sobrescrita não.

### Exercicios

Crie as classes Funcionarios, GerentemVendedor e Faxineiro e realize upcast e downcast e analise o comportametno de Polimorfismo e sobrescrita


##  - Associação

Possibilita um relacionamento entre classes/objetos, no qual estes possam pedir ajuda a outras classes/objetos e representar de forma completa o conceito ao qual se destinam.
Neste tipo de relacionamento, as classes e os objetos interagem entre si para atingir seus objetivos.

### TIPOS DE ASSOCIAÇÃO

- Estrutural - A Associação é manifestada na estrutura do objeto ou seja nos seus atributos e podem ser:
  - Composição: "Com Parte Todo" - Ex: Pessoa Endereço
    
  ![img_26.png](img_26.png)
  
Uma parte que é um endereço só pode existir com o Todo que é uma Pessoa. Ou seja, este endereço só pertence a uma única Pessoa(esta parte só pertence a este Todo).
Se esse Todo deixa de existir, a parte também deixará de existir. É uma relação muito forte de dependência entre eles, ou seja o todo é composto pela parte, logo se o todo deixa de existir a parte tbm deixará.

Exemplo

![img_27.png](img_27.png)


  - Agregação - "Sem Parte Todo" - Se uma parte deixar de existir não implica que o todo deixará de existir

![img_28.png](img_28.png)

Por exemplo as entidades Aluno e Disciplina, se um aluno ou Disciplina deixa de existir não implica que o outro tbm deixe de existir, pois por exepmlo um aluno pode ter outras disciplinas e uma disciplina pode ter outros alunos.

![img_29.png](img_29.png)


### Agregação X Composição

É mais conceitual, a composição é mais forte o relacionamento e a agregação não.



- Comportamental - Tem a ver com os métodos e pode ser de dependência 
  - Depêndencia - "Depende de"  

O método finalizar pode ser usado ou não, mas quando usado precisa da relação com a entidade cupom, diferente de por exemplo o atributo Cliente que deve ser usado de toda forma.

![img_30.png](img_30.png)

No código

![img_31.png](img_31.png)

### HERANÇA X ASSOCIAÇÂO

Herança é mais rígida pois trabalha diretamente na classe, já associação trabalha nos métodos e atributos logo pode ser modificado em tempo de complilação.

### Exercicio

Codifique os exemplos dos slides anteriores;

## - Interface

Define um contrato que deve ser seguido pela classe que a implementa. QUando uma classe implementa uma interface, ela se compromete a realizar todos os comportamentos que a interface disponibiliza;

![img_32.png](img_32.png)

### Exercicio

Codifique uma interface OpMatematica que faz um contrato de criação das 4 operações;
