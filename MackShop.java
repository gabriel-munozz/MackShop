import java.util.Scanner;
public class MackShop {
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);

        int[] idsProdutos = null;
        String[] nomesProdutos = null;
        double[] precosProdutos = null;
        int[] estoqueProdutos = null;

        int[] vendaAtualIds = {};
        int[] vendaAtualQuantidades = {};

        int[] historicoIdsPedidos = {};
        int[] historicoValoresPedidos = {};
        int[][] historicoItensPedidos= {};

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
            System.out.printf("Escolha uma opção: ");
            opcao = entrada.nextInt();
        
            switch (opcao) {
                case 1: 
                    idsProdutos = new int[]{100, 200, 300, 400};
                    nomesProdutos = new String[]{"Caderno", "Caneta", "Lápis", "Borracha"};
                    precosProdutos = new double[]{19.99, 1.99, 1.99, 2.99};
                    estoqueProdutos = new int[]{20, 40, 30, 25};

                System.out.println("Base inicializada!");
                break;
                
                case 2:

        }
    } while (opcao != 0);
    entrada.close();
    }
}