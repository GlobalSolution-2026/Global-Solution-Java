import CondicoesDeMissao.Vitima;
import EquipeDeResgate.EquipeDeResgate;
import EquipeDeResgate.OperadorUsuario;
import FormatoDePontuacao.CriteriosDePontuacao;
import EquipeDeResgate.Missao;

import java.util.Scanner;

/**
 * @author Nicolas Martins, Ana Bautzer, Cauã Bertini, Nicolas Frazão, Eduardo Lima
 * @version 2.0
 * @since 1.0
 */

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("========== DADOS DO OPERADOR ==========");
        OperadorUsuario operador = new OperadorUsuario();
        operador.setNome();
        operador.setCpf();
        operador.setDataNascimento();
        System.out.println("\n--- Operador registrado ---");


        System.out.println("\n========== DADOS DA MISSÃO ==========");
        Vitima vitima = new Vitima();
        Missao missao = new Missao();

        missao.setDataAcionamento();
        System.out.println("\n-- Condições Meteorológicas --");
        vitima.setTemperatura();
        vitima.setVisibilidade();
        vitima.setNivelPrecipitacao();
        vitima.setVelocidadeVento();


        System.out.println("\n-- Dados da Região --");
        vitima.setNomeRegiao();
        vitima.setCoordenadasGPS();
        vitima.setTipoDoTerreno();
        vitima.setSinalComunicacao();

        System.out.println("\n-- Dados da Vítima --");
        vitima.setIdentificacao();
        vitima.setQtdPessoas();

        vitima.setEstadoInicialSaude();
        vitima.setFaixaEtaria();
        vitima.setOrigemNotificacao();

        System.out.println("\n========== DADOS DA EQUIPE DE RESGATE ==========");
        EquipeDeResgate equipe = new EquipeDeResgate();
        equipe.setNomeEquipe();
        equipe.setEspecialidade();
        equipe.setTempoDeResposta();
        equipe.setQtdAgentesEnviados();

        equipe.statusDeDisponibilidade();
        equipe.nomeTecnologia();
        System.out.println("\n--- Equipe registrada ---");


        System.out.println("\n========== PONTUAÇÃO DA MISSÃO ==========");
        CriteriosDePontuacao pontuacao = new CriteriosDePontuacao(vitima, equipe, operador);

        System.out.println("Digite a quantidade de decisões corretas do operador durante a missão: ");
        int decisoes = Integer.parseInt(sc.nextLine().trim());
        pontuacao.setDecisoesOperador(decisoes); // ← move pra cá

        System.out.println("\n--- Possíveis perdas --- ");
        vitima.setQtdPessoasResgatadas();
        equipe.setQtdAgentesRetornaram();
        equipe.setQtdTecnologiasRetornaram();

        operador.setTaxaAcerto(); // ← antes das penalidades

        System.out.println("\n--- Acertividade e resultado da pontuação ---");
        System.out.println(pontuacao);

        System.out.println("\n--- Penalidades ---");
        System.out.println(pontuacao.penalidadesToString());

        double pontuacaoComPenalidades = pontuacao.getPontuacaoFinal()
                + pontuacao.penalidadeOperador()
                + pontuacao.penalidadeVitima()
                + pontuacao.penalidadeTecnologia()
                + pontuacao.penalidadeEquipe();

        System.out.println("\nPontuação Final com Penalidades: " + String.format("%.2f", pontuacaoComPenalidades));
    }
}
