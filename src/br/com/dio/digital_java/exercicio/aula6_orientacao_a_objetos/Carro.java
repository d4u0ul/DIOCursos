package br.com.dio.digital_java.exercicio.aula6_orientacao_a_objetos;

/**
 * classe exemplo
 */
public class Carro extends Veiculo{

    String cor;
    String modelo;
    Double capacidadeDoTanque;

    public Carro(String cor, String modelo, Double capacidadeDoTanque, Integer qtdPneus, Integer qtdeOcupantes, String ano) {
        super(qtdPneus,qtdeOcupantes,ano);
        this.cor = cor;
        this.modelo = modelo;
        this.capacidadeDoTanque = capacidadeDoTanque;
    }

    public Carro(String modelo, Double capacidadeDoTanque, Integer qtdPneus, Integer qtdeOcupantes, String ano) {
        super(qtdPneus,qtdeOcupantes,ano);
        this.modelo = modelo;
        this.capacidadeDoTanque = capacidadeDoTanque;
    }

    public Carro() {
    }

    public Double valorTanqueCheio(Double valorLitroGasolina){
        return this.capacidadeDoTanque*valorLitroGasolina;
    }
}
class Main{
    public static void main(String[] args) {
        Carro fusca = new Carro("Preto", "Besouro",50.0,5,5,"2019");
        fusca.ano = "2020";
        fusca.qtdPneus =4;
        fusca.qtdeOcupantes =5;
        System.out.println("Valor do tanque cheio é de: "+fusca.valorTanqueCheio(5.69) +" e consegue transportar até "+fusca.qtdeOcupantes +" passageiros");
    }
}

class Veiculo{

    Integer qtdPneus ;
    Integer qtdeOcupantes;
    String ano;

    public Veiculo(Integer qtdPneus, Integer qtdeOcupantes, String ano) {
        this.qtdPneus = qtdPneus;
        this.qtdeOcupantes = qtdeOcupantes;
        this.ano = ano;
    }

    public Veiculo() {
    }
}