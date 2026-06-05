package EquipeDeResgate;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class OperadorUsuario {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Scanner sc = new Scanner(System.in);

    private String nome;
    private String cpf;
    private double taxaAcerto;
    private LocalDate dataNascimento;


    public OperadorUsuario(String nome, String cpf, double taxaAcerto, LocalDate dataNascimento) {
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

    public void setNome() {
        String input;
        do {
            System.out.println("Digite o nome do operador (mínimo 5 caracteres): ");
            input = sc.nextLine().trim();
        } while (input.length() < 5);
        this.nome = input;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf() {
        String input;
        do {
            System.out.println("Digite o CPF do operador (11 dígitos, apenas números): ");
            input = sc.nextLine().trim();
        } while (input.length() < 11);
        this.cpf = input;
    }

    public double getTaxaAcerto() {
        return taxaAcerto;
    }

    public void setTaxaAcerto() {
        String input;
        double valor;
        do {
            System.out.println("Digite a taxa de acerto do operador (0 a 100): ");
            input = sc.nextLine().trim();
            valor = Double.parseDouble(input);
        } while (valor < 0 || valor > 100);
        this.taxaAcerto = valor;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento() {
        LocalDate data = null;
        do {
            System.out.println("Digite a data de nascimento (dd/MM/yyyy): ");
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("ERRO! Campo obrigatório.");
                continue;
            }
            try {
                data = LocalDate.parse(input, FORMATTER);
                if (data.isAfter(LocalDate.now().minusYears(18))) {
                    System.out.println("ERRO! O operador deve ter pelo menos 18 anos.");
                    data = null;
                }
            } catch (Exception e) {
                System.out.println("ERRO! Data inválida. Use o formato dd/MM/yyyy.");
            }
        } while (data == null);
        this.dataNascimento = data;
    }

    @Override
    public String toString() {
        return "Nome do operador: " + nome +
                "\nCPF: " + cpf +
                "\nTaxa de acerto: " + taxaAcerto + "%" +
                "\nIdade: " + Period.between(dataNascimento, LocalDate.now()).getYears() + " anos";
    }
}
