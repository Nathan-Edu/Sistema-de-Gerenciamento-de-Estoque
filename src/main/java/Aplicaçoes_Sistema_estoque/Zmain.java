package Aplicaçoes_Sistema_estoque;

public class Zmain {
    public static void main(String[] args) {
        CadastroMaterialServ cadastroProdutoService = new CadastroMaterialServ();

        Material produto1 = new Material(1, "Parafuso", "Parafuso de aço inoxidável 5mm", 100, "unidade", "Depósito A");
        Material produto2 = new Material(2, "Cimento", "Cimento Portland de alta resistência", 50, "saco", "Depósito B");

        cadastroProdutoService.adicionaProduto(produto1);
        cadastroProdutoService.adicionaProduto(produto2);

        cadastroProdutoService.registrarMovimentacao(produto1, "Entrada", 20);
        cadastroProdutoService.registrarMovimentacao(produto1, "Saída", 50);
        cadastroProdutoService.registrarMovimentacao(produto2, "Saída", 60);

        cadastroProdutoService.listarProdutos();
        cadastroProdutoService.listarMovimentacao();
        cadastroProdutoService.gerarRelatorioEstoq();
    }
}
