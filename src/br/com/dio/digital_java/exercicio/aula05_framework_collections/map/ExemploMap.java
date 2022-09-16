package br.com.dio.digital_java.exercicio.aula05_framework_collections.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ExemploMap {
    public static void main(String[] args) {
        /*
        Dados os modelos dos carros e seus respectivos consumos na estrada, faça:
            modelo =   "gol"        consumo =   14.4 km/l
            modelo =   "uno"        consumo =   15.6 km/l
            modelo =   "mobi"       consumo =   16.1 km/l
            modelo =   "hb20"       consumo =   14.5 km/l
            modelo =   "kwid"       consumo =   15.6 km/l
         */
        /*Inicialize um Map destes carros populares
        há várias maneiras:
        Map carrosPopulares2020 - new HashMap() //usada antes do java5
        Map<string, Double> carrosPopulares = new HashMap<>(); // Advento do Generics jdk5+ DiamondOperator Jdk7+
        HashMap<string, Double> carrosPopulares = new HashMap<>(); // programando para a classe, deve ser evitado. Sempre devemos preferir programar para a interface
         Map<string, Double> carrosPopulares = new HashMap<>() = Map.of("gol", 14.4 ,"uno", 15.6 ,"mobi", 16.1 ,"hb20", 14.5 ,"kwid", 15.6); // cria um Map imutável, assim como a lista e o set
         */

        System.out.println("Crie um dicionário que relacione o modelo do carro com seus respectivos consumos:");
        Map<String, Double> carrosPopulares2020 = new HashMap<>(){{
           put("gol" , 14.4) ;
           put("uno" , 15.6) ;
           put("mobi", 16.1) ;
           put("hb20", 14.5) ;
           put("kwid", 15.6) ;
        }};
        System.out.println("carrosPopulares2020: "+carrosPopulares2020);

        System.out.println("Substitua o consumo do gol por 15.2 km/l");
        carrosPopulares2020.put("gol", 15.2);
        System.out.println("carrosPopulares2020: "+carrosPopulares2020);

        System.out.println("O modelo tucson está no diciionário? : "+carrosPopulares2020.containsKey("tucson"));
        System.out.println("O modelo uno está no diciionário? : "+carrosPopulares2020.containsKey("uno"));

        System.out.println("O consumo do uno é: "+carrosPopulares2020.get("uno"));

        System.out.println("Exiba os modelos como um Set: "+carrosPopulares2020.keySet());
        //keySet retorna um conjunto com todas as keys do dicionário

        System.out.println("Exiba os consumos dos carros como uma Collection: "+ carrosPopulares2020.values());
        //values retorna uma collection de todos os valores, logo é possível utilizar todos os métodos das collections como min, max e reverse

        System.out.println("O máximo consumo é: "+ Collections.min(carrosPopulares2020.values())); // o carro menos eficiente faz a menor qtde de km/l

        Double consumoMaisEficiente = Collections.max(carrosPopulares2020.values());
        System.out.println("O consumo mais eficiente é: "+ consumoMaisEficiente);// mas aqui retorna o valor e não o par chave e valor
        //para retornar a chave e o valor temos o advento do termo entrySet que retorna um set de elementos do tipo entry
        Set<Map.Entry<String, Double>> entries = carrosPopulares2020.entrySet(); // veja o tipo da variável

        String modeloMaisEficiente = "";
        //percorrendo cada elemento entry criado no conjunto de entries
        for(Map.Entry<String,Double> entry: entries){
            if(entry.getValue().equals(consumoMaisEficiente)) modeloMaisEficiente = entry.getKey();
        }
        System.out.println("O modelo mais eficiente é o:"+modeloMaisEficiente + "e o seu consumo é:" +carrosPopulares2020.get(modeloMaisEficiente));
        System.out.println("E se tivésemos mais de um carro com o mesmo consumo?");
        carrosPopulares2020.put("gol",16.1);

        for(Map.Entry<String,Double> entry: entries){
            if(entry.getValue().equals(consumoMaisEficiente)) {
                modeloMaisEficiente = entry.getKey();
                System.out.println("O modelo mais eficiente é o:" + modeloMaisEficiente + "e o seu consumo é:" + carrosPopulares2020.get(modeloMaisEficiente));
            }
        }




    }
}
