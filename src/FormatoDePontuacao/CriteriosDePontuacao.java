package FormatoDePontuacao;

public class CriteriosDePontuacao extends Penalidades {
    private int riscoCenario, decisoesOperador, pontuacaoFinal;

    public CriteriosDePontuacao(double penalidadeOperador, double penalidadeVitima, double penalidadeTecnologia,
                                double penalidadeEquipe, int riscoCenario, int decisoesOperador, int pontuacaoFinal) {
        super(penalidadeOperador, penalidadeVitima, penalidadeTecnologia, penalidadeEquipe);
        this.riscoCenario = riscoCenario;
        this.decisoesOperador = decisoesOperador;
        this.pontuacaoFinal = pontuacaoFinal;
    }

    public int getRiscoCenario() {
        return riscoCenario;
    }
    public void setRiscoCenario(int riscoCenario) {
        this.riscoCenario = riscoCenario;
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
    public void setPontuacaoFinal(int pontuacaoFinal) {
        this.pontuacaoFinal = pontuacaoFinal;
    }

    @Override
    public String toString() {
        return "Risco de cenário: " + riscoCenario +
                "\nDecisões do operador: " + decisoesOperador +
                "\nPontuação final: " + pontuacaoFinal;
    }
}