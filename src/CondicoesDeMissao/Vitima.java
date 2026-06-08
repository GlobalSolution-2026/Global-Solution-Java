package CondicoesDeMissao;

import LerInformacao.LerDado;

public class Vitima extends LerDado {

    private int qtdPessoas;
    private int qtdPessoasResgatadas;
    private String estadoInicialSaude;
    private String faixaEtaria;
    private String origemNotificacao;


    public Vitima(int qtdPessoas, int qtdPessoasResgatadas, String estadoInicialSaude, String faixaEtaria, String origemNotificacao) {
        this.qtdPessoas = qtdPessoas;
        this.qtdPessoasResgatadas = qtdPessoasResgatadas;
        this.estadoInicialSaude = estadoInicialSaude;
        this.faixaEtaria = faixaEtaria;
        this.origemNotificacao = origemNotificacao;
    }

    public Vitima() {
    }


    public int getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas() {
        String input;
        int valor;
        do {
            System.out.println("Digite a quantidade de pessoas: ");
            input = LerDado.sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("ERRO! Campo obrigatório.");
                valor = 0;
                continue;
            }
            try {
                valor = Integer.parseInt(input);
                if (valor <= 0) System.out.println("ERRO! Deve ser maior que zero.");
            } catch (NumberFormatException e) {
                System.out.println("ERRO! Digite um número inteiro válido.");
                valor = 0;
            }
        } while (valor <= 0);
        this.qtdPessoas = valor;
    }

    public int getQtdPessoasResgatadas() {
        return qtdPessoasResgatadas;
    }

    public void setQtdPessoasResgatadas() {
        String input;
        int valor;
        do {
            System.out.println("Digite a quantidade de pessoas resgatadas (máx: " + qtdPessoas + "): ");
            input = LerDado.sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("ERRO! Campo obrigatório.");
                valor = -1;
                continue;
            }
            try {
                valor = Integer.parseInt(input);
                if (valor < 0 || valor > qtdPessoas)
                    System.out.println("ERRO! Valor deve ser entre 0 e " + qtdPessoas + ".");
            } catch (NumberFormatException e) {
                System.out.println("ERRO! Digite um número inteiro válido.");
                valor = -1;
            }
        } while (valor < 0 || valor > qtdPessoas);
        this.qtdPessoasResgatadas = valor;
    }

    public String getEstadoInicialSaude() {
        return estadoInicialSaude;
    }

    public void setEstadoInicialSaude() {
        String input;
        do {
            System.out.println("Informe o estado inicial de saúde (Estavel / Grave / Risco_De_Vida): ");
            input = LerDado.sc.nextLine().trim().toLowerCase();
        } while (!input.equals("estavel") && !input.equals("grave") && !input.equals("risco_de_vida"));

        if (input.equals("estavel")) {
            this.estadoInicialSaude = "Estavel";
        } else if (input.equals("grave")) {
            this.estadoInicialSaude = "Grave";
        } else {
            this.estadoInicialSaude = "Risco_De_Vida";
        }
    }

    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria() {
        String input;
        do {
            System.out.println("Informe a faixa etária (Crianca / Adulta / Terceira_Idade): ");
            input = LerDado.sc.nextLine().trim().toLowerCase();
        } while (!input.equals("crianca") && !input.equals("adulta") && !input.equals("terceira_idade"));

        if (input.equals("crianca")) {
            this.faixaEtaria = "Crianca";
        } else if (input.equals("adulta")) {
            this.faixaEtaria = "Adulta";
        } else {
            this.faixaEtaria = "Terceira_Idade";
        }
    }

    public String getOrigemNotificacao() {
        return origemNotificacao;
    }

    public void setOrigemNotificacao() {
        String input;
        do {
            System.out.println("Informe a origem da notificação (Satelite / Ligacao / SMS): ");
            input = LerDado.sc.nextLine().trim().toLowerCase();
        } while (!input.equals("satelite") && !input.equals("ligacao") && !input.equals("sms"));

        if (input.equals("satelite")) {
            this.origemNotificacao = "Satelite";
        } else if (input.equals("ligacao")) {
            this.origemNotificacao = "Ligacao";
        } else {
            this.origemNotificacao = "SMS";
        }
    }

    @Override
    public String toString() {
        return "Estado de Saúde: " + estadoInicialSaude +
                "\nFaixa etária: " + faixaEtaria +
                "\nOrigem da notificação: " + origemNotificacao +
                "\nQuantidade de pessoas: " + qtdPessoas +
                "\nQuantidade resgatadas: " + qtdPessoasResgatadas;
    }
}
