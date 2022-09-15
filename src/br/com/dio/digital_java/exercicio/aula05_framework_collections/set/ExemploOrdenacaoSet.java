package br.com.dio.digital_java.exercicio.aula05_framework_collections.set;

import java.util.*;
import java.util.function.Consumer;

public class ExemploOrdenacaoSet {
    public static void main(String[] args) {
        /*
        Crie um conjunto de séries e ordene
        serie1 = Nome:got,              genero = fantasia,  tempoEpisodio 60
        serie1 = Nome:dark,             genero = drama,     tempoEpisodio 60
        serie1 = Nome:that '70s show,   genero = comedia,   tempoEpisodio 25
         */
        System.out.println("--Imprima em Ordem aleatória--\t");
        Set<Serie> minhasSeries = new HashSet<>(){{
           add(new Serie("got",             "fantasia", 60));
           add(new Serie("dark",            "drama",    60));
           add(new Serie("that '70s show",  "comedia",  25));
        }};
        //outra maneira de iterar sobre os elementos de uma collection
        minhasSeries.forEach(new Consumer<Serie>() {
            @Override
            public void accept(Serie serie) {
                System.out.printf("",serie);
            }
        });

        System.out.println("--Imprima em Ordem de inserção--\t");
        Set<Serie> minhasSeriesOrdemInsercao = new LinkedHashSet<>();
        minhasSeriesOrdemInsercao.add(new Serie("got",             "fantasia", 60));
        minhasSeriesOrdemInsercao.add(new Serie("dark",            "drama",    60));
        minhasSeriesOrdemInsercao.add(new Serie("that '70s show",  "comedia",  25));
        System.out.println("Series em ordem de inserção: "+minhasSeriesOrdemInsercao);


        System.out.println("--Imprima em Ordem Natural--\t");
        Set<Serie> minhasSeriesOrdenadas = new TreeSet<>(minhasSeries);
        System.out.println("minhas series em ordem natural: "+minhasSeriesOrdenadas); //dá erro até implementar a comparable na classe série para mostrar ao java como que ele pode definir quem é maior+1, menor-1 e igual 0

        //outra maneira com o uso do comparator
        System.out.println("--Imprima usando o Comparator--");
        Set<Serie> minhasSeriesComComparator = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
        minhasSeriesComComparator.addAll(minhasSeries);
        System.out.println("minhasSeriesComComparator: "+minhasSeriesComComparator);

        //outra maneira com o uso do comparing e thenComparing
        System.out.println("--Imprima usando o comparing e thenComparing--");
        Set<Serie> minhasSeriesComComparingThenComparing = new TreeSet<>(Comparator.comparing(Serie::getTempoEpisodio).thenComparing(Serie::getGenero).thenComparing(Serie::getNome));
        minhasSeriesComComparator.addAll(minhasSeries);
        System.out.println("minhasSeriesComComparator: "+minhasSeriesComComparator);
    }



}
class Serie implements Comparable<Serie>{
     private String nome ;
     private String genero;
    private Integer tempoEpisodio;

    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return Objects.equals(nome, serie.nome) && Objects.equals(genero, serie.genero) && Objects.equals(tempoEpisodio, serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    @Override
    public String toString() {
        return "\n"+ nome + " - " + genero +" - " + tempoEpisodio ;
    }

    @Override
    public int compareTo(Serie serie) {
        //como se trata de conjuntos se tivermos 2 números de tempo iguais o segundo sobrescreve o primeiro
        int tempoDoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
        if (tempoDoEpisodio !=0) return  tempoDoEpisodio;
        return this.getGenero().compareTo(serie.getGenero());
    }
}
class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareToIgnoreCase(s2.getNome());
        if (nome !=0) return nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero !=0) return genero;

        return  Integer.compare(s1.getTempoEpisodio(),s2.getTempoEpisodio());// veja que o compare() é usado em Integer e entre números usamos o compareTo(), mas aparentemente dá pra usar qlq um dos dois compare(elem1,elem2) e elem1.compareTo(elem2)
    }
}