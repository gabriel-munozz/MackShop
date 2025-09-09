import java.util.Scanner;
public class MackShop {
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);

        System.out.println("1. Inicializar base");
        System.out.println("2. Exibir catálogo de produtos");
        System.out.println("3. Adicionar item à venda");
        System.out.println("4. Ver resumo da venda atual");
        System.out.println("5. Finalizar venda");
        System.out.println("6. Ver histórico de vendas");
        System.out.println("7. Buscar venda específica do histórico");
        System.out.printf("Escolha uma opção: ");
        int opcao = entrada.nextInt();
    }
}