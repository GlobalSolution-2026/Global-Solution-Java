import CondicoesDeMissao.CondicoesMetereologica;
import CondicoesDeMissao.Regiao;
import CondicoesDeMissao.Vitima;
import Equipe.EquipeDeResgate;
import Equipe.OperadorUsuario;
import FormatoDePontuacao.CriteriosDePontuacao;

/**
 * @author Nicolas Martins, Ana Bautzer, Cauã Bertini, Nicolas Frazão, Eduardo Lima
 * @version 3.0
 * @since 1.0
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("========== DADOS DO OPERADOR ==========");
        OperadorUsuario operador = new OperadorUsuario();
        operador.setNome();
        operador.setCpf();
        operador.setDataNascimento();
        System.out.println("\n--- Operador registrado ---");


        System.out.println("\n========== DADOS DA MISSÃO ==========");

        System.out.println("\n-- Condições Meteorológicas --");
        CondicoesMetereologica clima = new CondicoesMetereologica();
        clima.setTemperatura();
        clima.setVisibilidade();
        clima.setNivelPrecipitacao();
        clima.setVelocidadeVento();

        System.out.println("\n-- Dados da Região --");
        Regiao regiao = new Regiao();
        regiao.setNomeRegiao();
        regiao.setCoordenadasGPS();
        regiao.setTipoDoTerreno();
        regiao.setSinalComunicacao();

        System.out.println("\n-- Dados da Vítima --");
        Vitima vitima = new Vitima();
        vitima.setQtdPessoas();
        vitima.setEstadoInicialSaude();
        vitima.setFaixaEtaria();
        vitima.setOrigemNotificacao();

        System.out.println("\n========== DADOS DA EQUIPE DE RESGATE ==========");
        EquipeDeResgate equipe = new EquipeDeResgate();
        equipe.setNomeEquipe();
        equipe.setEspecialidade();
        equipe.setQtdAgentesEnviados();
        equipe.statusDeDisponibilidade();
        equipe.nomeTecnologia();
        System.out.println("\n--- Equipe registrada ---");


        System.out.println("\n========== PONTUAÇÃO DA MISSÃO ==========");
        CriteriosDePontuacao pontuacao = new CriteriosDePontuacao(vitima, regiao, clima, equipe, operador);

        System.out.println("\n--- Possíveis perdas ---");
        vitima.setQtdPessoasResgatadas();
        equipe.setQtdAgentesRetornaram();
        equipe.setQtdTecnologiasRetornaram();

        System.out.println("\n--- Resultado da pontuação ---");
        System.out.println(pontuacao);

        System.out.println("\n--- Penalidades ---");
        System.out.println(pontuacao.penalidadesToString());

        double pontuacaoComPenalidades = pontuacao.getPontuacaoFinal()
                + pontuacao.penalidadeVitima()
                + pontuacao.penalidadeTecnologia()
                + pontuacao.penalidadeEquipe();

        System.out.println("\nPontuação Final com Penalidades: " + String.format("%.2f", pontuacaoComPenalidades));
    }
}
