package CondicoesDeMissao;

import java.util.Scanner;

public class CondicoesMetereologicas {

    public enum Visibilidade {
        Baixa, Moderada, Alta
    }

    public enum NivelPrecipitacao {
        Sem_Chuva, Leve, Moderada, Intensa
    }

    public enum VelocidadeVento {
        Leve, Moderado, Forte
    }


    protected Scanner sc = new Scanner(System.in);

    private double temperatura;
    private Visibilidade visibilidade;
    private NivelPrecipitacao nivelPrecipitacao;
    private VelocidadeVento velocidadeVento;


    public CondicoesMetereologicas(double temperatura, Visibilidade visibilidade,
                                   NivelPrecipitacao nivelPrecipitacao, VelocidadeVento velocidadeVento) {
        this.temperatura = temperatura;
        this.visibilidade = visibilidade;
        this.nivelPrecipitacao = nivelPrecipitacao;
        this.velocidadeVento = velocidadeVento;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        String input;
        do {
            System.out.println("Digite a temperatura: ");
            input = sc.nextLine();
        } while (input.trim().isEmpty());
        this.temperatura = Double.parseDouble(input);
    }

    public Visibilidade getVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(Visibilidade visibilidade) {
        this.visibilidade = visibilidade;
    }

    public NivelPrecipitacao getNivelPrecipitacao() {
        return nivelPrecipitacao;
    }

    public void setNivelPrecipitacao(NivelPrecipitacao nivelPrecipitacao) {
        this.nivelPrecipitacao = nivelPrecipitacao;
    }

    public VelocidadeVento getVelocidadeVento() {
        return velocidadeVento;
    }

    public void setVelocidadeVento(VelocidadeVento velocidadeVento) {
        this.velocidadeVento = velocidadeVento;
    }

    @Override
    public String toString() {
        return "Temperatura: " + temperatura + "°C" +
                "\nVisibilidade: " + visibilidade +
                "\nPrecipitação: " + nivelPrecipitacao +
                "\nVelocidade do Vento: " + velocidadeVento;
    }
}