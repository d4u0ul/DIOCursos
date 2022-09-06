package br.com.dio.digital_java.exercicio.aula3_controle_de_fluxo;

import javax.swing.*;

public class SistemaMedida {
    public static void main(String[] args) {
        String sigla = "M";

        switch (sigla){
            case "P":{
                System.out.println("Pequeno");
                break;
            }case "M":{
                System.out.println("Medio");
                break;
            }case "G":{
                System.out.println("Grande");
                break;
            }
            default:
                System.out.println("indefinido");
        }

    }
}
