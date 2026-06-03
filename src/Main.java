import EquipeDeResgate.OperadorUsuario;
import java.util.Scanner;

/**
 *
 * @author Nicolas Martins, Ana Bautzer, Cauã Bertini, Nicolas Frazão, Eduardo Lima
 * @version 1.3
 * @since 1.0
 */

public class Main {
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       OperadorUsuario operador = new OperadorUsuario();


        System.out.println("""
========== DADOS DE OPERADOS ==========
                """);
        System.out.println("Digite o nome do operador: ");
        operador.setNome(sc.nextLine());
        System.out.println("Digite CPF do operador: ");
        operador.setCpf(sc.nextLine());
        System.out.println("Digite a Data de nascimento do operador: ");
        operador.setDataNascimento(null);
        System.out.println(operador);
        System.out.println("Informações de Operador coletadas com sucesso!");

        System.out.println("""
========== INFORMAÇÕES GERAIS DE MISSÃO ==========
                """);
        System.out.println("Informe o nível de visibilidade: "
        + "Baixa, Moderada, Alta");
        String visibilidade = sc.nextLine();
    }

}
