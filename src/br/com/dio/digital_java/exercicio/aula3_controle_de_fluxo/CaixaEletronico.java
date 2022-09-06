package br.com.dio.digital_java.exercicio.aula3_controle_de_fluxo;

public class CaixaEletronico {
    public static void main(String[] args) {
        double saldo = 25.0;
        //double valorSolicitado = 17.0;
        double valorSolicitado = 25.0;
        //condicional simples
        if(valorSolicitado < saldo)
            saldo = saldo -valorSolicitado;
        System.out.println(saldo);
    }
}
