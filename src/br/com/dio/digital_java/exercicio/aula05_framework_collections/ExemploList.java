package br.com.dio.digital_java.exercicio.aula05_framework_collections;

import java.util.ArrayList;
import java.util.List;

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





    }
}
