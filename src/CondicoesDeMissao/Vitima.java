package CondicoesDeMissao;

public class Vitima extends Regiao {


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
    private int qtdPessoasResgatadas;
    private EstadoInicialSaude estadoInicialSaude;
    private FaixaEtaria faixaEtaria;
    private OrigemNotificacao origemNotificacao;


    public Vitima(double temperatura, Visibilidade visibilidade,
                  NivelPrecipitacao nivelPrecipitacao, VelocidadeVento velocidadeVento,
                  String nomeRegiao, String coordenadasGPS,
                  TipoTerreno tipoDoTerreno, SinalComunicacao sinalComunicacao,
                  String identificacao, int qtdPessoas, int qtdPessoasResgatadas,
                  EstadoInicialSaude estadoInicialSaude, FaixaEtaria faixaEtaria,
                  OrigemNotificacao origemNotificacao) {
        super(temperatura, visibilidade, nivelPrecipitacao, velocidadeVento,
                nomeRegiao, coordenadasGPS, tipoDoTerreno, sinalComunicacao);
        this.identificacao = identificacao;
        this.qtdPessoas = qtdPessoas;
        this.qtdPessoasResgatadas = qtdPessoasResgatadas;
        this.estadoInicialSaude = estadoInicialSaude;
        this.faixaEtaria = faixaEtaria;
        this.origemNotificacao = origemNotificacao;
    }


    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public int getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(int qtdPessoas) {
        String input;
        int valor;
        do {
            System.out.println("Digite a quantidade de pessoas: ");
            input = sc.nextLine().trim();
            valor = Integer.parseInt(input);
        } while (valor <= 0);
        this.qtdPessoas = valor;
    }

    public int getQtdPessoasResgatadas() {
        return qtdPessoasResgatadas;
    }

    public void setQtdPessoasResgatadas(int qtdPessoasResgatadas) {
        this.qtdPessoasResgatadas = qtdPessoasResgatadas;
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

    @Override
    public String toString() {
        return "Identificação: " + identificacao +
                "\nEstado de Saúde: " + estadoInicialSaude +
                "\nFaixa etária: " + faixaEtaria +
                "\nOrigem da notificação: " + origemNotificacao +
                "\nQuantidade de pessoas: " + qtdPessoas +
                "\nQuantidade resgatadas: " + qtdPessoasResgatadas;
    }
}