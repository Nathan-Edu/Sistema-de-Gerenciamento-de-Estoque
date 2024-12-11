package Aplicaçoes_Sistema_estoque;

import java.util.Scanner;
//Exemplo de um possivel Menu
public class Xmenu {
        public static void main(String[] args) {
            CadastroMaterialServ cadastroProdutoService = new CadastroMaterialServ();
            Scanner scanner = new Scanner(System.in);
            int opcao;

            do {
                System.out.println("\n----- Sistema de Gestão de Estoque -----");
                System.out.println("1. Cadastrar novo produto");
                System.out.println("2. Registrar movimentação (Entrada/Saída)");
                System.out.println("3. Listar todos os produtos");
                System.out.println("4. Listar todas as movimentações");
                System.out.println("5. Pesquisar produto no estoque");
                System.out.println("6. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir nova linha

                switch (opcao) {
                    case 1:
                        System.out.println("\n--- Cadastro de Produto ---");
                        System.out.print("ID do Material: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Descrição Curta: ");
                        String descricaoCurta = scanner.nextLine();
                        System.out.print("Descrição Longa: ");
                        String descricaoLonga = scanner.nextLine();
                        System.out.print("Quantidade Inicial: ");
                        int quantidade = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Unidade de Medida: ");
                        String unidadeMedida = scanner.nextLine();
                        System.out.print("Depósito: ");
                        String deposito = scanner.nextLine();

                        Material novoProduto = new Material(id, descricaoCurta, descricaoLonga, quantidade, unidadeMedida, deposito);
                        cadastroProdutoService.adicionaProduto(novoProduto);
                        break;

                    case 2:
                        System.out.println("\n--- Registrar Movimentação ---");
                        System.out.print("ID do Material: ");
                        int idMovimentacao = scanner.nextInt();
                        scanner.nextLine();
                        Material produtoMovimentacao = cadastroProdutoService.buscarProdutoPorId(idMovimentacao);
                        if (produtoMovimentacao == null) {
                            System.out.println("Produto não encontrado.");
                        } else {
                            System.out.print("Tipo de Movimentação (Entrada/Saída): ");
                            String tipo = scanner.nextLine();
                            System.out.print("Quantidade: ");
                            int qtdMovimentacao = scanner.nextInt();
                            scanner.nextLine();
                            cadastroProdutoService.registrarMovimentacao(produtoMovimentacao, tipo, qtdMovimentacao);
                        }
                        break;

                    case 3:
                        cadastroProdutoService.listarProdutos();
                        break;

                    case 4:
                        cadastroProdutoService.listarMovimentacao();
                        break;

                    case 5:
                        System.out.println("\n--- Pesquisa de Produto ---");
                        System.out.print("Digite o termo de busca: ");
                        String termoBusca = scanner.nextLine();
                        cadastroProdutoService.pesquisarProduto(termoBusca);
                        break;

                    case 6:
                        System.out.println("Saindo do sistema...");
                        break;

                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } while (opcao != 6);

            scanner.close();
        }
    }


