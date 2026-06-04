package FormatoDePontuacao;

public interface Penalidades {

    double penalidadeOperador();

    double penalidadeVitima();

    double penalidadeTecnologia();

    double penalidadeEquipe();

    default String penalidadesToString() {
        return "Penalidade de Operador: " + penalidadeOperador() +
                "\nPenalidade de Vítima: " + penalidadeVitima() +
                "\nPenalidade de Tecnologia: " + penalidadeTecnologia() +
                "\nPenalidade de Equipe de Resgate: " + penalidadeEquipe();
    }
}
