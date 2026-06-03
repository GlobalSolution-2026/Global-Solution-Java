package EquipeDeResgate;

import CondicoesDeMissao.Tecnologia;

import java.util.Scanner;

public class EquipeDeResgate implements Tecnologia {

    public enum NomeEquipe {
        Alpha, Bravo, Charlie
    }

    public enum Especialidade {
        Terrestre, Aquatico, Aerea
    }


    private Scanner sc = new Scanner(System.in);

    private String tempoDeResposta;
    private Especialidade especialidade;
    private NomeEquipe nomeEquipe;
    private int qtdTecnologias;
    private int qtdTecnologiasRetornaram;
    private int qtdAgentesEnviados;
    private int qtdAgentesRetornaram;


    public EquipeDeResgate(String tempoDeResposta, Especialidade especialidade,
                           NomeEquipe nomeEquipe, int qtdTecnologias,
                           int qtdTecnologiasRetornaram) {
        this.tempoDeResposta = tempoDeResposta;
        this.especialidade = especialidade;
        this.nomeEquipe = nomeEquipe;
        this.qtdTecnologias = qtdTecnologias;
        this.qtdTecnologiasRetornaram = qtdTecnologiasRetornaram;
    }

    public NomeEquipe getNomeEquipe() {
        return nomeEquipe;
    }

    public void setNomeEquipe(NomeEquipe nomeEquipe) {
        this.nomeEquipe = nomeEquipe;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public String getTempoDeResposta() {
        return tempoDeResposta;
    }

    public void setTempoDeResposta(String tempoDeResposta) {
        String input;
        do {
            System.out.println("Digite o tempo de resposta (Curto, Medio, Longo): ");
            input = sc.nextLine().trim().toLowerCase();
        } while (!input.equals("curto") && !input.equals("medio") && !input.equals("longo"));
        this.tempoDeResposta = input;
    }

    public int getQtdTecnologias() {
        return qtdTecnologias;
    }

    public void setQtdTecnologias(int qtdTecnologias) {
        this.qtdTecnologias = qtdTecnologias;
    }

    public int getQtdTecnologiasRetornaram() {
        return qtdTecnologiasRetornaram;
    }

    public void setQtdTecnologiasRetornaram(int qtdTecnologiasRetornaram) {
        this.qtdTecnologiasRetornaram = qtdTecnologiasRetornaram;
    }

    public int getQtdAgentesEnviados() {
        return qtdAgentesEnviados;
    }

    public void setQtdAgentesEnviados(int qtdAgentesEnviados) {
        this.qtdAgentesEnviados = qtdAgentesEnviados;
    }

    public int getQtdAgentesRetornaram() {
        return qtdAgentesRetornaram;
    }

    public void setQtdAgentesRetornaram(int qtdAgentesRetornaram) {
        this.qtdAgentesRetornaram = qtdAgentesRetornaram;
    }

    @Override
    public void nomeTecnologia() {
        System.out.println("Informe a tecnologia que vai utilizar, lembrando que o satélite estará presente mesmo selecionando somente drones.");
        System.out.println(
                "1 - Drone" +
                        "\n2 - Drone de Mantimentos" +
                        "\n3 - Apenas o LEO" +
                        "\n0 - CONTINUAR PROCESSO");

        int input = sc.nextInt();

        while (input != 0) {
            switch (input) {
                case 1:
                case 2:
                    qtdTecnologias += 2;
                    break;
                case 3:
                    qtdTecnologias += 1;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            input = sc.nextInt();
        }

        System.out.println("Tecnologias selecionadas com sucesso!");
    }

    @Override
    public void statusDeDisponibilidade() {
        boolean statusDisponibilidadeDrone = true;
        boolean statusDisponibilidadeLEO = true;

        System.out.printf("""
                        \nDisponibilidade de Dispositivos:
                        - Drone = %b
                        - LEO = %b
                        """,
                statusDisponibilidadeDrone,
                statusDisponibilidadeLEO);
    }

    @Override
    public String toString() {
        return "Nome da equipe: " + nomeEquipe +
                "\nEspecialidade: " + especialidade +
                "\nTempo de Resposta: " + tempoDeResposta;
    }
}