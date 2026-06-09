package Equipe;

import CondicoesDeMissao.CondicoesMetereologica;
import LerInformacao.LerDado;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class OperadorUsuario extends LerDado {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;


    public OperadorUsuario(String nome, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
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
            input = LerDado.sc.nextLine().trim();
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
            input = LerDado.sc.nextLine().trim();
        } while (input.length() != 11);
        this.cpf = input;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento() {
        LocalDate data = null;
        do {
            System.out.println("Digite a data de nascimento (dd/mm/yyyy): ");
            String input = LerDado.sc.nextLine().trim();
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
                System.out.println("ERRO! Data inválida. Use o formato dd/mm/yyyy.");
            }
        } while (data == null);
        this.dataNascimento = data;
    }

    @Override
    public String toString() {
        return "Nome do operador: " + nome +
                "\nCPF: " + cpf +
                "\nIdade: " + Period.between(dataNascimento, LocalDate.now()).getYears() + " anos";
    }
}
