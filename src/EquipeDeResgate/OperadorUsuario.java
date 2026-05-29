package EquipeDeResgate;

import java.time.LocalDate;

public class OperadorUsuario {
    private String nome, cpf, taxaAcerto;
    private LocalDate dataNascimento;

    public OperadorUsuario(String nome, String cpf, String taxaAcerto, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.taxaAcerto = taxaAcerto;
        this.dataNascimento = dataNascimento;
    }

    public OperadorUsuario() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTaxaAcerto() {
        return taxaAcerto;
    }

    public void setTaxaAcerto(String taxaAcerto) {
        this.taxaAcerto = taxaAcerto;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Nome do operador: " + nome +
                "\nCPF: " + cpf +
                "\nTaxa de acerto: " + taxaAcerto +
                "\nData de nascimento: " + dataNascimento;

    }
}
