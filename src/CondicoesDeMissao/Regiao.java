package CondicoesDeMissao;

public class Regiao extends CondicoesMetereologicas {

    private String nomeRegiao;
    private String coordenadasGPS;
    private String tipoDoTerreno;
    private String sinalComunicacao;


    public Regiao(double temperatura, String visibilidade, String nivelPrecipitacao,
                  String velocidadeVento, String nomeRegiao, String coordenadasGPS,
                  String tipoDoTerreno, String sinalComunicacao) {
        super(temperatura, visibilidade, nivelPrecipitacao, velocidadeVento);
        this.nomeRegiao = nomeRegiao;
        this.coordenadasGPS = coordenadasGPS;
        this.tipoDoTerreno = tipoDoTerreno;
        this.sinalComunicacao = sinalComunicacao;
    }

    public Regiao() {
    }


    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public void setNomeRegiao() {
        String input;
        do {
            System.out.println("Digite o nome da região (mínimo 3 caracteres): ");
            input = sc.nextLine().trim();
        } while (input.length() < 3);
        this.nomeRegiao = input;
    }

    public String getCoordenadasGPS() {
        return coordenadasGPS;
    }

    public void setCoordenadasGPS() {
        String input;
        do {
            System.out.println("Digite as coordenadas GPS (ex: -23.5505, -46.6333): ");
            input = sc.nextLine().trim();
        } while (input.isEmpty());
        this.coordenadasGPS = input;
    }

    public String getTipoDoTerreno() {
        return tipoDoTerreno;
    }

    public void setTipoDoTerreno() {
        String input;
        do {
            System.out.println("Informe o tipo de terreno (Montanha / Floresta / Urbano): ");
            input = sc.nextLine().trim().toLowerCase();
        } while (!input.equals("montanha") && !input.equals("floresta") && !input.equals("urbano"));

        if (input.equals("montanha")) {
            this.tipoDoTerreno = "Montanha";
        } else if (input.equals("floresta")) {
            this.tipoDoTerreno = "Floresta";
        } else {
            this.tipoDoTerreno = "Urbano";
        }
    }

    public String getSinalComunicacao() {
        return sinalComunicacao;
    }

    public void setSinalComunicacao() {
        String input;
        do {
            System.out.println("Informe o sinal de comunicação (Com_Cobertura / Sem_Cobertura): ");
            input = sc.nextLine().trim().toLowerCase();
        } while (!input.equals("com_cobertura") && !input.equals("sem_cobertura"));

        if (input.equals("com_cobertura")) {
            this.sinalComunicacao = "Com_Cobertura";
        } else {
            this.sinalComunicacao = "Sem_Cobertura";
        }
    }

    @Override
    public String toString() {
        return "Região: " + nomeRegiao +
                "\nCoordenadas: " + coordenadasGPS +
                "\nTerreno: " + tipoDoTerreno +
                "\nSinal: " + sinalComunicacao;
    }
}
