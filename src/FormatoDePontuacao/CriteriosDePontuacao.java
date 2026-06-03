package FormatoDePontuacao;

import CondicoesDeMissao.Vitima;
import EquipeDeResgate.EquipeDeResgate;

public class CriteriosDePontuacao extends Vitima implements Penalidades {


    private final EquipeDeResgate equipeDeResgate;

    private int decisoesOperador;
    private int gravidade;
    private int urgencia;
    private double multiplicadorTerreno;
    private double multiplicadorClima;
    private double taxaAcertoOperador;
    private final double riscoCenario;
    private final double pontuacaoFinal;


    public CriteriosDePontuacao(double temperatura, Visibilidade visibilidade,
                                NivelPrecipitacao nivelPrecipitacao, VelocidadeVento velocidadeVento,
                                String nomeRegiao, String coordenadasGPS,
                                TipoTerreno tipoDoTerreno, SinalComunicacao sinalComunicacao,
                                String identificacao, int qtdPessoas, int qtdPessoasResgatadas,
                                EstadoInicialSaude estadoInicialSaude, FaixaEtaria faixaEtaria,
                                OrigemNotificacao origemNotificacao,
                                double taxaAcertoOperador, double multiplicadorClima,
                                double multiplicadorTerreno, int urgencia, int gravidade,
                                int decisoesOperador, EquipeDeResgate equipeDeResgate) {
        super(temperatura, visibilidade, nivelPrecipitacao, velocidadeVento,
                nomeRegiao, coordenadasGPS, tipoDoTerreno, sinalComunicacao,
                identificacao, qtdPessoas, qtdPessoasResgatadas,
                estadoInicialSaude, faixaEtaria, origemNotificacao);
        this.taxaAcertoOperador = taxaAcertoOperador;
        this.multiplicadorClima = multiplicadorClima;
        this.multiplicadorTerreno = multiplicadorTerreno;
        this.urgencia = urgencia;
        this.gravidade = gravidade;
        this.decisoesOperador = decisoesOperador;
        this.equipeDeResgate = equipeDeResgate;
        this.riscoCenario = (gravidade + urgencia) * multiplicadorTerreno * multiplicadorClima;
        this.pontuacaoFinal = (this.riscoCenario * 0.40) + (decisoesOperador * 0.60);
    }


    public int getGravidade() {
        return gravidade;
    }

    public void setGravidade(int gravidade) {
        if (getEstadoInicialSaude().equals(EstadoInicialSaude.Estavel)) {
            this.gravidade = 1;
        } else if (getEstadoInicialSaude().equals(EstadoInicialSaude.Grave)) {
            this.gravidade = 2;
        } else if (getEstadoInicialSaude().equals(EstadoInicialSaude.Risco_De_Vida)) {
            this.gravidade = 3;
        }
    }

    public int getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(int urgencia) {
        if (getFaixaEtaria().equals(FaixaEtaria.Adulta)) {
            this.urgencia = 1;
        } else {
            this.urgencia = 2;
        }
    }

    public double getMultiplicadorTerreno() {
        return multiplicadorTerreno;
    }

    public void setMultiplicadorTerreno(double multiplicadorTerreno) {
        if (getTipoDoTerreno().equals(TipoTerreno.URBANO)) {
            this.multiplicadorTerreno = 1.0;
        } else if (getTipoDoTerreno().equals(TipoTerreno.FLORESTA)) {
            this.multiplicadorTerreno = 1.5;
        } else if (getTipoDoTerreno().equals(TipoTerreno.MONTANHA)) {
            this.multiplicadorTerreno = 1.8;
        }
    }

    public double getMultiplicadorClima() {
        return multiplicadorClima;
    }

    public void setMultiplicadorClima(double multiplicadorClima) {
        if (getNivelPrecipitacao().equals(NivelPrecipitacao.Sem_Chuva)) {
            this.multiplicadorClima = 1.0;
        } else if (getNivelPrecipitacao().equals(NivelPrecipitacao.Leve)) {
            this.multiplicadorClima = 1.2;
        } else if (getNivelPrecipitacao().equals(NivelPrecipitacao.Moderada)) {
            this.multiplicadorClima = 1.5;
        } else if (getNivelPrecipitacao().equals(NivelPrecipitacao.Intensa)) {
            this.multiplicadorClima = 2.0;
        }
        if (getVisibilidade().equals(Visibilidade.Alta)) {
            this.multiplicadorClima = this.multiplicadorClima + 0.3;
        }
    }

    public double getTaxaAcertoOperador() {
        return taxaAcertoOperador;
    }

    public double getRiscoCenario() {
        return riscoCenario;
    }

    public int getDecisoesOperador() {
        return decisoesOperador;
    }

    public void setDecisoesOperador(int decisoesOperador) {
        this.decisoesOperador = decisoesOperador;
    }

    public double getPontuacaoFinal() {
        return pontuacaoFinal;
    }

    public EquipeDeResgate getEquipeDeResgate() {
        return equipeDeResgate;
    }

    @Override
    public String toString() {
        return "Risco de cenário: " + riscoCenario +
                "\nDecisões do operador: " + decisoesOperador +
                "\nPontuação final: " + pontuacaoFinal;
    }

    @Override
    public double PenalidadeOperador() {
        if (taxaAcertoOperador >= 80) return 0.0;
        else if (taxaAcertoOperador >= 60) return -5.0;
        else if (taxaAcertoOperador >= 40) return -10.0;
        else return -20.0;
    }

    @Override
    public double PenalidadeVitima() {
        int perdas = getQtdPessoas() - getQtdPessoasResgatadas();
        return perdas * -10.0;
    }

    @Override
    public double PenalidadeTecnologia() {
        int perdas = equipeDeResgate.getQtdTecnologias() - equipeDeResgate.getQtdTecnologiasRetornaram();
        return perdas * -5.0;
    }

    @Override
    public double PenalidadeEquipe() {
        int perdas = equipeDeResgate.getQtdAgentesEnviados() - equipeDeResgate.getQtdAgentesRetornaram();
        return perdas * -15.0;
    }
}