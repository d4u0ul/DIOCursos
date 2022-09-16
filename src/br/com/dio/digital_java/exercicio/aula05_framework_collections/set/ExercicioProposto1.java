package br.com.dio.digital_java.exercicio.aula05_framework_collections.set;

import java.util.*;

public class ExercicioProposto1 {
    public static void main(String[] args) {
        /*##Exercícios Propostos
        */

        System.out.println("\n[X]Crie um conjunto contendo as cores do arco-íris");
        Set<String> coresArcoIris = new HashSet<>(Arrays.asList("vermelha", "laranja", "amarela", "verde", "azul", "azul-escuro", "violeta"));
        System.out.println("As cores do arco-íris são: "+coresArcoIris);

        System.out.println("\n[X]Exiba todas as cores uma abaixo da outra");
        Iterator<String> iterator = coresArcoIris.iterator();
        while(iterator.hasNext()){
            String cor = iterator.next();
            System.out.println(cor);
        }

        System.out.println("\n[X]A quantidade de cores que o arco-íris tem é:"+coresArcoIris.size());
        Set<String> coresEmOrdemAlfabetica = new TreeSet<>(coresArcoIris);
        System.out.println("[X]Exiba as cores em ordem alfabética criando um treeSet: "+coresEmOrdemAlfabetica);
        Set<String> coresEmOrdemDeInsercao = new LinkedHashSet<>(){{
            for (String cor : Arrays.asList("vermelha", "laranja", "amarela", "verde", "azul", "azul-escuro", "violeta")){
                add(cor);
            }
        }};

        System.out.println("[X]Exiba as cores na ordem inversa da que foi informada");
        System.out.println("Cores em ordem normal da inserção:"+coresEmOrdemDeInsercao);
        List<String> coresEmOrdemDeInsercaoInversa = new ArrayList<>(coresEmOrdemDeInsercao);
        Collections.reverse(coresEmOrdemDeInsercaoInversa);
        System.out.println("Cores em ordem inversa da inserção:"+coresEmOrdemDeInsercaoInversa);

        Iterator<String> iterator1 = coresArcoIris.iterator();
        while(iterator1.hasNext()){
            String cor = iterator1.next();
            if(cor.startsWith("v")) System.out.println("Cor q comeca com V:"+cor);;
        }

        System.out.println("Cores do arco-íris:"+coresArcoIris);
        Set<String> coresArcoIrisSemV = coresArcoIris;
        Iterator<String> iterator2 = coresArcoIrisSemV.iterator();
        while(iterator2.hasNext()){
            String cor = iterator2.next();
            if(!cor.startsWith("v")) iterator2.remove();
        }

        System.out.println("[X]Remova todas as cores que não começam com a letra “v”:"+ coresArcoIrisSemV);
        System.out.println("[X]Limpe o conjunto");
        System.out.println("Cores do arco-íris:"+coresArcoIris);
        coresArcoIris.clear();
        System.out.println("[X]Confira se o conjunto está vazio");
        System.out.println("Cores do arco-íris limpo:"+coresArcoIris);

    }
}
