package br.com.dio.digital_java.exercicio.aula05_framework_collections.list;

import java.util.*;

public class ExercicioProposto {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        HashMap<String, Double> tabelaDeTemperaturas= new HashMap<>();
        boolean aindaHaRegistros = true;
        while(aindaHaRegistros){
            informaTemperaturaEMes(sc1, sc2, tabelaDeTemperaturas);
            String respostaDoAdd = chequeResposta(sc3);
            aindaHaRegistros = addValorNaTabelaDeTemperaturas(respostaDoAdd);
            /*
            O sc.next() pega qlq coisa, mas para indicar o tipo correto dá pra passar:
            float numF = sc.nextFloat();
            int num1 = sc.nextInt();
            byte byte1 = sc.nextByte();
            long lg1 = sc.nextLong();
            boolean b1 = sc.nextBoolean();
            double num2 = sc.nextDouble();
            String nome = sc.nextLine();
             */
        }

        sc1.close();
        sc2.close();
        sc3.close();
        System.out.println("Lista de Temperaturas: "+tabelaDeTemperaturas);

        Double valorTotalDeTemperatura = 0d;
        for (Double temp : tabelaDeTemperaturas.values()){
            valorTotalDeTemperatura += temp;
        }
        System.out.println("O valor total da temperatura é: "+valorTotalDeTemperatura);
        Double valorMedioDaTemperatura = valorTotalDeTemperatura / tabelaDeTemperaturas.size();
        System.out.println("A media do valor de temperatura é: "+ valorMedioDaTemperatura.toString());
        List<Double> listaDeValoresAcimaDaMedia = new ArrayList<>();
        List<String> listaDeMesesAcimaDaMedia = new ArrayList<>();
        for (Map.Entry<String,Double> registro : tabelaDeTemperaturas.entrySet()){
            if (registro.getValue()>valorMedioDaTemperatura){
                System.out.printf("Valor %s acima da média, add...\n",registro.getValue());
                listaDeValoresAcimaDaMedia.add(registro.getValue());
                listaDeMesesAcimaDaMedia.add(registro.getKey());
                continue;
            }
            System.out.printf("Valor %s abaixo da media, continuando...\n",registro.getValue());

        }
        for (String mes:listaDeMesesAcimaDaMedia){
            System.out.printf("%s-",mes);
            System.out.printf("%s\n",listaDeValoresAcimaDaMedia.get(listaDeMesesAcimaDaMedia.indexOf(mes)));
        }


    }

    private static void informaTemperaturaEMes(Scanner sc1,Scanner sc2, HashMap<String, Double> tabelaDeTemperaturas) {
        System.out.println("Digite o Mês de registro: ");
        String mes = sc1.next();
        System.out.println("Digite um registro de temperatura média: ");
        double registro = sc2.nextDouble();
        tabelaDeTemperaturas.put(mes,registro);
    }
    private static String chequeResposta(Scanner sc3) {
        System.out.println("Deseja add mais algum registro? sim ou não?");
        String respostaDoAdd = sc3.next();
        while(!(respostaDoAdd.equalsIgnoreCase("Sim")|| respostaDoAdd.equalsIgnoreCase("Não"))){
            System.out.printf("Valor inválido,>%s< digite sim ou não para add ou não mais um registro:\n",respostaDoAdd);
            respostaDoAdd = sc3.next();
        }
        return respostaDoAdd;
    }
    private static boolean addValorNaTabelaDeTemperaturas(String respostaDoAdd) {
        boolean aindaHaRegistros;
        aindaHaRegistros = respostaDoAdd.equalsIgnoreCase("Sim") ? true :  false ;
        return aindaHaRegistros;
    }



}
