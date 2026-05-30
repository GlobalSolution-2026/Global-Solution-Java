package CondicoesDeMissao;

public class Vitima {

    public enum EstadoInicialSaude {
        Estavel, Grave, Risco_De_Vida
    }

    public enum FaixaEtaria {
        Crianca, Adulta, Terceira_Idade
    }

    public enum OrigemNotificacao {
        Satelite, Ligacao, SMS
    }

    private String identificacao;
    private int qtdPessoas;
    private EstadoInicialSaude estadoInicialSaude;
    private FaixaEtaria faixaEtaria;
    private OrigemNotificacao origemNotificacao;

    public Vitima(String identificacao, EstadoInicialSaude estadoInicialSaude, FaixaEtaria faixaEtaria, OrigemNotificacao origemNotificacao, int qtdPessoas) {
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

    public EstadoInicialSaude getEstadoInicialSaude() {
        return estadoInicialSaude;
    }

    public void setEstadoInicialSaude(EstadoInicialSaude estadoInicialSaude) {
        this.estadoInicialSaude = estadoInicialSaude;
    }

    public FaixaEtaria getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(FaixaEtaria faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public OrigemNotificacao getOrigemNotificacao() {
        return origemNotificacao;
    }

    public void setOrigemNotificacao(OrigemNotificacao origemNotificacao) {
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
