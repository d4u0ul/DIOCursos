package br.com.dio.digital_java.exercicio.aula3_controle_de_fluxo;

public class PlanoOPeradora {
    public static void main(String[] args) {
        String plano = "M";
        //quando não colocamos o break o códigocontinua passando pelos cases
        switch (plano){
            case "T":{
                System.out.println("5 gb youtube");
            }case "M":{
                System.out.println("whats e insta");
            }case "B":{
                System.out.println("100 min lig");
                break;
                //para não mostrar o default
            }
            default:
                System.out.println("indefinido");
        }
    }
}
