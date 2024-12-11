package Aplicaçoes_Sistema_estoque;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MovimentacaoEstoq {
    private Material produto;
    private String tipo_Acao; // se o produto vai dar a entrada ou saida do mesmo.
    private int quantidade;
    private LocalDateTime dataHora;

    public MovimentacaoEstoq(Material produto, String tipo_Acao, int quantidade){
        this.produto = produto;
        this.tipo_Acao = tipo_Acao;
        this.quantidade = quantidade;
        this.dataHora = LocalDateTime.now();
    }

    public Material getProduto() {
        return produto;
    }

    public void setProduto(Material produto) {
        this.produto = produto;
    }

    public String getTipo_Acao() {
        return tipo_Acao;
    }

    public void setTipo_Acao(String tipo_Acao) {
        this.tipo_Acao = tipo_Acao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return "Movimentação -\n" +
                "Produto: " + produto.getDescricao_curta() + "\n" +
                "Tipo: " + tipo_Acao + "\n" +
                "Quantidade: " + quantidade + "\n" +
                "Data/Hora: " + dataHora.format(formatter) + "\n";
    }
}
