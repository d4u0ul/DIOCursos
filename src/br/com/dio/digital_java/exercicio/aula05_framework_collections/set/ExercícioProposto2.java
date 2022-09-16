package br.com.dio.digital_java.exercicio.aula05_framework_collections.set;

import java.util.*;

public class ExercícioProposto2 {
    public static void main(String[] args) {
        //##Crie uma classe LinguagemFavorita que possua os atributos
        //nome, anoDeCriacao e ide. Em seguida, crie um conjunto com
        //3 linguagens e faça um programa que ordene esse conjunto
        //por:
        Set<LinguagemFavorita> linguagensFavoritas = new HashSet<>(){{
           add(new LinguagemFavorita("Java",90,"Intellij"));
           add(new LinguagemFavorita("Python",99,"Pycharm"));
           add(new LinguagemFavorita("Kotlin",8,"Eclipse"));

        }};
        System.out.println("linguagensFavoritas: "+linguagensFavoritas);
        //Ordem de Inserção
        Set<LinguagemFavorita> linguagensFavoritasPorInsercao = new LinkedHashSet<>();
        linguagensFavoritasPorInsercao.add(new LinguagemFavorita("Java",90,"Intellij"));
        linguagensFavoritasPorInsercao.add(new LinguagemFavorita("Python",99,"Pycharm"));
        linguagensFavoritasPorInsercao.add(new LinguagemFavorita("Kotlin",8,"Eclipse"));

        System.out.println("linguagensFavoritasPorInsercao:"+linguagensFavoritasPorInsercao);
        //Ordem Natural (nome)
        Set<LinguagemFavorita> linguagensFavoritasPorOrdemNome = new TreeSet<>(linguagensFavoritasPorInsercao);
        System.out.println("linguagensFavoritasPorNome:"+linguagensFavoritasPorOrdemNome);

        // IDE
        Set<LinguagemFavorita> linguagensFavoritasPorIde = new TreeSet<>(new ComparatorIde());
        linguagensFavoritasPorIde.addAll(linguagensFavoritas);
        System.out.println("LinhguagensFavoritasPorIde: "+linguagensFavoritasPorIde);
        //Ano de criação e nome
        Set<LinguagemFavorita> linguagensFavoritasPorCriacaoNome = new TreeSet<>(Comparator.comparing(LinguagemFavorita::getAnoDeCriacao).thenComparing(LinguagemFavorita::getNome));
        linguagensFavoritasPorCriacaoNome.addAll(linguagensFavoritas);
        System.out.println("linguagensFavoritasPorCriacaoNome: "+linguagensFavoritasPorCriacaoNome);
        //Nome, ano de criacao e IDE
        Set<LinguagemFavorita> linguagensFavoritasNomeAnoIde = new TreeSet<>(Comparator.comparing(LinguagemFavorita::getNome).thenComparing(LinguagemFavorita::getAnoDeCriacao).thenComparing(LinguagemFavorita::getIde));
        linguagensFavoritasNomeAnoIde.addAll(linguagensFavoritas);
        System.out.println("linguagensFavoritasNomeAnoIde: "+linguagensFavoritasNomeAnoIde);
        //Ao final, exiba as linguagens no console, um abaixo da outra.
        Iterator<LinguagemFavorita> iterator = linguagensFavoritasNomeAnoIde.iterator();
        while (iterator.hasNext()){
            LinguagemFavorita next = iterator.next();
            System.out.println(next);
        }
    }
}
class LinguagemFavorita implements Comparable<LinguagemFavorita>{
    private String nome;
    private Integer anoDeCriacao;
    private String ide;

    public LinguagemFavorita(String nome, Integer anoDeCriacao, String ide) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public String getIde() {
        return ide;
    }

    @Override
    public String toString() {
        return "\nLinguagemFavorita: " + nome + " - " + anoDeCriacao + " - " + ide ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinguagemFavorita that = (LinguagemFavorita) o;
        return Objects.equals(nome, that.nome) && Objects.equals(anoDeCriacao, that.anoDeCriacao) && Objects.equals(ide, that.ide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoDeCriacao, ide);
    }

    @Override
    public int compareTo(LinguagemFavorita o) {
        return this.getNome().compareTo(o.getNome());
    }
}
class ComparatorAnoNome implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        Integer anoDeCriacao = Integer.compare(o1.getAnoDeCriacao(),o2.getAnoDeCriacao());
        if (anoDeCriacao != 0) return anoDeCriacao;
        return o1.getNome().compareTo(o2.getNome());
    }
}

class ComparatorIde implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        return o1.getIde().compareTo(o2.getIde());
    }
}
