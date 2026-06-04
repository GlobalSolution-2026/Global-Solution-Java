package CondicoesDeMissao;

public class Regiao extends CondicoesMetereologicas {


    public Regiao() {

    }

    public enum TipoTerreno {
        MONTANHA, FLORESTA, URBANO
    }

    public enum SinalComunicacao {
        SEM_COBERTURA, COM_COBERTURA
    }

    private String nomeRegiao;
    private String coordenadasGPS;
    private TipoTerreno tipoDoTerreno;
    private SinalComunicacao sinalComunicacao;


    public Regiao(double temperatura, Visibilidade visibilidade, NivelPrecipitacao nivelPrecipitacao, VelocidadeVento velocidadeVento, String nomeRegiao, String coordenadasGPS, TipoTerreno tipoDoTerreno, SinalComunicacao sinalComunicacao) {
        super(temperatura, visibilidade, nivelPrecipitacao, velocidadeVento);
        this.nomeRegiao = nomeRegiao;
        this.coordenadasGPS = coordenadasGPS;
        this.tipoDoTerreno = tipoDoTerreno;
        this.sinalComunicacao = sinalComunicacao;
    }



    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public void setNomeRegiao(String nomeRegiao) {
        String input;
        do {
            System.out.println("Digite o nome da região: ");
            input = sc.nextLine();
        } while (input.trim().isEmpty() || input.length() < 3);
        this.nomeRegiao = nomeRegiao;
    }

    public String getCoordenadasGPS() {
        return coordenadasGPS;
    }

    public void setCoordenadasGPS(String coordenadasGPS) {
        String input;
        do {
            System.out.println("Digite as coordenadas: ");
            input = sc.nextLine();
        } while (input.trim().isEmpty());
        this.coordenadasGPS = String.valueOf(Integer.parseInt(input));
    }

    public TipoTerreno getTipoDoTerreno() {
        return tipoDoTerreno;
    }

    public void setTipoDoTerreno(TipoTerreno tipoDoTerreno) {
        this.tipoDoTerreno = tipoDoTerreno;
    }

    public SinalComunicacao getSinalComunicacao() {
        return sinalComunicacao;
    }

    public void setSinalComunicacao(SinalComunicacao sinalComunicacao) {
        this.sinalComunicacao = sinalComunicacao;
    }

    @Override
    public String toString() {
        return "Região: " + nomeRegiao +
                "\nCoordenadas: " + coordenadasGPS +
                "\nTerreno: " + tipoDoTerreno +
                "\nSinal: " + sinalComunicacao;
    }
}
//TERMINAR SETS AQUI