package CondicoesDeMissao;

public class Vitima {
    private String identificacao, estadoInicialSaude, faixaEtaria, origemNotificacao;
    private int qtdPessoas;

    public Vitima(String identificacao, String estadoInicialSaude, String faixaEtaria, String origemNotificacao, int qtdPessoas) {
        this.identificacao = identificacao;
        this.estadoInicialSaude = estadoInicialSaude;
        this.faixaEtaria = faixaEtaria;
        this.origemNotificacao = origemNotificacao;
        this.qtdPessoas = qtdPessoas;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getEstadoInicialSaude() {
        return estadoInicialSaude;
    }

    public void setEstadoInicialSaude(String estadoInicialSaude) {
        this.estadoInicialSaude = estadoInicialSaude;
    }

    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public String getOrigemNotificacao() {
        return origemNotificacao;
    }

    public void setOrigemNotificacao(String origemNotificacao) {
        this.origemNotificacao = origemNotificacao;
    }

    public int getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(int qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }
    @Override
    public String toString() {
        return "Identificação: " + identificacao +
                "\nEstado de Saúde: " + estadoInicialSaude +
                "\nFaixa etária: " + faixaEtaria +
                "\nOrigem da notificação: " + origemNotificacao +
                "\n Quantidade de pessoas: " + qtdPessoas;
    }
}
