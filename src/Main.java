import EquipeDeResgate.OperadorUsuario;
import java.util.Scanner;

/**
 *
 * @author Nicolas Martins, Ana Bautzer, Cauã Bertini, Nicolas Frazão, Eduardo Lima
 * @version 1.2
 * @since 1.0
 */

public class Main {
    public static void main(String[] args){
     Scanner sc = new Scanner(System.in);

        OperadorUsuario operadorUsuario = new OperadorUsuario();
        System.out.println("Digite o nome: ");
        operadorUsuario.setNome(sc.nextLine());
        System.out.println("Digite o CPF: ");
        operadorUsuario.setCpf(sc.nextLine());
        System.out.println("Digite a data de nascimento: ");
        operadorUsuario.setDataNascimento(null);
        System.out.println(operadorUsuario);
    }
}
