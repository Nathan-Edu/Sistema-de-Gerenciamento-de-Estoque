package Aplicaçoes_Sistema_estoque;

import java.util.ArrayList;
import java.util.List;

public class CadastroMaterialServ {
    private List<Material> produtos = new ArrayList<>();
    private List<MovimentacaoEstoq> movimentacoes = new ArrayList<>();

    public void adicionaProduto(Material produto) {
        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso:\n" + produto);
    }

    public Material buscarProdutoPorId(int id) {
        for (Material produto : produtos) {
            if (produto.getId_material() == id) {
                return produto;
            }
        }
        System.out.println("Produto com ID " + id + " não encontrado.");
        return null;
    }

    public void registrarMovimentacao(Material produto, String tipo, int quantidade) {
        if (tipo.equalsIgnoreCase("Saída") && produto.getQuantidade() < quantidade) {
            System.out.println("Erro: Quantidade insuficiente em estoque.\n");
            return;
        }
        MovimentacaoEstoq movimentacao = new MovimentacaoEstoq(produto, tipo, quantidade);
        movimentacoes.add(movimentacao);

        if (tipo.equalsIgnoreCase("Entrada")) {
            produto.setQuantidade(produto.getQuantidade() + quantidade);
        } else if (tipo.equalsIgnoreCase("Saída")) {
            produto.setQuantidade(produto.getQuantidade() - quantidade);
        }

        System.out.println("----Movimentação registrada com sucesso----\n" + movimentacao);
    }

    public void listarMovimentacao() {
        if (movimentacoes.isEmpty()) {
            System.out.println("Nenhuma Movimentação registrada.\n");
        } else {
            System.out.println("Lista de Movimentação -\n");
            for (MovimentacaoEstoq movimentacao : movimentacoes) {
                System.out.println(movimentacao);
            }
        }
    }

    public List<Material> listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
        }
        return produtos;
    }


    public void gerarRelatorioEstoq() {
        System.out.println("Relatórios de Estoque -");
        for (Material produto : produtos) {
            String status = "Disponível";
            if (produto.getQuantidade() <= 0) {
                status = "Estado";
            }
            else if(produto.getQuantidade() < 10){
                status = "Baixa Quantiadade (Rebastecer)";
            }
            System.out.printf("Produto: %s | ID: %d | Quantidade: %d | Status: %s\n",
                    produto.getDescricao_curta(), produto.getId_material(), produto.getQuantidade(), status);
        }
    }

    public void pesquisarProduto(String termoBusca) {
        System.out.println("Resultado da Pesquisa:");
        boolean encontrou = false;
        for (Material produto : produtos) {
            if (produto.getDescricao_curta().toLowerCase().contains(termoBusca.toLowerCase()) ||
                    produto.getDescricao_Longa().toLowerCase().contains(termoBusca.toLowerCase())) {
                System.out.println(produto);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum produto encontrado com o termo: " + termoBusca);
        }
    }
}

