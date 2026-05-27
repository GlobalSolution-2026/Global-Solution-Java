package CondicoesDeMissao;

public abstract class Regiao {

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

    public Regiao(String nomeRegiao, String coordenadasGPS, String tipoDoTerreno, String sinalComunicacao) {
        this.nomeRegiao = nomeRegiao;
        this.coordenadasGPS = coordenadasGPS;
        this.tipoDoTerreno = TipoTerreno.valueOf(tipoDoTerreno.toUpperCase());
        this.sinalComunicacao = SinalComunicacao.valueOf(sinalComunicacao.toUpperCase().replace(" ", "_"));
    }

    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    public String getCoordenadasGPS() {
        return coordenadasGPS;
    }

    public void setCoordenadasGPS(String coordenadasGPS) {
        this.coordenadasGPS = coordenadasGPS;
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