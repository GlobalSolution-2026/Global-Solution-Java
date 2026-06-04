import CondicoesDeMissao.CondicoesMetereologicas;
import CondicoesDeMissao.Regiao;
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
       CondicoesMetereologicas condicoesMetereologicas = new CondicoesMetereologicas();
        Regiao regiao = new Regiao();

        System.out.println("""
========== DADOS DE OPERADOS ==========
                """);
        System.out.println("Digite o nome do operador: ");
        operador.setNome(sc.nextLine());
        System.out.println("Digite CPF do operador: ");
        operador.setCpf(sc.nextLine());
        System.out.println("Digite a Data de nascimento do operador: ");
        System.out.println("\n");
        operador.setDataNascimento(null);
        System.out.println(operador);
        System.out.println("Informações de Operador coletadas com sucesso!");

        System.out.println("""
========== INFORMAÇÕES GERAIS DE MISSÃO ==========
                """);
        condicoesMetereologicas.setVisibilidade();
        condicoesMetereologicas.setNivelPrecipitacao();
        System.out.println(condicoesMetereologicas);

        System.out.println("""
========== INFORMAÇÕES DE REGIÃO ==========
                """);


    }

}
