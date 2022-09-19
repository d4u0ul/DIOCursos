package br.com.dio.digital_java.exercicio.aula6_orientacao_a_objetos;

public interface OpMatematica {
    Double soma(Double a, Double b);
    Double subt(Double a, Double b);
    Double mult(Double a, Double b);
    Double divi(Double a, Double b);
}
class Calculadora implements OpMatematica {
    public static void main(String[] args) {
        Calculadora c = new Calculadora();
        System.out.println(c.soma(3.45,5.22));
        System.out.println(c.subt(3.45,5.22));
        System.out.println(c.mult(3.45,5.22));
        System.out.println(c.divi(3.45,5.22));
    }

    @Override
    public Double soma(Double a, Double b) {
        return a+b;
    }

    @Override
    public Double subt(Double a, Double b) {
        return a-b;
    }

    @Override
    public Double mult(Double a, Double b) {
        return a*b;
    }

    @Override
    public Double divi(Double a, Double b) {
        return a/b;
    }
}
