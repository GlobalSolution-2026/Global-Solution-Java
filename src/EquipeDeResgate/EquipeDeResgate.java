package EquipeDeResgate;

import CondicoesDeMissao.Tecnologia;

import java.util.Scanner;

public class EquipeDeResgate implements Tecnologia {
    private String nomeEquipe, especialidade, tempoDeResposta;
    Scanner sc = new Scanner(System.in);

    public EquipeDeResgate(String nomeEquipe, String especialidade, String tempoDeResposta) {
        this.nomeEquipe = nomeEquipe;
        this.especialidade = especialidade;
        this.tempoDeResposta = tempoDeResposta;
    }

    public String getNomeEquipe() {
        return nomeEquipe;
    }

    public void setNomeEquipe(String nomeEquipe) {
        this.nomeEquipe = nomeEquipe;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getTempoDeResposta() {
        return tempoDeResposta;
    }

    public void setTempoDeResposta(String tempoDeResposta) {
        this.tempoDeResposta = tempoDeResposta;
    }

    @Override
    public String toString() {
        return "Nome da equipe: " + nomeEquipe +
                "\nEspecialidade: " + especialidade +
                "\nTempo de Resposta: " + tempoDeResposta;
    }

    @Override
    public void nomeTecnologia() {
        System.out.print("Informe o nome da tecnologia que vai utilizar: ");

        String nomeTecnologia = sc.nextLine();

        System.out.println("Tecnologia escolhida: " + nomeTecnologia);
    }

    @Override
    public void tipoFuncao() {

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
                statusDisponibilidadeLEO
        );
    }
    }
