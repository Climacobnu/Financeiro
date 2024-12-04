package com.myproject.financeiro.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.myproject.financeiro.model.Pagamento;


public class GerenciadorPagamentos {
    private List<Pagamento> pagamentos;

    public GerenciadorPagamentos() {
        this.pagamentos = new ArrayList<>();
    }

    public void adicionarPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
        System.out.println("Pagamento adicionado: " + pagamento);  // Adicione este log para verificar
    }

    public boolean removerPagamento(String descricao) {
        return pagamentos.removeIf(p -> p.getDescricao().equalsIgnoreCase(descricao));
    }

    public Pagamento buscarPorDescricao(String descricao) {
        for (Pagamento p : pagamentos) {
            if (p.getDescricao().equalsIgnoreCase(descricao)) {
                return p;
            }
        }
        return null;
    }

    public void listarPagamentos() {
        System.out.println("Listando pagamentos...");
        if (pagamentos.isEmpty()) {
            System.out.println("Nenhum pagamento cadastrado.");
        } else {
            for (Pagamento p : pagamentos) {
                System.out.println(p);
            }
        }
    }

    

    public void verificarPagamentosPendentes() {
        LocalDate hoje = LocalDate.now();
        boolean encontrouPendentes = false;

        for (Pagamento p : pagamentos) {
            if (!p.isStatusPago() && p.getDataVencimento().isBefore(hoje)) {
                System.out.println("Pagamento pendente: " + p);
                encontrouPendentes = true;
            }
        }

        if (!encontrouPendentes) {
            System.out.println("Nenhum pagamento pendente.");
        }
        
    }
    
}