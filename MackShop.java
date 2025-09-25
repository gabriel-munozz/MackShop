import java.util.Scanner;
public class MackShop {

        static int[] idsProdutos = {};
        static String[] nomesProdutos = {};
        static double[] precosProdutos = {};
        static int[] estoquesProdutos = {};

        static int[] vendaAtualIds = {};
        static int[] vendaAtualQuantidades = {};

        static int[] historicoIdsPedidos = {};
        static double[] historicoValoresPedidos = {};
        static int[][] historicoItensVendidos = {};

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int opcao = 0;
        do {
            System.out.println("1. Inicializar base");
            System.out.println("2. Exibir catálogo de produtos");
            System.out.println("3. Adicionar item à venda");
            System.out.println("4. Ver resumo da venda atual");
            System.out.println("5. Finalizar venda");
            System.out.println("6. Ver histórico de vendas");
            System.out.println("7. Buscar venda específica do histórico");
            System.out.println("8. (Admin) Repor estoque");
            System.out.println("9. (Admin) Relatório de estoque baixo");
            System.out.println("0. Sair");
            System.out.printf("Digite o valor que deseja: ");
            opcao = entrada.nextInt();

            switch (opcao) {
            case 1:
                inicializarBase();
                break;
            case 2:
                if (idsProdutos.length == 0) {
                    System.out.println("Inicialize a base primeiro!");

                }
                else {
                    catalogoProdutos();
                }
                break;

            case 3:
                if (idsProdutos.length == 0) {
                    System.out.println("Inicialize a base primeiro!");

                }
                else {
                    itemVenda(entrada);
                }
                break;

            case 4:
                if (idsProdutos.length == 0) {
                    System.out.println("Inicialize a base primeiro!");
                }
                else{
                    resumoVenda();
                }
                break;

            case 5:
                if (idsProdutos.length == 0) {
                    System.out.println("Inicialize a base primeiro!");
                }
                else{
                    finalizarVenda();
                }
                break;

            case 6:
                if (idsProdutos.length == 0) {
                    System.out.println("Inicialize a base primeiro!");
                }
                else{
                    historicoVenda();
                }
                break;

            case 7:
                if (idsProdutos.length == 0) {
                    System.out.println("Inicialize a base primeiro!");
                }
                else{
                    buscarVenda();
                }
                break;

            case 8:
                if (idsProdutos.length == 0) {
                    System.out.println("Inicialize a base primeiro!");
                }
                else{
                    reporEstoque();
                }
                break;

            case 9:
                if (idsProdutos.length == 0) {
                    System.out.println("Inicialize a base primeiro!");
                }
                else{
                    relatorioEstoque();
                }
                break;

            case 0:
                System.out.println("Programa finalizado!");
                break;

            default:
                System.out.println("Opção Inválida!");
            }
        }
        while (opcao != 0);
    }
    public static void inicializarBase() {
        idsProdutos = new int[] {100, 101, 102, 103};
        nomesProdutos = new String[] {"Caderno", "Caneta", "Lápis", "Borracha"};
        precosProdutos = new double[] {19.99, 2.99, 1.99, 2.99};
        estoquesProdutos = new int[] {30, 55, 42, 20};

        System.out.println("Base inicializada!");
    }

    public static void catalogoProdutos() {
        System.out.println("Catálogo de produtos:");
        
        for(int i = 0; i < idsProdutos.length; i++) {
            System.out.printf("ID: %d | Nome: %s | Qtde: %d | Preço: %.2f\n", idsProdutos[i], nomesProdutos[i], estoquesProdutos[i], precosProdutos[i]);
        }
    }
    
    public static void itemVenda(Scanner entrada) {
        System.out.print("Qual item deseja comprar (digite o ID): ");
        int idVenda = entrada.nextInt();
        
        System.out.print("Qual a quantidade: ");
        int qtdeVenda = entrada.nextInt();

        int[] novosIds = new int[vendaAtualIds.length + 1];
        int[] novasQtde = new int[vendaAtualQuantidades.length + 1];

        for (int i = 0; i < vendaAtualIds.length; i++) {
            novosIds[i] = vendaAtualIds[i];
            novasQtde[i] = vendaAtualQuantidades[i];
        }
        novosIds[novosIds.length - 1] = idVenda;
        novasQtde[novasQtde.length - 1] = qtdeVenda;

        vendaAtualIds = novosIds;
        vendaAtualQuantidades = novasQtde;

        System.out.println("Item adicionado ao carrinho!");
    }

    public static void resumoVenda () {
        if (vendaAtualIds.length == 0) {
        System.out.println("Nenhum item no carrinho!");
        return;
    }
        double total = 0;
        System.out.println("\nResumo da venda atual:");

        for (int i = 0; i < vendaAtualIds.length; i++) {
            int id = vendaAtualIds[i];
            int qtde = vendaAtualQuantidades[i];

            int pos = -1;
            for (int j = 0; j < idsProdutos.length; j++) {
                if (idsProdutos[j] == id) {
                    pos = j;
                    break;
                }
            }

            if (pos != -1) {
                double subtotal = precosProdutos[pos] * qtde;
                total += subtotal;
                System.out.printf("ID: %d | %s | Qtde: %d | Preço: %.2f | Subtotal: %.2f\n", id, nomesProdutos[pos], qtde, precosProdutos[pos], subtotal);
            } else {
                System.out.printf("ID %d não encontrado no catálogo!\n", id);
            }
        }
        System.out.printf("TOTAL: %.2f\n\n", total);
}

    public static void finalizarVenda() {

    }

    public static void historicoVenda() {

    }

    public static void buscarVenda() {

    }

    public static void reporEstoque() {

    }

    public static void relatorioEstoque() {

    }
}

