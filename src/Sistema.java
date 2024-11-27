import java.util.Scanner;

public class Sistema {
    private static Scanner scanner = new Scanner(System.in);
    private static Estoque estoque = new Estoque();
    private static Caixa caixa = new Caixa(0);
    private static Venda vendaAtual = null;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMenu Principal:");
            System.out.println("1 - Gerencial");
            System.out.println("2 - Caixa");
            System.out.println("3 - Fechar sistema");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            switch (opcao) {
                case 1:
                    menuGerencial();
                    break;
                case 2:
                    menuCaixa();
                    break;
                case 3:
                    System.out.println("Sistema sendo finalizado...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuGerencial() {
        while (true) {
            System.out.println("\nMenu Gerencial:");
            System.out.println("1 - Cadastrar produtos");
            System.out.println("2 - Consultar produtos");
            System.out.println("3 - Relatórios");
            System.out.println("4 - Voltar para Menu Principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarProdutos();
                    break;
                case 2:
                    consultarProdutos();
                    break;
                case 3:
                    relatorios();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuCaixa() {
        while (true) {
            System.out.println("\nMenu Caixa:");
            System.out.println("1 - Abrir Caixa");
            System.out.println("2 - Voltar para Menu Principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    abrirCaixa();
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void abrirCaixa() {
        System.out.print("Deseja abrir caixa? (S/N): ");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("S")) {
            System.out.print("Informe o valor do suprimento inicial: ");
            double valorSuprimento = scanner.nextDouble();
            caixa = new Caixa(valorSuprimento);
            System.out.println("Caixa aberto com sucesso!");
            menuVendas();
        }
    }

    private static void menuVendas() {
        vendaAtual = new Venda();
        while (true) {
            System.out.println("\nMenu Vendas:");
            System.out.println("1 - Adicionar Produto");
            System.out.println("2 - Cancelar Item");
            System.out.println("3 - Cancelar Venda");
            System.out.println("4 - Finalizar Venda");
            System.out.println("5 - Voltar ao Menu Caixa");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarProdutoVenda();
                    break;
                case 2:
                    cancelarProdutoVenda();
                    break;
                case 3:
                    cancelarVenda();
                    return;
                case 4:
                    finalizarVenda();
                    return;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }


    private static void cadastrarProdutos() {
        System.out.println("\nCadastrar Produto:");
        System.out.println("1 - Alimento ou Utensílio");
        System.out.println("2 - Eletrodoméstico");
        System.out.print("Escolha o tipo de produto: ");
        int tipoProduto = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha

        System.out.print("Informe o código do produto: ");
        String codigo = scanner.nextLine();

        System.out.print("Informe o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Informe o valor unitário do produto: ");
        double valorUnitario = scanner.nextDouble();

        System.out.print("Informe a quantidade em estoque: ");
        int estoqueQuantidade = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha

        if (tipoProduto == 1) {
            System.out.print("Informe a validade (em dias): ");
            int validadeDias = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            AlimentoUtensilio produto = new AlimentoUtensilio(codigo, nome, valorUnitario, estoqueQuantidade, validadeDias);
            estoque.adicionarProduto(produto);
            System.out.println("Produto de Alimento/Utensílio cadastrado com sucesso!");

        } else if (tipoProduto == 2) {
            System.out.print("Informe a garantia (em meses): ");
            int garantiaMeses = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            Eletrodomestico produto = new Eletrodomestico(codigo, nome, valorUnitario, estoqueQuantidade, garantiaMeses);
            estoque.adicionarProduto(produto);
            System.out.println("Produto Eletrodoméstico cadastrado com sucesso!");
        } else {
            System.out.println("Opção inválida!");
        }
    }

    private static void consultarProdutos() {
        System.out.print("Informe o código do produto para consulta: ");
        String codigo = scanner.nextLine();

        Produto produto = estoque.consultarProduto(codigo);
        if (produto != null) {
            System.out.println("\nProduto encontrado: ");
            System.out.println(produto);
        } else {
            System.out.println("Produto não encontrado no estoque.");
        }
    }

    private static void relatorios() {
        System.out.println("\nRelatórios:");
        System.out.println("1 - Relatório de Estoque");
        System.out.println("2 - Relatório de Vendas");
        System.out.print("Escolha o tipo de relatório: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha

        if (opcao == 1) {
            System.out.println("\nRelatório de Estoque:");
            for (Produto produto : estoque.getProdutos().values()) {
                System.out.println(produto);
            }
        } else if (opcao == 2) {
            System.out.println("\nRelatório de Vendas:");
            System.out.println("Total de vendas: " + vendaAtual.getTotalVenda());
            System.out.println("Itens vendidos: ");
            for (Produto item : vendaAtual.getItens()) {
                System.out.println(item);
            }
        } else {
            System.out.println("Opção inválida!");
        }
    }

    private static void adicionarProdutoVenda() {
        System.out.print("Informe o código do produto para adicionar à venda: ");
        String codigo = scanner.nextLine();

        Produto produto = estoque.consultarProduto(codigo);
        if (produto != null) {
            System.out.print("Informe a quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            vendaAtual.adicionarProduto(produto, quantidade);
            estoque.editarEstoque(codigo, produto.getEstoque() - quantidade);
            System.out.println("Produto adicionado à venda!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private static void cancelarProdutoVenda() {
        System.out.print("Informe o código do produto para cancelar da venda: ");
        String codigo = scanner.nextLine();

        Produto produto = estoque.consultarProduto(codigo);
        if (produto != null) {
            vendaAtual.cancelarProduto(codigo);
            estoque.editarEstoque(codigo, produto.getEstoque() + 1); // Adiciona o produto de volta ao estoque
            System.out.println("Produto cancelado da venda.");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private static void cancelarVenda() {
        System.out.println("Venda cancelada!");
        // Restaurar estoque dos itens
        for (Produto item : vendaAtual.getItens()) {
            estoque.editarEstoque(item.getCodigo(), item.getEstoque() + 1); // Restaurar estoque
        }
        vendaAtual.finalizarVenda(); // Finaliza a venda e limpa os itens
    }

    private static void finalizarVenda() {
        double totalVenda = vendaAtual.getTotalVenda();
        caixa.adicionarSaldo(totalVenda);
        System.out.println("Venda finalizada com sucesso!");
        System.out.println("Total da venda: " + totalVenda);
        vendaAtual.finalizarVenda();  // Zera os itens da venda
    }
}