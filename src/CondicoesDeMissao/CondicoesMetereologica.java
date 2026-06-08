package CondicoesDeMissao;

import LerInformacao.LerDado;


public class CondicoesMetereologica extends LerDado {

    private double temperatura;
    private String visibilidade;
    private String nivelPrecipitacao;
    private String velocidadeVento;


    public CondicoesMetereologica(double temperatura, String visibilidade,
                                  String nivelPrecipitacao, String velocidadeVento) {
        this.temperatura = temperatura;
        this.visibilidade = visibilidade;
        this.nivelPrecipitacao = nivelPrecipitacao;
        this.velocidadeVento = velocidadeVento;
    }

    public CondicoesMetereologica() {
    }


    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura() {
        String input;
        double valor = 0;
        boolean valido;
        do {
            System.out.println("Digite a temperatura (ex: 25.5): ");
            input = LerDado.sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("ERRO! Campo obrigatório.");
                valido = false;
                continue;
            }
            try {
                valor = Double.parseDouble(input);
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("ERRO! Digite um número válido.");
                valido = false;
            }
        } while (!valido);
        this.temperatura = valor;
    }

    public String getVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade() {
        String input;
        do {
            System.out.println("Informe o nível de dificuldade de visibilidade (Baixa / Moderada / Alta): ");
            input = LerDado.sc.nextLine().trim().toLowerCase();
        } while (!input.equals("baixa") && !input.equals("moderada") && !input.equals("alta"));

        if (input.equals("baixa")) {
            this.visibilidade = "Baixa";
        } else if (input.equals("moderada")) {
            this.visibilidade = "Moderada";
        } else {
            this.visibilidade = "Alta";
        }
    }

    public String getNivelPrecipitacao() {
        return nivelPrecipitacao;
    }

    public void setNivelPrecipitacao() {
        String input;
        do {
            System.out.println("Informe o nível de precipitação (Sem_Chuva / Leve / Moderada / Intensa): ");
            input = LerDado.sc.nextLine().trim().toLowerCase();
        } while (!input.equals("sem_chuva") && !input.equals("leve")
                && !input.equals("moderada") && !input.equals("intensa"));

        if (input.equals("sem_chuva")) {
            this.nivelPrecipitacao = "Sem_Chuva";
        } else if (input.equals("leve")) {
            this.nivelPrecipitacao = "Leve";
        } else if (input.equals("moderada")) {
            this.nivelPrecipitacao = "Moderada";
        } else {
            this.nivelPrecipitacao = "Intensa";
        }
    }

    public String getVelocidadeVento() {
        return velocidadeVento;
    }

    public void setVelocidadeVento() {
        String input;
        do {
            System.out.println("Informe a velocidade do vento (Leve / Moderado / Forte): ");
            input = sc.nextLine().trim().toLowerCase();
        } while (!input.equals("leve") && !input.equals("moderado") && !input.equals("forte"));

        if (input.equals("leve")) {
            this.velocidadeVento = "Leve";
        } else if (input.equals("moderado")) {
            this.velocidadeVento = "Moderado";
        } else {
            this.velocidadeVento = "Forte";
        }
    }

    @Override
    public String toString() {
        return "Temperatura: " + temperatura + "°C" +
                "\nVisibilidade: " + visibilidade +
                "\nPrecipitação: " + nivelPrecipitacao +
                "\nVelocidade do Vento: " + velocidadeVento;
    }
}
