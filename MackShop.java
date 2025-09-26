//Grupo: Gabriel Machado e Lucas Omine
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

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
                    reporEstoque(entrada);
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

        int pos = -1;
        for (int i = 0; i < idsProdutos.length; i++) {
            if (idsProdutos[i] == idVenda) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("Produto não encontrado!");
            return;
        }

        if (qtdeVenda > estoquesProdutos[pos]) {
            System.out.printf("Estoque insuficiente! Temos apenas %d unidades de %s.\n", estoquesProdutos[pos], nomesProdutos[pos]);
            return;
        }
        estoquesProdutos[pos] -= qtdeVenda;
        
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
        if (vendaAtualIds.length == 0) {
            System.out.println("Nenhum item no carrinho para finalizar!");
            return;
        }

        int novoIdPedido = historicoIdsPedidos.length + 1;  //A)Gera um novo ID para o Pedido.
        double total = 0;

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
            total += precosProdutos[pos] * qtde;
        }

        int[] novosIdsPedidos = new int[historicoIdsPedidos.length + 1];                        //b. Salva o ID do pedido e seu valor total nos vetores de histórico (historicoIdsPedidos, historicoValoresPedidos).
        double[] novosValoresPedidos = new double[historicoValoresPedidos.length + 1];

        for (int i = 0; i < historicoIdsPedidos.length; i++) {             
            novosIdsPedidos[i] = historicoIdsPedidos[i];
            novosValoresPedidos[i] = historicoValoresPedidos[i];
        }

        novosIdsPedidos[novosIdsPedidos.length - 1] = novoIdPedido;
        novosValoresPedidos[novosValoresPedidos.length - 1] = total;

        historicoIdsPedidos = novosIdsPedidos;        
        historicoValoresPedidos = novosValoresPedidos;

        int[][] novaMatrizHistorico = new int[historicoItensVendidos.length + 1][];     //c. Para cada item na venda atual, adiciona uma linha na matriz historicoItensVendidos.
        for (int i = 0; i < historicoItensVendidos.length; i++) {
            novaMatrizHistorico[i] = historicoItensVendidos[i];
        }
        int[] itensDaVenda = new int[vendaAtualIds.length * 2];
        for (int i = 0; i < vendaAtualIds.length; i++) {
            itensDaVenda[i * 2] = vendaAtualIds[i];
            itensDaVenda[i * 2 + 1] = vendaAtualQuantidades[i];
        }
        novaMatrizHistorico[novaMatrizHistorico.length - 1] = itensDaVenda;
        historicoItensVendidos = novaMatrizHistorico;

        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHora = agora.format(formato);

        //e. Chama o método para imprimir a nota fiscal formatada.
        System.out.println("*********************************************************************************************");
        System.out.println("*                                      MACKSHOP                                             *");
        System.out.println("*                                CNPJ: 12.345.678/0001-99                                   *");
        System.out.println("*********************************************************************************************");
        System.out.println("*                           NOTA FISCAL - VENDA AO CONSUMIDOR                               *");
        System.out.printf ("* Pedido ID: %-79d*\n", novoIdPedido);
        System.out.printf ("* Data de Emissão: %-73s*\n", dataHora);
        System.out.println("*********************************************************************************************");
        System.out.println("* # | ID   | DESCRIÇÃO          | QTD | VL. UNIT. | VL. TOTAL                               *");
        System.out.println("---------------------------------------------------------------------------------------------");
    
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
                double precoUnit = precosProdutos[pos];
                double valorTotal = precoUnit * qtde;
                System.out.printf("* %-2d| %-4d| %-18s| %-3d | R$ %-7.2f| R$ %-38.2f *\n", (i + 1), id, nomesProdutos[pos], qtde, precoUnit, valorTotal);

        }

        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("* SUBTOTAL | R$ %-75.2f *\n", total);
        System.out.printf("* TOTAL    | R$ %-75.2f *\n", total);
        System.out.println("*********************************************************************************************");
        System.out.println("*               OBRIGADO PELA PREFERÊNCIA! VOLTE SEMPRE!                                    *");
        System.out.println("*********************************************************************************************");
    
        //f. Limpa os vetores da venda atual, deixando o sistema pronto para a próxima transação.
        vendaAtualIds = new int[0];
        vendaAtualQuantidades = new int[0];
    }   


    public static void historicoVenda() {
        if (historicoIdsPedidos.length == 0) {
            System.out.println("Nenhuma venda registrada ainda!");
            return;
        }

        System.out.println("\n===== HISTÓRICO DE VENDAS =====");

        for (int i = 0; i < historicoIdsPedidos.length; i++) {
            int idPedido = historicoIdsPedidos[i];
            double valorTotal = historicoValoresPedidos[i];
            int[] itens = historicoItensVendidos[i];

            System.out.printf("\nPedido ID: %d - Valor Total: %.2f\n", idPedido, valorTotal);
            System.out.println("Itens vendidos:");

            for (int j = 0; j < itens.length; j += 2) {
                int idProduto = itens[j];
                int qtde = itens[j + 1];

                int pos = -1;
                for (int k = 0; k < idsProdutos.length; k++) {
                    if (idsProdutos[k] == idProduto) {
                        pos = k;
                        break;
                    }
                }
               System.out.printf("- %s | Qtde: %d | Preço unitário: %.2f\n", nomesProdutos[pos], qtde, precosProdutos[pos]);
  
            }
        }   

        System.out.println("==============================\n");
    }   

    public static void buscarVenda() {
        if (historicoIdsPedidos.length == 0) {
            System.out.println("Nenhuma venda registrada ainda!");
            return;
        }

        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o ID do pedido que deseja buscar: ");
        int idBusca = entrada.nextInt();
    
        int indice = -1;
        for (int i = 0; i < historicoIdsPedidos.length; i++) {
            if (historicoIdsPedidos[i] == idBusca) {
                indice = i;
                break;
            }
        }

        if (indice == -1) {
            System.out.println("Pedido não encontrado!");
            return;
        }

        int[] itens = historicoItensVendidos[indice];
        double total = historicoValoresPedidos[indice];

        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHora = agora.format(formato);

        System.out.println("*********************************************************************************************");
        System.out.println("*                                      MACKSHOP                                             *");
        System.out.println("*                                CNPJ: 12.345.678/0001-99                                   *");
        System.out.println("*********************************************************************************************");
        System.out.println("*                           NOTA FISCAL - VENDA AO CONSUMIDOR                               *");
        System.out.printf("* Pedido ID: %-79d*\n", idBusca);
        System.out.printf("* Data de Consulta: %-73s*\n", dataHora);
        System.out.println("*********************************************************************************************");
        System.out.println("* # | ID   | DESCRIÇÃO          | QTD | VL. UNIT. | VL. TOTAL                               *");
        System.out.println("---------------------------------------------------------------------------------------------");
    
        for (int i = 0; i < itens.length; i += 2) {
            int idProduto = itens[i];
            int qtde = itens[i + 1];
    
            int pos = -1;
            for (int j = 0; j < idsProdutos.length; j++) {
                if (idsProdutos[j] == idProduto) {
                    pos = j;
                    break;
                }
            }

            double valorUnit = precosProdutos[pos];
            double valorTotal = valorUnit * qtde;
            System.out.printf("* %-2d| %-4d| %-18s| %-3d | R$ %-7.2f| R$ %-38.2f *\n", (i / 2 + 1), idProduto, nomesProdutos[pos], qtde, valorUnit, valorTotal);
        
        }

        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.printf("* SUBTOTAL | R$ %-75.2f *\n", total);
        System.out.printf("* TOTAL    | R$ %-75.2f *\n", total);
        System.out.println("*********************************************************************************************");
        System.out.println("*               OBRIGADO PELA PREFERÊNCIA! VOLTE SEMPRE!                                    *");
        System.out.println("*********************************************************************************************");
    }
    public static void reporEstoque(Scanner entrada) {
        System.out.print("Digite o ID do produto: ");
        int id = entrada.nextInt();
        System.out.print("Digite a quantidade a repor: ");
        int qtde = entrada.nextInt();

        for (int i = 0; i < idsProdutos.length; i++) {
            if (idsProdutos[i] == id) {
                estoquesProdutos[i] += qtde;
                System.out.printf("Novo estoque de %d para o %s\n", estoquesProdutos[i], nomesProdutos[i]);
                return;
            }
        }
        System.out.println("Produto não encontrado!");

    }

    public static void relatorioEstoque() {
        System.out.println("Produtos com estoque baixo (menos de 8 unidades):");
        boolean algumBaixo = false;

        for (int i = 0; i < idsProdutos.length; i++) {
            if (estoquesProdutos[i] < 8) {
                System.out.printf("ID: %d | Nome: %s | Estoque: %d", idsProdutos[i], nomesProdutos[i], estoquesProdutos[i]);
                algumBaixo = true;
            }
        }

        if (!algumBaixo) {
            System.out.println("Nenhum produto com estoque baixo.");
        }
    }
}
