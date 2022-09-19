package br.com.dio.digital_java.exercicio.aula6_orientacao_a_objetos;

public class ExercicioAssociacaoHeranca {
    public static void main(String[] args) {

    }
}

class Endereco{

}

class Pessoa{
    Endereco endereco;//Associação  Estrutural de tipo composiçao
}
class Aluno{
    Disciplina disciplina; // Associação Estrutural de Agregação
}
class Disciplina{
    Aluno aluno; // Associação Estrutural de Agregação
}

class Compra{
    void finalizar(Cupom cupom){// Associação comportamental de dependência
        System.out.println("Cupom Aplicado...");
    };
}
class Cupom{

}

