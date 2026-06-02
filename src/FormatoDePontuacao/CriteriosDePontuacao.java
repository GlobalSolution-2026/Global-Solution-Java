package FormatoDePontuacao;

import CondicoesDeMissao.Vitima;

public class CriteriosDePontuacao extends Vitima implements Penalidades {
    private int riscoCenario;
    private int decisoesOperador, pontuacaoFinal;
    private int gravidade, urgencia, multiplicadorClima;
    private double multiplicadorTerreno;

    public CriteriosDePontuacao(String nomeRegiao, String coordenadasGPS, String tipoDoTerreno, String sinalComunicacao, String identificacao, int qtdPessoas, EstadoInicialSaude estadoInicialSaude, FaixaEtaria faixaEtaria, OrigemNotificacao origemNotificacao, int riscoCenario, int decisoesOperador, int pontuacaoFinal, int gravidade, int urgencia, int multiplicadorClima, double multiplicadorTerreno) {
        super(nomeRegiao, coordenadasGPS, tipoDoTerreno, sinalComunicacao, identificacao, qtdPessoas, estadoInicialSaude, faixaEtaria, origemNotificacao);
        this.riscoCenario = riscoCenario;
        this.decisoesOperador = decisoesOperador;
        this.pontuacaoFinal = pontuacaoFinal;
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
            gravidade = 1;
        } else if (getEstadoInicialSaude().equals(EstadoInicialSaude.Grave)) {
            gravidade = 2;
        } else if (getEstadoInicialSaude().equals(EstadoInicialSaude.Risco_De_Vida)) {
            gravidade = 3;
        }
        this.gravidade = gravidade;
    }

    public int getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(int urgencia) {
        if (getFaixaEtaria().equals(FaixaEtaria.Adulta)) {
            urgencia = 1;
        } else {
            urgencia = 2;
        }
        this.urgencia = urgencia;
    }

    public double getMultiplicadorTerreno() {
        return multiplicadorTerreno;
    }

    public void setMultiplicadorTerreno(double multiplicadorTerreno) {
        if (getTipoDoTerreno().equals(TipoTerreno.URBANO)) {
            multiplicadorTerreno = 1.0;
        } else if (getTipoDoTerreno().equals(TipoTerreno.FLORESTA)) {
            multiplicadorTerreno = 1.5;
        } else if (getTipoDoTerreno().equals(TipoTerreno.MONTANHA)) {
            multiplicadorTerreno = 1.8;
        }
        this.multiplicadorTerreno = multiplicadorTerreno;
    }

    public int getMultiplicadorClima() {
        return multiplicadorClima;
    }

    public void setMultiplicadorClima(int multiplicadorClima) {
        this.multiplicadorClima = multiplicadorClima;
    }

    public int getRiscoCenario() {
        return riscoCenario;
    }

    public int getDecisoesOperador() {
        return decisoesOperador;
    }

    public void setDecisoesOperador(int decisoesOperador) {
        this.decisoesOperador = decisoesOperador;
    }

    public int getPontuacaoFinal() {
        return pontuacaoFinal;
    }

    @Override
    public String toString() {
        return "Risco de cenário: " + riscoCenario +
                "\nDecisões do operador: " + decisoesOperador +
                "\nPontuação final: " + pontuacaoFinal;
    }

    @Override
    public double getPenalidadeOperador() {
        return 0;
    }

    @Override
    public void setPenalidadeOperador(double penalidadeOperador) {

    }

    @Override
    public double getPenalidadeVitima() {
        return 0;
    }

    @Override
    public void setPenalidadeVitima(double penalidadeVitima) {

    }

    @Override
    public double getPenalidadeTecnologia() {
        return 0;
    }

    @Override
    public void setPenalidadeTecnologia(double penalidadeTecnologia) {

    }

    @Override
    public double getPenalidadeEquipe() {
        return 0;
    }

    @Override
    public void setPenalidadeEquipe(double penalidadeEquipe) {

    }
}
//FALTA CLIMA E AS PENALIDADES