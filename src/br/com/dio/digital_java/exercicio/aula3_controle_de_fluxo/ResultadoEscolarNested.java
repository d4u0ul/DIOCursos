package br.com.dio.digital_java.exercicio.aula3_controle_de_fluxo;

public class ResultadoEscolarNested {
    public static void main(String[] args) {
        int nota = 6;
        //condicional composta
        if(nota>=7)
            System.out.println("aprovado");
        else if (nota >=5 && nota<7)
            System.out.println("prova recuperação");
        else
            System.out.println("reprovado");
    }
}
