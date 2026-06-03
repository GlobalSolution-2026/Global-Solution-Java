package EquipeDeResgate;

import CondicoesDeMissao.Regiao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Missoes extends Regiao {


    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    private LocalDateTime dataAcionamento;
    private LocalDateTime dataConclusao;
    private String statusMissao;


    public Missoes(double temperatura, Visibilidade visibilidade,
                   NivelPrecipitacao nivelPrecipitacao, VelocidadeVento velocidadeVento,
                   String nomeRegiao, String coordenadasGPS,
                   TipoTerreno tipoDoTerreno, SinalComunicacao sinalComunicacao,
                   LocalDateTime dataAcionamento, LocalDateTime dataConclusao,
                   String statusMissao) {
        super(temperatura, visibilidade, nivelPrecipitacao, velocidadeVento,
                nomeRegiao, coordenadasGPS, tipoDoTerreno, sinalComunicacao);
        this.dataAcionamento = dataAcionamento;
        this.dataConclusao = dataConclusao;
        this.statusMissao = statusMissao;
    }


    public LocalDateTime getDataAcionamento() {
        return dataAcionamento;
    }

    public void setDataAcionamento(LocalDateTime dataAcionamento) {
        String input;
        do {
            System.out.println("Digite a data de acionamento (dd/MM/yyyy): ");
            input = sc.nextLine().trim();
        } while (input.isEmpty());
        this.dataAcionamento = LocalDate.parse(input, FORMATTER).atStartOfDay();
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        String input;
        do {
            System.out.println("Digite a data de conclusão (dd/MM/yyyy): ");
            input = sc.nextLine().trim();
        } while (input.isEmpty());
        this.dataConclusao = LocalDate.parse(input, FORMATTER).atStartOfDay();
    }

    public String getStatusMissao() {
        return statusMissao;
    }

    public void setStatusMissao(String statusMissao) {
        String input;
        do {
            System.out.println("Qual o status da missão? (iniciada, em andamento, finalizada): ");
            input = sc.nextLine().trim().toLowerCase();
        } while (!input.equals("iniciada") && !input.equals("em andamento") && !input.equals("finalizada"));
        this.statusMissao = input;
    }


    @Override
    public String toString() {
        return "Data de acionamento: " + dataAcionamento +
                "\nData de conclusão: " + dataConclusao +
                "\nStatus da missão: " + statusMissao;
    }
}