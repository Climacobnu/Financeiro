package com.myproject.financeiro;

import java.time.LocalDate;
import java.util.Scanner;

import com.myproject.financeiro.model.Pagamento;
import com.myproject.financeiro.service.GerenciadorPagamentos;

public class Main {
    private static final GerenciadorPagamentos gerenciador = new GerenciadorPagamentos();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer de entrada

            switch (opcao) {
                case 1 -> adicionarPagamento();
                case 2 -> editarPagamento();
                case 3 -> excluirPagamento();
                case 4 -> {
                    System.out.println("Listando pagamentos...");
                    listarPagamentos();
                }
                case 5 -> verificarPagamentosPendentes();
                case 6 -> {
                    System.out.println("Saindo do sistema. Até logo!");
                    return;
                }
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n=== MENU DE PAGAMENTOS ===");
        System.out.println("1. Adicionar Pagamento");
        System.out.println("2. Editar Pagamento");
        System.out.println("3. Excluir Pagamento");
        System.out.println("4. Listar Pagamentos");
        System.out.println("5. Verificar Pagamentos Pendentes");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarPagamento() {
        System.out.println("\n=== Adicionar Pagamento ===");

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Valor: ");
        double valor = scanner.nextDouble();

        System.out.print("Data de Vencimento (yyyy-MM-dd): ");
        LocalDate dataVencimento = LocalDate.parse(scanner.next());

        System.out.print("Método de Pagamento: ");
        scanner.nextLine(); // Limpa o buffer
        String metodoPagamento = scanner.nextLine();

        Pagamento pagamento = new Pagamento(descricao, valor, dataVencimento, metodoPagamento);
        gerenciador.adicionarPagamento(pagamento);

        System.out.println("Pagamento adicionado com sucesso!");
    }

    private static void editarPagamento() {
        System.out.println("\n=== Editar Pagamento ===");

        System.out.print("Informe a descrição do pagamento que deseja editar: ");
        String descricao = scanner.nextLine();

        Pagamento pagamento = gerenciador.buscarPorDescricao(descricao);
        if (pagamento == null) {
            System.out.println("Pagamento não encontrado!");
            return;
        }

        System.out.println("Pagamento encontrado: " + pagamento);

        System.out.print("Nova Descrição (deixe vazio para manter): ");
        String novaDescricao = scanner.nextLine();
        if (!novaDescricao.isEmpty()) {
            pagamento.setDescricao(novaDescricao);
        }

        System.out.print("Novo Valor (0 para manter): ");
        double novoValor = scanner.nextDouble();
        if (novoValor > 0) {
            pagamento.setValor(novoValor);
        }

        System.out.print("Nova Data de Vencimento (deixe vazio para manter, formato yyyy-MM-dd): ");
        scanner.nextLine(); // Limpa o buffer
        String novaDataStr = scanner.nextLine();
        if (!novaDataStr.isEmpty()) {
            pagamento.setDataVencimento(LocalDate.parse(novaDataStr));
        }

        System.out.print("Novo Método de Pagamento (deixe vazio para manter): ");
        String novoMetodo = scanner.nextLine();
        if (!novoMetodo.isEmpty()) {
            pagamento.setMetodoPagamento(novoMetodo);
        }

        System.out.println("Pagamento editado com sucesso!");
    }

    private static void excluirPagamento() {
        System.out.println("\n=== Excluir Pagamento ===");

        System.out.print("Informe a descrição do pagamento que deseja excluir: ");
        String descricao = scanner.nextLine();

        boolean removido = gerenciador.removerPagamento(descricao);
        if (removido) {
            System.out.println("Pagamento excluído com sucesso!");
        } else {
            System.out.println("Pagamento não encontrado!");
        }
    }

    private static void listarPagamentos() {
        System.out.println("\n=== Listar Pagamentos ===");
        gerenciador.listarPagamentos();
    }

    private static void verificarPagamentosPendentes() {
        System.out.println("\n=== Pagamentos Pendentes ===");
        gerenciador.verificarPagamentosPendentes();
    }
}