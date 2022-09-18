package br.com.dio.digital_java.exercicio.aula05_framework_collections.stream_api;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ExerciciosStreamAPI {
    /*
    Quais as operações que compôem o StreamAPI
    OBS: Stream não modifica a fonte dos dados
    Há 2 tipos de operações
        -Intermediárias : Op. que retornam um Stream e podemos encadear várias uma atrás da outra
        -Finais: Só podemos usar uma única diferentemente da Intermediária, mas elas retornam um objeto ou valor
     */
    public static void main(String[] args) {
        List<String> numerosAleatorios = Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5"); //Fixa

        System.out.println("Imprima todos os elementos dessa lista de String: ");
        //usando o foreach()
        // forEach pede uma interface funcional Consumer
        System.out.println("Com um forEach usando uma interface funcional Consumer");
        numerosAleatorios.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                //método accept não retorna nada só interage trabalhando com cada elemento do grupo de elementos que foi passado para o foreach
                //para imprimir cada elemento do grupo, temos:
                System.out.println(s);
            }
        });
        //mas fica muito grande, então podemos simplificar com lambda
        //convertendo 1 - apaga do parênteses da função até o parâmetro s
        /* numerosAleatorios.stream().forEach(s) {
                //método accept não retorna nada só interage trabalhando com cada elemento do grupo de elementos que foi passado para o foreach
                //para imprimir cada elemento do grupo, temos:
                System.out.println(s);
            }
        });*/
        //convertendo 2 - troca do ")" do parâmetro s até a função pela flecha ->
        /* numerosAleatorios.stream().forEach(s -> System.out.println(s);
            }
        });*/
        //convertendo 3 - completa o parênteses faltante da função e apaga o restante
        /* numerosAleatorios.stream().forEach(s -> System.out.println(s));
        */
        System.out.println("Simplificando um forEach usando uma interface funcional Consumer para uma expressão Lambda");
        numerosAleatorios.stream().forEach(s -> System.out.println(s));
        System.out.println("O próprio List tem um forEach não precisando do stream para usar uma expressão Lambda");
        numerosAleatorios.forEach(s -> System.out.println(s));
        System.out.println("Ainda dá para simplificar trocando a expressão Lambda por um refernce Method passando o mouse em cima a propria IDE cria");
        numerosAleatorios.forEach(System.out::println);

        System.out.println("Pegue os 5 primeiros números e coloque dentro de um Set:");
        //limit - qtos primeiros elementos vc quer
        //collect - pegue os elementos limitados
        //Collectors.toSet já joga para o conjunto OBS:1 só escrito uma vez
        numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        //se quisermos jogar numa variável é só deixar até o toSet e mandar o Ctrl+alt+v e jogar numa variável qualquer
        Set<String> numerosAleatorios5Primeiros = numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet());
        System.out.println(numerosAleatorios5Primeiros);

        System.out.println("Transforme esta lista de String em uma lista de números inteiros.");
        //Agora vamos transformar cada elemento dentro da Stream com a operação map
        //tranformando toda a lista em int com interface funcional
        System.out.println("Usando interface Funcional");
        numerosAleatorios.stream()
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s);
                    }
                });
        System.out.println("Usando expressões lambda");
        //transformando a interface funcional em lambda
        // (1) apaga da função até o parâmetro
        /*numerosAleatorios.stream()
                .map( s) {
                        return Integer.parseInt(s);
                    }
                });*/
        // (2) apaga do parênteses do parâmetro até a função e coloca a flecha ->
        /*numerosAleatorios.stream()
                .map( s- > Integer.parseInt(s);
                    }
                });*/
        // (3) Coloca o parênteses faltante e apaga o resto
        /*numerosAleatorios.stream().map( s- > Integer.parseInt(s));
                    */
        numerosAleatorios.stream().map( s-> Integer.parseInt(s));
        System.out.println("Usando Refence Method");
        //a IDE ajuda a transformar
        numerosAleatorios.stream().map(Integer::parseInt);
        //O map acima reclama, pois não estamos salvando o resultado em nenhuma variável
        //para fazermos isso, iremos "COLETAR" os elementos e jogá-los numa lista
        //numerosAleatorios.stream().map(Integer::parseInt).collect(Collectors.toList()).forEach(System.out::println);
        List<Integer> collectList = numerosAleatorios.stream().map(Integer::parseInt).collect(Collectors.toList());

        System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista:");
        //stream() - transforma a collection em fluxo
        //map - trabalha cada elemento do fluxo, nesse caso executa o parseInt e retorna um Integer
        //filter - pede uma interface funcional "PREDICATE"
        System.out.println("Usando interface Funcional"); //Não é usado mais
        List<Integer> listParesMaioresQue2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        if (integer % 2 == 0 && integer > 2) return true;
                        return false;
                    }
                }).collect(Collectors.toList());
        System.out.println("listParesMaioresQue2"+listParesMaioresQue2);

        System.out.println("Usando expressões lambda");
        // (1) apaga da função até o parâmetro
        /*List<Integer> listParesMaioresQue2_2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(integer) {
                        if (integer % 2 == 0 && integer > 2) return true;
                        return false;
                    }
                }).collect(Collectors.toList());
        System.out.println("listParesMaioresQue2_2"+listParesMaioresQue2_2);*/
        // (2) apaga do parênteses do parâmetro até a função e coloca a flecha ->
        /*List<Integer> listParesMaioresQue2_2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(integer -> (integer % 2 == 0 && integer > 2) return true;
                        return false;
                    }
                }).collect(Collectors.toList());
        System.out.println("listParesMaioresQue2_2"+listParesMaioresQue2_2);*/
        // (3) Coloca o parênteses faltante e apaga o resto
        /*List<Integer> listParesMaioresQue2_2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(integer -> (integer % 2 == 0 && integer > 2)).collect(Collectors.toList());
        System.out.println("listParesMaioresQue2_2"+listParesMaioresQue2_2);*/

        List<Integer> listParesMaioresQue2_2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(integer -> (integer % 2 == 0 && integer > 2)).collect(Collectors.toList());

        System.out.println("listParesMaioresQue2_2"+listParesMaioresQue2_2);



        System.out.println("Mostre a média dos números: ");
        //mapToInt - outra interface funcional que transforma o elemento da collection em int
         // System.out.println("com interface FUncional");//não se usa mais
        //.average média - retorna um optionalDouble que evitar retornos Null
        //.ifPresent - se a média existir return value, se não não retorne nada
        numerosAleatorios.stream().mapToInt(new ToIntFunction<String>() {
            @Override
            public int applyAsInt(String value) {
                return Integer.parseInt(value);
            }
        }).average();
        System.out.println("Com expressão lambda");
        // (1) apaga da função até o parâmetro
        // (2) apaga do parênteses do parâmetro até a função e coloca a flecha ->
        // (3) Coloca o parênteses faltante e apaga o resto
        numerosAleatorios.stream().mapToInt( value-> Integer.parseInt(value)).average();
        System.out.println("Com reference method");
        numerosAleatorios.stream().mapToInt(Integer::parseInt).average().ifPresent(new DoubleConsumer() {
            @Override
            public void accept(double value) {
                System.out.println(value);
            }
        });

        System.out.println("Tranformando em reference method o Double Consumer");
        // (1) apaga da função até o parâmetro
        // (2) apaga do parênteses do parâmetro até a função e coloca a flecha ->
        // (3) Coloca o parênteses faltante e apaga o resto
        numerosAleatorios.stream().mapToInt(Integer::parseInt).average().ifPresent(System.out::println);




        System.out.println("Remova os valores ímpares: ");
        System.out.println("INTERFACE FUNCIONAL");
        List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream().map(Integer::parseInt).collect(Collectors.toList());
        //removeIf é um metodo de list por isso altera a List
        numerosAleatoriosInteger.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer%2 !=0) return true;
                return false;
            }
        });
        System.out.println(numerosAleatoriosInteger);
        System.out.println("EXPRESSAO LAMBDA");
        numerosAleatoriosInteger = numerosAleatorios.stream().map(Integer::parseInt).collect(Collectors.toList());
        numerosAleatoriosInteger.removeIf(integer->(integer%2 !=0));
        System.out.println(numerosAleatoriosInteger);



        System.exit(0);
//        Para você
//        System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante:");
//        numerosAleatoriosInteger.stream()
//                .skip(3)
//                .forEach(System.out::println);
//
//        long countNumerosUnicos = numerosAleatoriosInteger.stream()
//                .distinct()
//                .count();
//        System.out.println("Retirando os números repetidos da lista, quantos números ficam? " + countNumerosUnicos);
//
//        System.out.print("Mostre o menor valor da lista: ");
//        numerosAleatoriosInteger.stream()
//                .mapToInt(Integer::intValue)
//                .min()
//                .ifPresent(System.out::println);
//
//        System.out.print("Mostre o maior valor da lista: ");
//        numerosAleatoriosInteger.stream()
//                .mapToInt(Integer::intValue)
//                .max()
//                .ifPresent(System.out::println);;
//
//        int somaDosNumerosPares = numerosAleatoriosInteger.stream()
//                .filter(i -> (i % 2 == 0))
//                .mapToInt(Integer::intValue)
//                .sum();
//        System.out.println("Pegue apenas os números pares e some: " + somaDosNumerosPares);
//
//        System.out.println("Mostre a lista na ordem númerica: ");
//        List<Integer> numerosOrdemNatural = numerosAleatoriosInteger.stream()
//                .sorted(Comparator.naturalOrder())
//                .collect(Collectors.toList());
//        System.out.println(numerosOrdemNatural);
//
//        System.out.println("Agrupe os valores ímpares múltiplos de 3 ou de 5:");
////        dica: collect(Collectors.groupingBy(new Function())
//        Map<Boolean, List<Integer>> collectNumerosMultiplosDe3E5 = numerosAleatoriosInteger.stream()
//                .collect(Collectors.groupingBy(i -> (i % 3 == 0 || i % 5 == 0)));
//        System.out.println(collectNumerosMultiplosDe3E5);
    }
}
