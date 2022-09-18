package br.com.dio.digital_java.exercicio.desafios;


import java.util.Scanner;

public class App {

    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);
        //int t = leitor.nextInt();
        int t = 3;

// TODO: Implemente uma condição onde possamos preencher o vetor de N.
// Lembre-se a sequência de valores é de 0 até T-1:
        int[] T    =   new int[1000];

        for(int i = 0 ; i <1000; i ++ ){


            for(int j = 0;j< t ;j++){
                if(i<1000){
                //System.out.println("i:"+i+" j:"+j);
                    T[i] = j;
                    System.out.println("N[" + i  + "] = "+ j  );
                    i++;
                }
            }
            i--;
        }
    }
}