package EquipeDeResgate;

import CondicoesDeMissao.Regiao;

import java.time.LocalDateTime;

public abstract class Missoes {
    private LocalDateTime dataAcionamento, dataConclusao;
    private String statusMissao;

    public Missoes(LocalDateTime dataAcionamento, LocalDateTime dataConclusao, String statusMissao) {
        this.dataAcionamento = dataAcionamento;
        this.dataConclusao = dataConclusao;
        this.statusMissao = statusMissao;
    }

    public LocalDateTime getDataAcionamento() {
        return dataAcionamento;
    }

    public void setDataAcionamento(LocalDateTime dataAcionamento) {
        this.dataAcionamento = dataAcionamento;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getStatusMissao() {
        return statusMissao;
    }

    public void setStatusMissao(String statusMissao) {
        this.statusMissao = statusMissao;
    }
    @Override
    public String toString() {
        return "Data de acionamento: " + dataAcionamento +
                "\nData de conclusão: " + dataConclusao +
                "\nStatus da missão: " + statusMissao;
    }
}
