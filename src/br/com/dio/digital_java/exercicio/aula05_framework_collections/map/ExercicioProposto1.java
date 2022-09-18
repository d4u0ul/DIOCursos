package br.com.dio.digital_java.exercicio.aula05_framework_collections.map;

import java.util.*;

public class ExercicioProposto1 {
    public static void main(String[] args) {
        //crie um dicionario e relacione os estados e populações
        Map<String, Integer> estados = new HashMap<>(){{
           put("PE",9616621);
           put("AL",3351543);
           put("CE",9187103);
           put("RN",3534265);
        }};
        System.out.println(estados);

        System.out.println(estados.get("RN"));
        estados.put("RN",3534165);
        System.out.println(estados.get("RN"));

        boolean existePB = estados.containsKey("PB");
        System.out.println("O estado da PB es´ta no dicionário?:"+ existePB);
        if(!existePB){
            System.out.println("Não existe PB no dicionário, adding");
            estados.put("PB",4039277);
            System.out.println("O estado da PB está no dicionário?:"+ estados.containsKey("PB"));
        }
        System.out.println("A população de PE é de:"+estados.get("PE"));
        System.out.println("Exibindo o dicionário de acordo com a ordem em que foi preenchido");
        Map<String,Integer> estadosOrdemInsercao = new LinkedHashMap<>(){{
            put("PE",9616621);
            put("RN",3534265);
            put("AL",3351543);
            put("CE",9187103);
        }};
        Set<Map.Entry<String, Integer>> entries = estadosOrdemInsercao.entrySet();
        for (Map.Entry<String, Integer> entry : entries){
            System.out.println(entry.getValue()+" - "+ entry.getValue());
        }
        Map<String,Integer> estadosOrdemIAlf = new TreeMap<>(estadosOrdemInsercao);
        System.out.println(estadosOrdemIAlf);

        Integer maiorPopulacao  = Collections.max(estadosOrdemInsercao.values());
        Integer menorPopulacao  = Collections.min(estadosOrdemInsercao.values());

        Integer count =0;
        for (Map.Entry<String, Integer> entry : entries){
            if (entry.getValue()==menorPopulacao) System.out.println("Estado menor Pop: "+entry.getKey()+" pop:"+entry.getValue());
            if (entry.getValue()==maiorPopulacao) System.out.println("Estado maior Pop: "+entry.getKey()+" pop:"+entry.getValue());
            count += entry.getValue();
        }

        System.out.println("A soma das populações deles é de: "+(menorPopulacao+maiorPopulacao));

        System.out.println("A média da populaçãco destes estados é de: " +count/ entries.size());
        System.out.println("Entries original:"+entries);
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getValue()<4000000) iterator.remove();
        }
        System.out.println("Entries <4000000:"+entries);


        System.out.println("Entries:"+entries);
        entries.clear();
        System.out.println("Entries apagado:"+entries);



    }
}
