package FormatoDePontuacao;

public interface Penalidades {

    double PenalidadeOperador();

    double PenalidadeVitima();

    double PenalidadeTecnologia();

    double PenalidadeEquipe();

    default String penalidadesToString() {
        return "Penalidades de Operador: " + PenalidadeOperador() +
                "\nPenalidade de Vitima: " + PenalidadeVitima() +
                "\nPenalidade de Tecnologia: " + PenalidadeTecnologia() +
                "\nPenalidade de equipe de resgate: " + PenalidadeEquipe();
    }
}