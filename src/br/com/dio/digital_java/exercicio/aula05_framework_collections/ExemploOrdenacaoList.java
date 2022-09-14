package br.com.dio.digital_java.exercicio.aula05_framework_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
* Dadas as seguintes intormações crie uma lista e ordene-a
* nome-idade-cor
*
* Gato1 - jon, 18,preto
* Gato2 - Simba, 6, tigrado
* Gato3 - Jon, 12, amarelo
*
* */
public class ExemploOrdenacaoList {
    public static void main(String[] args) {

        List<Gato> meusGatos =new ArrayList<>(){{
            add(new Gato("Jon", 18, "preto"));
            add(new Gato("Simba", 6, "tigrado"));
            add(new Gato("Jon", 12, "amarelo"));
        }};
        for (Gato gato : meusGatos){
            System.out.println(gato);
        }
        System.out.println("Imprimindo na ordem: "+ meusGatos);
        Collections.shuffle(meusGatos);
        System.out.println("Imprimindo na ordem alatória: "+ meusGatos);

        System.out.println("Imprimindo na ordem natural: "+ meusGatos);
    }
}
class Gato {
    private String nome;
    private Integer idade;
    private String cor;

    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }
}
