package br.com.dio.digital_java.exercicio.aula05_framework_collections.set;

import java.util.*;

public class ExemploSet {
    public static void main(String[] args) {
        /*
        Dada uma lista com 7 notas de um aluno [7,8.5,9.3,5,7,0,3.6,7], faça
        1) Inicialize um set:
        Há algumas maneiras de se implementar um set;
        Set notas = new HashSet(); // antes do java5
        HashSet<Double> notas = new HashSet(); //desestimulado por desenvolver para a classe e não para a interface
        Set<Double> notas = new HashSet<>(); //Generics Java5+ e Diamond Operator Java7+ <-MELHOR CANDIDATO1
        Set<Double> notas = new HashSet<>(Arrays.asList(7d,8.5,9.3,5d,7d,0d,3.6,7d)); //Generics Java5+ e Diamond Operator Java7+ <-MELHOR CANDIDATO2
        Set<Double> notas = Set.of(7d,8.5,9.3,5d,7d,0d,3.6,7d) // fica estático sem possibilidades de add ou remover
        notas.add(1d); // dá erro
        notas.remove(1d); // dá erro
         */

        System.out.println("Inicialize um conjunto e coloque as Notas:");
        Set<Double> notas = new HashSet<>(Arrays.asList(7d,8.5,9.3,5d,7d,0d,3.6,7d));
        System.out.println("Notas: "+notas); //elementos do conjunto não têm uma ordem, pois são elementos de um HashSet - notas tbm pode ser impresso com notas.toString()
        notas.add(15d);
        System.out.println("Notas: "+notas); //elementos do conjunto não têm uma ordem, pois são elementos de um HashSet - notas tbm pode ser impresso com notas.toString()
        //add elemento em alguma posição ou substitua alguma posição não se aplica para conjuntos já que naõ temos posições marcadas
        System.out.println("A nota 5 está no conjunto?: "+notas.contains(5.0));
        System.out.println("A menor nota no conjunto de notas é: "+ Collections.min(notas));
        System.out.println("A maior nota no conjunto de notas é: "+ Collections.max(notas));

        Double count = 0.0;
        Iterator<Double> iterator = notas.iterator();
        while(iterator.hasNext()){
            count += iterator.next();
        }
        System.out.println("A soma dos valores é: "+count);

        System.out.println("A média das notas é: "+count/notas.size());
        System.out.println("Conjunto com o zero: "+notas);
        notas.remove(0d);
        System.out.println("Conjunto sem o zero: "+notas);

        System.out.println("Remova as notas menores do que 7");
        System.out.println("Conjunto com notas menores do que 7: "+notas);
        Iterator<Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()){
            Double nota = iterator1.next();
            if (nota<7) iterator1.remove();
        }
        System.out.println("Conjunto sem as notas menores do que 7: "+notas);

        System.out.println("Imprima o conjunto em ordem de inserção");
        Set <Double> notasOrdenadasPelaInsercao = new LinkedHashSet<>();
        notasOrdenadasPelaInsercao.addAll(Arrays.asList(7d,8.5,9.3,5d,7d,0d,3.6,7d));
        System.out.println("Notas ordenadas de acordo com a inserção: "+notasOrdenadasPelaInsercao);

        System.out.println("Imprima o conjunto notas em ordem numérica"); // para isso usamos o treeSet
        Set<Double> notasOrdenadas = new TreeSet<>(notasOrdenadasPelaInsercao); // tbm é possível passar diretamente a collection
        System.out.println("Notas ordenadas pelo número: "+notasOrdenadas);

        System.out.println("Apagando o conjunto notas : "+notasOrdenadas);
        notasOrdenadas.clear();
        System.out.println("Notas: "+notasOrdenadas);
        System.out.println("Notas: "+notasOrdenadas.isEmpty());



    }
}
