package br.com.dio.digital_java.exercicio.aula05_framework_collections;

import java.util.*;

public class ExemploList {
    public static void main(String[] args) {
        System.out.println("Crie uma lista de notas e add 7, 8.5 e 9");
        List<Double> notas = new ArrayList<Double>();
        notas.add(7d);
        notas.add(8.5);
        notas.add(9d);
        System.out.println(notas);
        System.out.println(notas.toString());
        System.out.println("Exiba aa posição da nota 8.5: " + notas.indexOf(8.5));
        System.out.println("Add a nota 8 na posição 1: ");
        notas.add(1, 8d);
        System.out.println("Notas: " + notas);
        System.out.println("Substitua a nota 8 por 3");
        notas.set(notas.indexOf(8d), 3d);
        System.out.println("Notas: " + notas);
        System.out.println("A nota 3 está na lista? : " + notas.contains(3d));
        System.out.println("Exiba todas as notas na ordem em que foram informados");
        for (Double nota : notas){
            System.out.println(nota);
        }
        System.out.println("Exiba a 2º nota added:"+notas.get(2));
        System.out.println("A menor nota é: "+ Collections.min(notas));
        System.out.println("A maior nota é: "+ Collections.max(notas));
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while (iterator.hasNext()){
            Double next = iterator.next();
            soma+=next;
        }
        System.out.println("A soma das notas é: "+ soma);
        System.out.println("A média das notas é: "+ soma/notas.size());
        System.out.println("Remova a nota 3");
        notas.remove(notas.indexOf(3d));

        System.out.println("Remova as ntoas menores do que 7");
        Iterator<Double> iterator1= notas.iterator();
        while (iterator1.hasNext()){
            if (iterator1.next()<7){
                iterator1.remove();
            }
        }
        System.out.println("Notas sem elementos menores do que 7: "+notas);
        System.out.println("Apague a lista");
        notas.clear();
        System.out.println("A lista está vazia?: "+ notas.isEmpty());
        System.out.println("Crie uma lista chamada Notas com uma lista ligada");
        List<Double> notaLigada = new LinkedList<>();
        notaLigada.add(7.0);
        notaLigada.add(2d);
        notaLigada.add(9.5);
        notaLigada.add(2.3);
        System.out.println("Mostre a primeira nota da lista sem removê-la: "+notaLigada.get(0));
        System.out.println("Mostre a primeira nota da lista removendo-a: "+notaLigada);
        notaLigada.remove(0);
        System.out.println("Mostre a primeira nota da lista removendo-a: "+notaLigada);





    }
}
