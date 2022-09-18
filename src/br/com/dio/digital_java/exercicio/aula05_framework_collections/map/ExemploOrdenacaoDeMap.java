package br.com.dio.digital_java.exercicio.aula05_framework_collections.map;

import java.util.*;

public class ExemploOrdenacaoDeMap {
    /*
    * Autor "S Hawking"   Livro  "Uma breve historia do tempo"
    * Autor "D Charles"   Livro  "O poder do hábito"
    * Autor "N ahYuval"   Livro  "21 lições para o século 21"
    * */
    public static void main(String[] args) {
        //crie um dicionário de autores e livros e ordene de formaaleatória
        Map<String, Livro> meusLivros = new HashMap<>(){{
            put("S Hawking", new Livro ("Uma breve historia do tempo",256));
            put("D Charles", new Livro ("O poder do hábito",408));
            put("N ahYuval", new Livro ("21 lições para o século 21",432));
        }}  ;
        //para retornar a chave e o valor temos o advento do termo entrySet que retorna um set de elementos do tipo entry que são basicamente cada um dos elementos do seu dict
        Set<Map.Entry<String, Livro>> entries = meusLivros.entrySet();
        for(Map.Entry<String,Livro> entry: entries){
            System.out.println(entry.getKey()+" - "+entry.getValue().getNome());
        }
        System.out.println();
        //imprima agora de acordo com a ordem de inserção
        Map<String,Livro> meusLivrosEmOrdemIsercao = new LinkedHashMap<>();
        meusLivrosEmOrdemIsercao.put("D Charles", new Livro ("O poder do hábito",408));
        meusLivrosEmOrdemIsercao.put("S Hawking", new Livro ("Uma breve historia do tempo",256));
        meusLivrosEmOrdemIsercao.put("N ahYuval", new Livro ("21 lições para o século 21",432));
        Set<Map.Entry<String, Livro>> entries1 = meusLivrosEmOrdemIsercao.entrySet();
        for(Map.Entry<String,Livro> entry : entries1){
            System.out.println(entry.getKey()+" - "+entry.getValue().getNome());
        }
        System.out.println();
        //imprima agora de acordo com a ordem alfabetica dos autores
        Map<String,Livro> meusLivrosOrdemNomeAutor = new TreeMap<>(meusLivrosEmOrdemIsercao);
        Set<Map.Entry<String, Livro>> entries2 = meusLivrosOrdemNomeAutor.entrySet();
        for(Map.Entry<String,Livro> entry : entries2){
            System.out.println(entry.getKey()+" - "+entry.getValue().getNome());
        }
        System.out.println();
        //imprima agora de acordo com a ordem alfabetica dos nomes dos livros
        //como nós estamos lidando com a ordem dos valores do Map precisaremos extrair essa informação via instanciação de um TreeSet com um Comparator e não um TreMap
        Set<Map.Entry<String,Livro>> meusLivrosOrdemNomeLivro = new TreeSet<>(new ComparatorNomeLivro());
        meusLivrosOrdemNomeLivro.addAll(entries2);//Não dá pra passar o Map<String,Livro> pq Map não é uma Collections aqui que entra a vantagem do entrySet() que transforma o nosso Map em um cojunto Set que é uma collectino podemos tbm passar o meusLivrosOrdemNomeAutor.entrySet()
        for(Map.Entry<String,Livro> entry : meusLivrosOrdemNomeLivro){
            System.out.println(entry.getKey()+" - "+entry.getValue().getNome());
        }
        System.out.println();
        //imprima agora de acordo com a ordem do número de páginas
        //Erro Comum - Usar Set<Map<String,Livro>> em vez de Set<Map.Entry<String,Livro>>
        //Set<Map<String,Livro>>  -> instancia um conjunto de Maps
        //Set<Map.Entry<String,Livro>> -> instância um conjunto de elementos do Map <-CORRETO
        Set<Map.Entry<String,Livro>> meusLivrosOrdemPaginas = new TreeSet<>(new ComparatorPaginasLivro());
        meusLivrosOrdemPaginas.addAll(meusLivrosOrdemNomeLivro);
        for(Map.Entry<String,Livro> entry : meusLivrosOrdemPaginas){
            System.out.println(entry.getKey()+" - "+entry.getValue().getNome()+" - "+entry.getValue().getPaginas());
        }
        System.out.println();

        //imprima agora de acordo com a ordem do nome e número de páginas
        Set<Map.Entry<String,Livro>> meusLivrosOrdemNomePag = new TreeSet<>(new ComparatorNomePaginaLivro());
        meusLivrosOrdemNomePag.addAll(meusLivrosOrdemNomeLivro);
        for(Map.Entry<String,Livro> entry : meusLivrosOrdemNomePag){
            System.out.println(entry.getKey()+" - "+entry.getValue().getNome()+" - "+entry.getValue().getPaginas());
        }
        //imprima agora de acordo com a ordem do nomeautor número de páginas e nome e usando o comparing e expressões lambda
        Set<Map.Entry<String,Livro>> meusLivrosOrdemAutorNPaginaNomeLivro = new TreeSet<>(Comparator.comparing(Map.Entry<String,Livro>::getKey).thenComparing((Map.Entry<String, Livro> stringLivroEntry) -> stringLivroEntry.getValue().getPaginas()).thenComparing((Map.Entry<String, Livro> stringLivroEntry) -> stringLivroEntry.getValue().getNome()));

    }
}
class ComparatorNomePaginaLivro implements Comparator<Map.Entry<String,Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> o1, Map.Entry<String, Livro> o2) {
        int nome = o1.getValue().getNome().compareToIgnoreCase(o2.getValue().getNome());
        if(nome !=0) return nome;
        return Integer.compare(o1.getValue().getPaginas(),o2.getValue().getPaginas());
    }
}
class ComparatorPaginasLivro implements Comparator<Map.Entry<String,Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> o1, Map.Entry<String, Livro> o2) {
        return Integer.compare(o1.getValue().getPaginas(),o2.getValue().getPaginas());
    }
}

class ComparatorNomeLivro implements Comparator<Map.Entry<String,Livro>>{


    @Override
    public int compare(Map.Entry<String, Livro> o1, Map.Entry<String, Livro> o2) {
        return o1.getValue().getNome().compareToIgnoreCase(o2.getValue().getNome());
    }
}

class Livro{
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(nome, livro.nome) && Objects.equals(paginas, livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}
