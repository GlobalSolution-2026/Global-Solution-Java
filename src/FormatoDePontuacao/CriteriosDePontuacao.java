package FormatoDePontuacao;

import CondicoesDeMissao.Vitima;

public class CriteriosDePontuacao extends Vitima implements Penalidades {
    private int decisoesOperador;
    private int gravidade, urgencia;
    private double multiplicadorTerreno, multiplicadorClima;
    private final double riscoCenario;
    private final double pontuacaoFinal;

    public CriteriosDePontuacao(String nomeRegiao, String coordenadasGPS, String tipoDoTerreno, String sinalComunicacao, String identificacao, int qtdPessoas, EstadoInicialSaude estadoInicialSaude, FaixaEtaria faixaEtaria, OrigemNotificacao origemNotificacao, int riscoCenario, int decisoesOperador, double pontuacaoFinal, int gravidade, int urgencia, double multiplicadorClima, double multiplicadorTerreno) {
        super(nomeRegiao, coordenadasGPS, tipoDoTerreno, sinalComunicacao, identificacao, qtdPessoas, estadoInicialSaude, faixaEtaria, origemNotificacao);
        this.riscoCenario = (gravidade + urgencia) * multiplicadorTerreno * multiplicadorClima;
        this.decisoesOperador = decisoesOperador;
        this.pontuacaoFinal = (riscoCenario * 0.40) + (decisoesOperador * 0.60);
        this.gravidade = gravidade;
        this.urgencia = urgencia;
        this.multiplicadorClima = multiplicadorClima;
        this.multiplicadorTerreno = multiplicadorTerreno;
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
        if (getNivelPrecipitacao().equals(nivelPrecipitacao.Sem_Chuva)) {
            this.multiplicadorClima = 1;
        } else if (getNivelPrecipitacao().equals(nivelPrecipitacao.Leve)) {
            this.multiplicadorClima = 1.2;
        } else if (getNivelPrecipitacao().equals(nivelPrecipitacao.Moderada)) {
            this.multiplicadorClima = 1.5;
        } else if (getNivelPrecipitacao().equals(nivelPrecipitacao.Intensa)) {
            this.multiplicadorClima = 2.0;
        }
        if (getVisibilidade().equals(Visibilidade.Alta)) {
            this.multiplicadorClima = multiplicadorClima + 0.3;
        }

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

    @Override
    public String toString() {
        return "Risco de cenário: " + riscoCenario +
                "\nDecisões do operador: " + decisoesOperador +
                "\nPontuação final: " + pontuacaoFinal;
    }

    @Override
    public double PenalidadeOperador() {
        return 0;
    }

    @Override
    public double PenalidadeVitima() {
        return 0;
    }

    @Override
    public double PenalidadeTecnologia() {
        return 0;
    }

    @Override
    public double PenalidadeEquipe() {
        return 0;
    }
}
//FALTA  PENALIDADES