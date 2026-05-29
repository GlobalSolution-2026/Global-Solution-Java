package FormatoDePontuacao;

public abstract class Penalidades {
    private double penalidadeOperador, penalidadeVítima, penalidadeTecnologia, penalidadeEquipe;

    public Penalidades(double penalidadeOperador, double penalidadeVítima, double penalidadeTecnologia, double penalidadeEquipe) {
        this.penalidadeOperador = penalidadeOperador;
        this.penalidadeVítima = penalidadeVítima;
        this.penalidadeTecnologia = penalidadeTecnologia;
        this.penalidadeEquipe = penalidadeEquipe;
    }

    public double getPenalidadeOperador() {
        return penalidadeOperador;
    }

    public void setPenalidadeOperador(double penalidadeOperador) {
        this.penalidadeOperador = penalidadeOperador;
    }

    public double getPenalidadeVítima() {
        return penalidadeVítima;
    }

    public void setPenalidadeVítima(double penalidadeVítima) {
        this.penalidadeVítima = penalidadeVítima;
    }

    public double getPenalidadeTecnologia() {
        return penalidadeTecnologia;
    }

    public void setPenalidadeTecnologia(double penalidadeTecnologia) {
        this.penalidadeTecnologia = penalidadeTecnologia;
    }

    public double getPenalidadeEquipe() {
        return penalidadeEquipe;
    }

    public void setPenalidadeEquipe(double penalidadeEquipe) {
        this.penalidadeEquipe = penalidadeEquipe;
    }
    @Override
    public String toString() {
        return "Penalidades de Operador: " + penalidadeOperador +
                "\nPenalidade de Vítima: " + penalidadeVítima +
                "\nPenalidade de Tecnologia: " + penalidadeTecnologia +
                "\nPenalidade de equipe de resgate: " + penalidadeEquipe;
    }
}
