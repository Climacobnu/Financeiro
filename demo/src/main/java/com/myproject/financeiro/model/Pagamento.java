package com.myproject.financeiro.model;
import java.time.LocalDate;

public class Pagamento {
    private String descricao;
    private double valor;
    private LocalDate dataVencimento;
    private String metodoPagamento; // Ex.: "Transferência", "Boleto"
    private boolean statusPago;

    // Construtor
    public Pagamento(String descricao, double valor, LocalDate dataVencimento, String metodoPagamento) {
        this.descricao = descricao;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.metodoPagamento = metodoPagamento;
        this.statusPago = false; // Default: não pago
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    // Getters e Setters
    public String getDescricao() { return descricao; }
    public double getValor() { return valor; }
    public LocalDate getDataVencimento() { return dataVencimento; }
    public String getMetodoPagamento() { return metodoPagamento; }
    public boolean isStatusPago() { return statusPago; }
    public void setStatusPago(boolean statusPago) { this.statusPago = statusPago; }

    @Override
    public String toString() {
        return "Descrição: " + descricao + 
               ", Valor: " + valor +
               ", Vencimento: " + dataVencimento +
               ", Status: " + (statusPago ? "Pago" : "Pendente");
    }
    
}
