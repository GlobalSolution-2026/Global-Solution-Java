import CondicoesDeMissao.Vitima;
import EquipeDeResgate.EquipeDeResgate;
import EquipeDeResgate.OperadorUsuario;
import FormatoDePontuacao.CriteriosDePontuacao;

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
        operador.setTaxaAcerto();
        operador.setDataNascimento();
        System.out.println("\n--- Operador registrado ---");
        System.out.println(operador);

        System.out.println("\n========== DADOS DA MISSÃO ==========");
        Vitima vitima = new Vitima();

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
        vitima.setQtdPessoasResgatadas();
        vitima.setEstadoInicialSaude();
        vitima.setFaixaEtaria();
        vitima.setOrigemNotificacao();

        System.out.println("\n--- Dados da missão registrados ---");
        System.out.println(vitima);

        System.out.println("\n========== DADOS DA EQUIPE DE RESGATE ==========");
        EquipeDeResgate equipe = new EquipeDeResgate();
        equipe.setNomeEquipe();
        equipe.setEspecialidade();
        equipe.setTempoDeResposta();
        equipe.setQtdAgentesEnviados();
        equipe.setQtdAgentesRetornaram();
        equipe.statusDeDisponibilidade();
        equipe.nomeTecnologia();
        equipe.setQtdTecnologiasRetornaram();

        System.out.println("\n--- Equipe registrada ---");
        System.out.println(equipe);

        System.out.println("\n========== PONTUAÇÃO DA MISSÃO ==========");
        CriteriosDePontuacao pontuacao = new CriteriosDePontuacao(vitima, equipe, operador);

        System.out.println("Digite a quantidade de decisões corretas do operador durante a missão: ");
        int decisoes = Integer.parseInt(sc.nextLine().trim());
        pontuacao.setDecisoesOperador(decisoes);

        System.out.println("\n--- Resultado da pontuação ---");
        System.out.println(pontuacao);

        System.out.println("\n--- Penalidades ---");
        System.out.println(pontuacao.penalidadesToString());

        double pontuacaoComPenalidades = pontuacao.getPontuacaoFinal()
                + pontuacao.penalidadeOperador()
                + pontuacao.penalidadeVitima()
                + pontuacao.penalidadeTecnologia()
                + pontuacao.penalidadeEquipe();

        System.out.println("\nPontuação Final com Penalidades: " + pontuacaoComPenalidades);

        sc.close();
    }
}
