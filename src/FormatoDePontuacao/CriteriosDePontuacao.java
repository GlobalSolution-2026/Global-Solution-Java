package FormatoDePontuacao;

import CondicoesDeMissao.Vitima;
import EquipeDeResgate.EquipeDeResgate;
import EquipeDeResgate.OperadorUsuario;

public class CriteriosDePontuacao implements Penalidades {

    private Vitima vitima;
    private EquipeDeResgate equipeDeResgate;
    private OperadorUsuario operador;

    private int gravidade;
    private int urgencia;
    private double multiplicadorTerreno;
    private double multiplicadorClima;
    private double riscoCenario;
    private int decisoesOperador;
    private double pontuacaoFinal;


    public CriteriosDePontuacao(Vitima vitima, EquipeDeResgate equipeDeResgate, OperadorUsuario operador) {
        this.vitima = vitima;
        this.equipeDeResgate = equipeDeResgate;
        this.operador = operador;
        calcularGravidade();
        calcularUrgencia();
        calcularMultiplicadorTerreno();
        calcularMultiplicadorClima();
        this.riscoCenario = (gravidade + urgencia) * multiplicadorTerreno * multiplicadorClima;
        this.decisoesOperador = 0;
        this.pontuacaoFinal = (riscoCenario * 0.40) + (decisoesOperador * 0.60);
    }


    private void calcularGravidade() {
        String saude = vitima.getEstadoInicialSaude();
        if (saude.equals("Estavel")) {
            this.gravidade = 1;
        } else if (saude.equals("Grave")) {
            this.gravidade = 2;
        } else {
            this.gravidade = 3;
        }
    }

    private void calcularUrgencia() {
        String faixa = vitima.getFaixaEtaria();
        if (faixa.equals("Adulta")) {
            this.urgencia = 1;
        } else {
            this.urgencia = 2;
        }
    }

    private void calcularMultiplicadorTerreno() {
        String terreno = vitima.getTipoDoTerreno();
        if (terreno.equals("Urbano")) {
            this.multiplicadorTerreno = 1.0;
        } else if (terreno.equals("Floresta")) {
            this.multiplicadorTerreno = 1.5;
        } else {
            this.multiplicadorTerreno = 1.8;
        }
    }

    private void calcularMultiplicadorClima() {
        String precipitacao = vitima.getNivelPrecipitacao();
        if (precipitacao.equals("Sem_Chuva")) {
            this.multiplicadorClima = 1.0;
        } else if (precipitacao.equals("Leve")) {
            this.multiplicadorClima = 1.2;
        } else if (precipitacao.equals("Moderada")) {
            this.multiplicadorClima = 1.5;
        } else {
            this.multiplicadorClima = 2.0;
        }

        if (vitima.getVisibilidade().equals("Alta")) {
            this.multiplicadorClima = this.multiplicadorClima + 0.3;
        }
    }

    public void recalcularPontuacao() {
        this.riscoCenario = (gravidade + urgencia) * multiplicadorTerreno * multiplicadorClima;
        this.pontuacaoFinal = (riscoCenario * 0.40) + (decisoesOperador * 0.60);
    }


    public int getGravidade() {
        return gravidade;
    }

    public int getUrgencia() {
        return urgencia;
    }

    public double getMultiplicadorTerreno() {
        return multiplicadorTerreno;
    }

    public double getMultiplicadorClima() {
        return multiplicadorClima;
    }

    public double getRiscoCenario() {
        return riscoCenario;
    }

    public int getDecisoesOperador() {
        return decisoesOperador;
    }

    public void setDecisoesOperador(int decisoesOperador) {
        this.decisoesOperador = decisoesOperador;
        recalcularPontuacao();
    }

    public double getPontuacaoFinal() {
        return pontuacaoFinal;
    }

    public Vitima getVitima() {
        return vitima;
    }

    public EquipeDeResgate getEquipeDeResgate() {
        return equipeDeResgate;
    }

    public OperadorUsuario getOperador() {
        return operador;
    }


    @Override
    public double penalidadeOperador() {
        double taxa = operador.getTaxaAcerto();
        if (taxa >= 80) {
            return 0.0;
        } else if (taxa >= 60) {
            return -5.0;
        } else if (taxa >= 40) {
            return -10.0;
        } else {
            return -20.0;
        }
    }

    @Override
    public double penalidadeVitima() {
        int perdas = vitima.getQtdPessoas() - vitima.getQtdPessoasResgatadas();
        return perdas * -10.0;
    }

    @Override
    public double penalidadeTecnologia() {
        int perdas = equipeDeResgate.getQtdTecnologias() - equipeDeResgate.getQtdTecnologiasRetornaram();
        return perdas * -5.0;
    }

    @Override
    public double penalidadeEquipe() {
        int perdas = equipeDeResgate.getQtdAgentesEnviados() - equipeDeResgate.getQtdAgentesRetornaram();
        return perdas * -15.0;
    }

    @Override
    public String toString() {
        return "Gravidade: " + gravidade +
                "\nUrgência: " + urgencia +
                "\nMultiplicador de Terreno: " + multiplicadorTerreno +
                "\nMultiplicador de Clima: " + multiplicadorClima +
                "\nRisco de Cenário: " + riscoCenario +
                "\nDecisões do Operador: " + decisoesOperador +
                "\nPontuação Final: " + pontuacaoFinal;
    }
}
