package FormatoDePontuacao;

public abstract class Penalidades {
    private double penalidadeOperador, penalidadeVitima, penalidadeTecnologia, penalidadeEquipe;

    public Penalidades(double penalidadeOperador, double penalidadeVitima, double penalidadeTecnologia, double penalidadeEquipe) {
        this.penalidadeOperador = penalidadeOperador;
        this.penalidadeVitima = penalidadeVitima;
        this.penalidadeTecnologia = penalidadeTecnologia;
        this.penalidadeEquipe = penalidadeEquipe;
    }

    public double getPenalidadeOperador() {
        return penalidadeOperador;
    }
    public void setPenalidadeOperador(double penalidadeOperador) {
        this.penalidadeOperador = penalidadeOperador;
    }
    public double getPenalidadeVitima() {
        return penalidadeVitima;
    }
    public void setPenalidadeVitima(double penalidadeVitima) {
        this.penalidadeVitima = penalidadeVitima;
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
                "\nPenalidade de Vitima: " + penalidadeVitima +
                "\nPenalidade de Tecnologia: " + penalidadeTecnologia +
                "\nPenalidade de equipe de resgate: " + penalidadeEquipe;
    }
}