package CondicoesDeMissao;

public class CondicoesMetereologicas {
    private double temperatura;
    private String visibilidade, nivelPrecipitacao, velocidadeVento;

    public CondicoesMetereologicas(double temperatura, String visibilidade, String nivelPrecipitacao, String velocidadeVento) {
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

    public String getVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(String visibilidade) {
        this.visibilidade = visibilidade;
    }

    public String getNivelPrecipitacao() {
        return nivelPrecipitacao;
    }

    public void setNivelPrecipitacao(String nivelPrecipitacao) {
        this.nivelPrecipitacao = nivelPrecipitacao;
    }

    public String getVelocidadeVento() {
        return velocidadeVento;
    }

    public void setVelocidadeVento(String velocidadeVento) {
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
