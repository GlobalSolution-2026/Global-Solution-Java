package EquipeDeResgate;

import CondicoesDeMissao.Regiao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Missoes extends Regiao {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDate dataAcionamento;
    private LocalDate dataConclusao;
    private String statusMissao;


    public Missoes(double temperatura, String visibilidade,
                   String nivelPrecipitacao, String velocidadeVento,
                   String nomeRegiao, String coordenadasGPS,
                   String tipoDoTerreno, String sinalComunicacao,
                   LocalDate dataAcionamento, LocalDate dataConclusao,
                   String statusMissao) {
        super(temperatura, visibilidade, nivelPrecipitacao, velocidadeVento,
                nomeRegiao, coordenadasGPS, tipoDoTerreno, sinalComunicacao);
        this.dataAcionamento = dataAcionamento;
        this.dataConclusao = dataConclusao;
        this.statusMissao = statusMissao;
    }

    public Missoes() {
    }


    public LocalDate getDataAcionamento() {
        return dataAcionamento;
    }

    public void setDataAcionamento() {
        String input;
        do {
            System.out.println("Digite a data de acionamento (dd/MM/yyyy): ");
            input = sc.nextLine().trim();
        } while (input.isEmpty());
        this.dataAcionamento = LocalDate.parse(input, FORMATTER);
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao() {
        String input;
        do {
            System.out.println("Digite a data de conclusão (dd/MM/yyyy): ");
            input = sc.nextLine().trim();
        } while (input.isEmpty());
        this.dataConclusao = LocalDate.parse(input, FORMATTER);
    }

    public String getStatusMissao() {
        return statusMissao;
    }

    public void setStatusMissao() {
        String input;
        do {
            System.out.println("Qual o status da missão? (Iniciada / Em_Andamento / Finalizada): ");
            input = sc.nextLine().trim().toLowerCase();
        } while (!input.equals("iniciada") && !input.equals("em_andamento") && !input.equals("finalizada"));

        if (input.equals("iniciada")) {
            this.statusMissao = "Iniciada";
        } else if (input.equals("em_andamento")) {
            this.statusMissao = "Em_Andamento";
        } else {
            this.statusMissao = "Finalizada";
        }
    }

    @Override
    public String toString() {
        return "Data de acionamento: " + dataAcionamento.format(FORMATTER) +
                "\nData de conclusão: " + dataConclusao.format(FORMATTER) +
                "\nStatus da missão: " + statusMissao;
    }
}
