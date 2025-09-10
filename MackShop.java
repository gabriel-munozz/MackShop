import java.util.Scanner;
public class MackShop {
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);

        int [] idsProdutos = {};
        String [] nomesProdutos = {};
        double [] precosProdutos = {};
        int [] estoqueProdutos = {};

        int [] vendaAtualIds = {};
        int [] vendaAtualQuantidades = {};

        int [] historicoIdsPedidos = {};
        int [] historicoValoresPedidos = {};
        int [][] historicoItensPedidos= {};

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
        int opcao = entrada.nextInt();

        if (opcao == 1) {
            
        }
        else if (opcao == 2) {
        
        }
    }
}