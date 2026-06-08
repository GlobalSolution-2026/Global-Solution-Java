package FormatoDePontuacao;

import CondicoesDeMissao.CondicoesMetereologica;
import CondicoesDeMissao.Regiao;
import CondicoesDeMissao.Vitima;
import Equipe.EquipeDeResgate;
import Equipe.OperadorUsuario;

public class CriteriosDePontuacao implements Penalidades {

    private Vitima vitima;
    private CondicoesMetereologica condicoesMetereologica;
    private Regiao regiao;
    private EquipeDeResgate equipeDeResgate;
    private OperadorUsuario operador;
    private int gravidade;
    private int urgencia;
    private double multiplicadorTerreno;
    private double multiplicadorClima;
    private double riscoCenario;
    private double pontuacaoFinal;


    public CriteriosDePontuacao(Vitima vitima, Regiao regiao,
                                CondicoesMetereologica condicoesMetereologica,
                                EquipeDeResgate equipeDeResgate, OperadorUsuario operador) {
        this.vitima = vitima;
        this.regiao = regiao;
        this.condicoesMetereologica = condicoesMetereologica;
        this.equipeDeResgate = equipeDeResgate;
        this.operador = operador;
        calcularGravidade();
        calcularUrgencia();
        calcularMultiplicadorTerreno();
        calcularMultiplicadorClima();
        this.riscoCenario = (gravidade + urgencia) * (multiplicadorTerreno + multiplicadorClima);
        this.pontuacaoFinal = riscoCenario;
    }

    private void calcularGravidade() {
        String saude = vitima.getEstadoInicialSaude();
        if (saude.equals("Estavel")) {
            this.gravidade = 1;
        } else if (saude.equals("Grave")) {
            this.gravidade = 2;
        } else {
            this.gravidade = 3;
        }
    }

    private void calcularUrgencia() {
        String faixa = vitima.getFaixaEtaria();
        if (faixa.equals("Adulta")) {
            this.urgencia = 1;
        } else {
            this.urgencia = 2;
        }
    }

    private void calcularMultiplicadorTerreno() {
        String terreno = regiao.getTipoDoTerreno();
        if (terreno.equals("Urbano")) {
            this.multiplicadorTerreno = 10.0;
        } else if (terreno.equals("Floresta")) {
            this.multiplicadorTerreno = 15.0;
        } else {
            this.multiplicadorTerreno = 18.0;
        }
    }

    private void calcularMultiplicadorClima() {
        String precipitacao = condicoesMetereologica.getNivelPrecipitacao();
        if (precipitacao.equals("Sem_Chuva")) {
            this.multiplicadorClima = 10.0;
        } else if (precipitacao.equals("Leve")) {
            this.multiplicadorClima = 12.0;
        } else if (precipitacao.equals("Moderada")) {
            this.multiplicadorClima = 15.0;
        } else {
            this.multiplicadorClima = 20.0;
        }

        if (condicoesMetereologica.getVisibilidade().equals("Alta")) {
            this.multiplicadorClima += 0.3;
        }
    }


    public int getGravidade() { return gravidade; }
    public int getUrgencia() { return urgencia; }
    public double getMultiplicadorTerreno() { return multiplicadorTerreno; }
    public double getMultiplicadorClima() { return multiplicadorClima; }
    public double getRiscoCenario() { return riscoCenario; }
    public double getPontuacaoFinal() { return pontuacaoFinal; }
    public Vitima getVitima() { return vitima; }
    public EquipeDeResgate getEquipeDeResgate() { return equipeDeResgate; }
    public OperadorUsuario getOperador() { return operador; }


    @Override
    public double penalidadeOperador() {
        return 0.0;
    }

    @Override
    public double penalidadeVitima() {
        int perdas = vitima.getQtdPessoas() - vitima.getQtdPessoasResgatadas();
        return perdas * -10.0;
    }

    @Override
    public double penalidadeTecnologia() {
        int perdas = equipeDeResgate.getQtdTecnologias() - equipeDeResgate.getQtdTecnologiasRetornaram();
        return perdas * -5.0;
    }

    @Override
    public double penalidadeEquipe() {
        int perdas = equipeDeResgate.getQtdAgentesEnviados() - equipeDeResgate.getQtdAgentesRetornaram();
        return perdas * -15.0;
    }

    @Override
    public String toString() {
        return "Gravidade: " + gravidade +
                "\nUrgência: " + urgencia +
                "\nMultiplicador de Terreno: " + multiplicadorTerreno +
                "\nMultiplicador de Clima: " + multiplicadorClima +
                "\nRisco de Cenário: " + String.format("%.2f", riscoCenario) +
                "\nPontuação Final: " + String.format("%.2f", pontuacaoFinal);
    }
}
