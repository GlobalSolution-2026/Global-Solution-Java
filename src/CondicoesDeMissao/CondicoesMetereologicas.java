package CondicoesDeMissao;

public class CondicoesMetereologicas {
    public enum Visibilidade {
        Baixa, Moderada, Alta
    }

    public enum nivelPrecipitacao {
        Sem_Chuva, Leve, Moderada, Intensa
    }

    public enum VelocidadeVento {
        Leve, Moderado, Forte
    }

    private double temperatura;
    private VelocidadeVento velocidadeVento;
    private Visibilidade visibilidade;
    private nivelPrecipitacao nivelPrecipitacao;

    public CondicoesMetereologicas(double temperatura, Visibilidade visibilidade, nivelPrecipitacao nivelPrecipitacao, VelocidadeVento velocidadeVento) {
        this.temperatura = temperatura;
        this.visibilidade = visibilidade;
        this.nivelPrecipitacao = nivelPrecipitacao;
        this.velocidadeVento = velocidadeVento;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public Visibilidade getVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(Visibilidade visibilidade) {
        this.visibilidade = visibilidade;
    }

    public nivelPrecipitacao getNivelPrecipitacao() {
        return nivelPrecipitacao;
    }

    public void setNivelPrecipitacao(nivelPrecipitacao nivelPrecipitacao) {
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
