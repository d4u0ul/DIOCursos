package br.com.dio.digital_java.exercicio.aula6_orientacao_a_objetos;

/**
 * classe exemplo
 */
public class Carro {

    String cor;
    String modelo;
    Double capacidadeDoTanque;

    public Carro(String cor, String modelo, Double capacidadeDoTanque) {
        this.cor = cor;
        this.modelo = modelo;
        this.capacidadeDoTanque = capacidadeDoTanque;
    }

    public Carro(String modelo, Double capacidadeDoTanque) {
        this.modelo = modelo;
        this.capacidadeDoTanque = capacidadeDoTanque;
    }

    public Double valorTanqueCheio(Double valorLitroGasolina){
        return this.capacidadeDoTanque*valorLitroGasolina;
    }
}
class Main{
    public static void main(String[] args) {
        Carro fusca = new Carro("Preto", "Besouro",50.0);

        System.out.println("Valor do tanque cheio é de: "+fusca.valorTanqueCheio(5.69));
    }
}