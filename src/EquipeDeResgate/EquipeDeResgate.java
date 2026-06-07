package EquipeDeResgate;

import CondicoesDeMissao.Tecnologia;
import java.util.Scanner;

public class EquipeDeResgate implements Tecnologia {

    private Scanner sc = new Scanner(System.in);

    private String nomeEquipe;
    private String especialidade;
    private int qtdTecnologias;
    private int qtdTecnologiasRetornaram;
    private int qtdAgentesEnviados;
    private int qtdAgentesRetornaram;


    public EquipeDeResgate(String nomeEquipe, String especialidade,
                           int qtdTecnologias, int qtdTecnologiasRetornaram,
                           int qtdAgentesEnviados, int qtdAgentesRetornaram) {
        this.nomeEquipe = nomeEquipe;
        this.especialidade = especialidade;
        this.qtdTecnologias = qtdTecnologias;
        this.qtdTecnologiasRetornaram = qtdTecnologiasRetornaram;
        this.qtdAgentesEnviados = qtdAgentesEnviados;
        this.qtdAgentesRetornaram = qtdAgentesRetornaram;
    }

    public EquipeDeResgate() {
    }


    public String getNomeEquipe() {
        return nomeEquipe;
    }

    public void setNomeEquipe() {
        String input;
        do {
            System.out.println("Informe o nome da equipe (Alpha / Bravo / Charlie): ");
            input = sc.nextLine().trim().toLowerCase();
        } while (!input.equals("alpha") && !input.equals("bravo") && !input.equals("charlie"));

        if (input.equals("alpha")) {
            this.nomeEquipe = "Alpha";
        } else if (input.equals("bravo")) {
            this.nomeEquipe = "Bravo";
        } else {
            this.nomeEquipe = "Charlie";
        }
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade() {
        String input;
        do {
            System.out.println("Informe a especialidade da equipe (Terrestre / Aquatico / Aerea): ");
            input = sc.nextLine().trim().toLowerCase();
        } while (!input.equals("terrestre") && !input.equals("aquatico") && !input.equals("aerea"));

        if (input.equals("terrestre")) {
            this.especialidade = "Terrestre";
        } else if (input.equals("aquatico")) {
            this.especialidade = "Aquatico";
        } else {
            this.especialidade = "Aerea";
        }
    }

    public int getQtdTecnologias() {
        return qtdTecnologias;
    }

    public void setQtdTecnologias() {
        this.qtdTecnologias = 0;
    }

    public int getQtdTecnologiasRetornaram() {
        return qtdTecnologiasRetornaram;
    }

    public void setQtdTecnologiasRetornaram() {
        String input;
        int valor;
        do {
            System.out.println("Digite a quantidade de tecnologias que retornaram (máx: " + qtdTecnologias + "): ");
            input = sc.nextLine().trim();
            valor = Integer.parseInt(input);
        } while (valor < 0 || valor > qtdTecnologias);
        this.qtdTecnologiasRetornaram = valor;
    }

    public int getQtdAgentesEnviados() {
        return qtdAgentesEnviados;
    }

    public void setQtdAgentesEnviados() {
        String input;
        int valor;
        do {
            System.out.println("Digite a quantidade de agentes enviados: ");
            input = sc.nextLine().trim();
            valor = Integer.parseInt(input);
        } while (valor <= 0);
        this.qtdAgentesEnviados = valor;
    }

    public int getQtdAgentesRetornaram() {
        return qtdAgentesRetornaram;
    }

    public void setQtdAgentesRetornaram() {
        String input;
        int valor;
        do {
            System.out.println("Digite a quantidade de agentes que retornaram (máx: " + qtdAgentesEnviados + "): ");
            input = sc.nextLine().trim();
            valor = Integer.parseInt(input);
        } while (valor < 0 || valor > qtdAgentesEnviados);
        this.qtdAgentesRetornaram = valor;
    }

    @Override
    public void nomeTecnologia() {
        this.qtdTecnologias = 0;
        System.out.println("Informe as tecnologias utilizadas (o satélite LEO estará presente em qualquer seleção com drones).");
        System.out.println(
                "1 - Drone" +
                "\n2 - Drone de Mantimentos" +
                "\n3 - Apenas o LEO" +
                "\n0 - Continuar");

        String inputStr = sc.nextLine().trim();
        int input = Integer.parseInt(inputStr);

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
            inputStr = sc.nextLine().trim();
            input = Integer.parseInt(inputStr);
        }

        System.out.println("Tecnologias selecionadas: " + qtdTecnologias);
    }

    @Override
    public void statusDeDisponibilidade() {
        System.out.println("\nDisponibilidade de Dispositivos:");
        System.out.println("- Drone = Pronto");
        System.out.println("- LEO = Pronto");
    }

    @Override
    public String toString() {
        return "Nome da equipe: " + nomeEquipe +
                "\nEspecialidade: " + especialidade +
                "\nAgentes enviados: " + qtdAgentesEnviados +
                "\nAgentes retornaram: " + qtdAgentesRetornaram +
                "\nTecnologias utilizadas: " + qtdTecnologias +
                "\nTecnologias retornaram: " + qtdTecnologiasRetornaram;
    }
}
