package br.com.dio.digital_java.exercicio.aula05_framework_collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

import static java.lang.System.exit;

public class Desafio {
    public static void main(String[] args) {
        Map<Integer,Integer> valoresDado = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            int valor = valorLancamento();
            if(!valoresDado.containsKey(valor)){
                valoresDado.put(valor,1);
                //System.out.println(valoresDado);
                continue;
            }
            int qtdValor = valoresDado.get(valor)+1;
            valoresDado.put(valor,qtdValor);
        }
        System.out.println(valoresDado);
        Set<Map.Entry<Integer, Integer>> entries = valoresDado.entrySet();
        System.out.println(entries);
    }
    private static int valorLancamento(){
        Random ran = new Random();
        int x = ran.nextInt(6) ;
        return x;
    }
}
