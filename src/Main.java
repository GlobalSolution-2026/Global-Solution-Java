import CondicoesDeMissao.Regiao;
import EquipeDeResgate.EquipeDeResgate;

/**
 *
 * @author Nicolas Martins, Ana Bautzer, Cauã Bertini, Nicolas Frazão, Eduardo Lima
 * @version 1.0
 * @since 1.0
 */

public class Main {
    public static void main(String[] args) {
        EquipeDeResgate equipeDeResgate = new EquipeDeResgate("ALPHA", "Terrestre", " Curto");
        System.out.println(equipeDeResgate);
        equipeDeResgate.statusDeDisponibilidade();

    }
}
