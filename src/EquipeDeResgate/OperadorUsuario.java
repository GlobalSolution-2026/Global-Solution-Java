package EquipeDeResgate;

import java.time.LocalDate;
import java.util.Scanner;

public class OperadorUsuario {
    private String nome, cpf, taxaAcerto;
    private LocalDate dataNascimento;
    Scanner sc = new Scanner(System.in);

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
        while (nome.trim().isEmpty() || nome.length() < 5) {
            System.out.println("ERRO! Digite um nome válido: ");
            nome = sc.nextLine();
        }
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        while (cpf.trim().isEmpty() || cpf.length() < 11) {
            System.out.println("ERRO! Digite um CPF válido (no mínimo 11 dígitos): ");
            cpf = sc.nextLine();
        }
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
        System.out.println("Digite a data de nascimento (dd/MM/yyyy): ");
        dataNascimento = LocalDate.parse(sc.nextLine(), java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        while (dataNascimento.isAfter(LocalDate.now().minusYears(18))) {
            System.out.println("ERRO! Você deve ter pelo menos 18 anos. Digite uma data válida: ");
            dataNascimento = LocalDate.parse(sc.nextLine(), java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Nome do operador: " + nome +
                "\nCPF: " + cpf +
                "\nTaxa de acerto: " + taxaAcerto + "%" +
                "\nIdade: " + java.time.Period.between(dataNascimento, LocalDate.now()).getYears() + " anos";
    }
}
