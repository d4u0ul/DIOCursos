package br.com.dio.digital_java.exercicio.aula08_excecoes;

import javax.swing.*;

public class UncheckedExceptions
{
    public static void main(String[] args) {
        boolean contiuneLooping=true;
        do{
            String a = JOptionPane.showInputDialog("Numerador: ");
            String b = JOptionPane.showInputDialog("Denominador: ");
            try{
                Double resultado = dividir(Integer.parseInt(a), Integer.parseInt(b));
                System.out.println("Resultado: "+resultado );
                contiuneLooping = false;

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada Inválida");
                e.printStackTrace();
            }
            catch (ArithmeticException e) {
                JOptionPane.showMessageDialog(null, "Número errado");
                e.printStackTrace();
            }finally {
                System.out.println("finally");
            }
        }while(contiuneLooping);
        System.out.println("Chegou ao final");
    }

    private static Double dividir(int parseInt, int parseInt1) {
        return ( (double)parseInt /  (double)parseInt1);
    }
}
