package com.myproject.financeiro.repository;

import java.util.List;

import com.myproject.financeiro.model.Pagamento;

public interface PagamentoRepository {
    void salvar(Pagamento pagamento);
    List<Pagamento> buscarTodos();
}