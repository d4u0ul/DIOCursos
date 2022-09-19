package br.com.dio.digital_java.exercicio.aula6_orientacao_a_objetos;

public class ExercicioProposto {
    public static void main(String[] args) {
        Funcionario f = new Funcionario();
        Gerente g =(Gerente) new Funcionario();
        Funcionario f2 = new Gerente("Adauto",12.0);
        Funcionario f3 = new Venderdor();
        Funcionario f4 = new Faxineiro();

    }
}
class Funcionario{
    String nome;
    Double salario;

    public Funcionario(String nome, Double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public Funcionario() {
    }

    public void metF(){
        System.out.println("MetF");
    }
}
class Gerente extends Funcionario{

    public Gerente(String nome, Double salario) {
        super(nome, salario);
    }

    public Gerente() {
    }
}
class Venderdor extends Funcionario{
    public Venderdor() {
    }
}
class Faxineiro extends Funcionario{
    public Faxineiro() {
    }
}