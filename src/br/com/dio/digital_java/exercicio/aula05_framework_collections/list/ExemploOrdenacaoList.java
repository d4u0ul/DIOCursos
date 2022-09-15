package br.com.dio.digital_java.exercicio.aula05_framework_collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

        System.out.println("Imprimindo na ordem nominal antes: "+ meusGatos);
        Collections.sort(meusGatos);//utilizando a interface comparable que é implementada na própria classe
        System.out.println(meusGatos);

        System.out.println("Imprimindo na ordem idade antes: "+ meusGatos);
        Collections.sort(meusGatos, new ComparatorIdade());//utilizando a interface comparator que é implementada em outra classe ComparatorIdade
        //ou tbm dá pra usar meusGatos.sort(new ComparatorIdade()):
        System.out.println(meusGatos);

        System.out.println("Imprimindo na ordem cor antes: "+ meusGatos);
        Collections.sort(meusGatos, new ComparatorCor());//utilizando a interface comparator que é implementada em outra classe ComparatorCor
        //ou tbm dá pra usar meusGatos.sort(new ComparatorCor()):
        System.out.println(meusGatos);

        System.out.println("Imprimindo na ordem Nome/Cor/Idade antes: "+ meusGatos);
        Collections.sort(meusGatos, new ComparatorNomeCorIdade());//utilizando a interface comparator que é implementada em outra classe ComparatorNomeCorIdade
        //ou tbm dá pra usar meusGatos.sort(new ComparatorNomeCorIdade()):
        System.out.println(meusGatos);


        System.out.println("Imprimindo na ordem Nome/Idade/Cor pelo comparing/thenComparing antes: "+ meusGatos);
        //ou tbm dá pra usar meusGatos.sort(new ComparatorNomeCorIdade()):
        meusGatos.sort(Comparator.comparing(Gato::getNome).thenComparing(Gato::getIdade).thenComparing(Gato::getCor));
        System.out.println(meusGatos);



    }
}
class Gato implements Comparable<Gato>{
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

    @Override
    public int compareTo(Gato gato) {
        /*
        * ensinando a classe a indicar as comparações dos objetos
        * para isso é preciso a classe implentar a interface comparator para ensinar o método sort como definir quem é maior, menor e igual(+,-,0)
        * abaixo, é indicado que deve-se atribuir pelo nome do gato
        * */
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}
class ComparatorIdade implements Comparator<Gato>{

    @Override
    public int compare(Gato o1, Gato o2) {
        return Integer.compare(o1.getIdade(), o2.getIdade());
    }
}
class ComparatorCor implements Comparator<Gato>{

    @Override
    public int compare(Gato o1, Gato o2) {
        /*Se o o1 for maior retorna +1, se for menor -1 e se forem iguais 0
        * */
        return (o1.getCor().compareToIgnoreCase(o2.getCor()));
    }
}
class ComparatorNomeCorIdade implements Comparator<Gato>{

    @Override
    public int compare(Gato o1, Gato o2) {
        int nome = o1.getNome().compareToIgnoreCase(o2.getNome());
        if(nome !=0) return nome;
        int cor = o1.getCor().compareToIgnoreCase(o2.getCor());
        if(cor!=0) return cor;
        return Integer.compare(o1.getIdade(), o2.getIdade());
    }
}
