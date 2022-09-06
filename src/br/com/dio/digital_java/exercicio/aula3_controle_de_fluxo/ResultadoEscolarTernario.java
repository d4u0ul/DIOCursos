package br.com.dio.digital_java.exercicio.aula3_controle_de_fluxo;

public class ResultadoEscolarTernario {
    public static void main(String[] args) {
        int nota = 6;
        //condicional composta
        String resultado = nota>=7 ? "Aprovado" : "Reprovado";

        System.out.println(resultado);
    }
}
