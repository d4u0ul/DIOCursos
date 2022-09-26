package br.com.dio.digital_java.exercicio.aula08_excecoes;

public class DivisaoNaoExataException extends Exception{

    private int numerado;
    private int denominador;

    public DivisaoNaoExataException(String message, int numerado, int denominador) {
        super(message);
        this.numerado = numerado;
        this.denominador = denominador;
    }
}