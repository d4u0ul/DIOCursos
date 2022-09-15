package br.com.dio.digital_java.exercicio.aula05_framework_collections.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExercicioProposto2 {
    public static void main(String[] args) {
        inicializaSistema();
        List<String> listaDeRespostas = new ArrayList<>();
        realizeAsPerguntas(listaDeRespostas);
        definaACulpabilidade(listaDeRespostas);
    }

    private static void definaACulpabilidade(List<String> listaDeRespostas) {
        int qtdeDeSim =0;

        for (String resposta: listaDeRespostas){
            if (resposta.equalsIgnoreCase("Sim")) qtdeDeSim+=1;
        }
        /*
        Se quisesse usar iterator, fica assim:
        int qtdeDeSim = 0;
        Iterator<String> contador = listaDeRespostas.iterator();
        while(contador.hasNext()){
            String resp = contador.next();
            if(resp.contains("s")) {
                count ++;
            }
        }
        */
        if (qtdeDeSim<2){
            System.out.println("Esta pessoa é inocente...");
        } else if (qtdeDeSim ==2) {
            System.out.println("Esta pessoa é Suspeita...");
        } else if (qtdeDeSim<5) {
            System.out.println("Esta pessoa é Cúmplice...");
        }else System.out.println("Esta pessoa é a assassina...");

        /*Fazendo com o switch case, fica:
        switch(qtdeDeSim) {
            case 2:
                System.out.println(">> SUSPEITA <<"); break;
            case 3:
            case 4:
                System.out.println(">> CÚMPLICE <<"); break;
            case 5:
                System.out.println(">> ASSASSINO <<"); break;
            default:
                System.out.println(">> INOCENTE <<"); break;
        }
         */
    }

    private static void realizeAsPerguntas(List<String> listaDeRespostas) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Vc telefonou para a vitima?");
        listaDeRespostas.add(chequeResposta(sc1));
        System.out.println("Vc esteve no local do crime?");
        listaDeRespostas.add(chequeResposta(sc1));
        System.out.println("Vc mora perto da vitima?");
        listaDeRespostas.add(chequeResposta(sc1));
        System.out.println("Vc devia para a vítima?");
        listaDeRespostas.add(chequeResposta(sc1));
        System.out.println("Vc já trabalhou com a vítima?");
        listaDeRespostas.add(chequeResposta(sc1));
    }

    private static void inicializaSistema() {
        System.out.println("--\tSistema de reconhecimento de criminosos \t--");
        System.out.println("--\tResponda as perguntas para validar o processo\t--");
    }

    private static String chequeResposta(Scanner sc3) {
        String respostaDoAdd = sc3.next();
        while(!(respostaDoAdd.equalsIgnoreCase("Sim")|| respostaDoAdd.equalsIgnoreCase("Não"))){
            System.out.printf("Valor inválido,>%s< digite sim ou não para add ou não mais um registro:\n",respostaDoAdd);
            respostaDoAdd = sc3.next();
        }
        return respostaDoAdd;
    }
}
