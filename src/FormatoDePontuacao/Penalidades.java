package FormatoDePontuacao;

public interface Penalidades {

    double getPenalidadeOperador();
    void setPenalidadeOperador(double penalidadeOperador);

    double getPenalidadeVitima();
    void setPenalidadeVitima(double penalidadeVitima);

    double getPenalidadeTecnologia();
    void setPenalidadeTecnologia(double penalidadeTecnologia);

    double getPenalidadeEquipe();
    void setPenalidadeEquipe(double penalidadeEquipe);

    default String penalidadesToString() {
        return "Penalidades de Operador: " + getPenalidadeOperador() +
                "\nPenalidade de Vitima: " + getPenalidadeVitima() +
                "\nPenalidade de Tecnologia: " + getPenalidadeTecnologia() +
                "\nPenalidade de equipe de resgate: " + getPenalidadeEquipe();
    }
}