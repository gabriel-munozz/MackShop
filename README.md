2. Exibir catálogo de produtos: Imprime a lista de produtos com estoque maior que zero, de forma
organizada.
3. Adicionar item à venda: Solicita ID e quantidade ao usuário, valida se o produto existe e se há
estoque suficiente. Se válido, adiciona o item aos vetores da venda atual.
4. Ver resumo da venda atual: Exibe os itens, subtotais e o total da venda atual de forma clara.
5. Finalizar Venda: Executa a seguinte sequência:
a. Gera um novo ID para o Pedido.
b. Salva o ID do pedido e seu valor total nos vetores de histórico (historicoIdsPedidos,
historicoValoresPedidos).
c. Para cada item na venda atual, adiciona uma linha na matriz historicoItensVendidos.
d. Debita a quantidade do estoquesProdutos
e. Chama o método para imprimir a nota fiscal formatada.
f. Limpa os vetores da venda atual, deixando o sistema pronto para a próxima transação.
6. Ver histórico de vendas: Percorre os vetores de histórico e imprime um resumo de todas as vendas
finalizadas (ex: Pedido ID: 1001 - Valor Total: R$ 1070.50).
7. Buscar venda específica do histórico: Solicita um ID de Pedido ao usuário. O sistema deve então
percorrer a matriz historicoItensVendidos, encontrar todos os itens correspondentes àquele pedido e
reimprimir a nota fiscal completa daquela transação.
8. (Admin) Repor estoque: Solicita um ID de produto e uma quantidade, e adiciona o valor ao estoque
correspondente.
9. (Admin) Relatório de estoque baixo: Imprime uma lista de todos os produtos cujo estoque esteja
abaixo de um limiar pré-definido (ex: 10 unidades).
5. Esquema da nota fiscal
Este é o formato que o método imprimirNotaFiscal deve gerar no console. O uso de System.out.printf() é
altamente recomendado para o alinhamento das colunas.
*********************************************************************************************
* MACKSHOP *
* CNPJ: 12.345.678/0001-99 *
*********************************************************************************************
* NOTA FISCAL - VENDA AO CONSUMIDOR *
* Pedido ID: 1001 *
* Data de Emissão: 01/09/2025 15:15:30 *
*********************************************************************************************
* # | ID | DESCRIÇÃO | QTD | VL. UNIT. | VL. TOTAL *
-----------------------------------------------------------------------------------------------------------
* 1 | 101 | Mouse Gamer | 2 | R$ 150,00 | R$ 300,00 *
* 2 | 203 | Teclado Mecânico | 1 | R$ 350,00 | R$ 350,00 *
* 3 | 401 | Headset 7.1 | 1 | R$ 420,50 | R$ 420,50 *
-----------------------------------------------------------------------------------------------------------
* SUBTOTAL | R$ 1070,50 *
* TOTAL | R$ 1070,50 *
*********************************************************************************************
* OBRIGADO PELA PREFERÊNCIA! VOLTE SEMPRE! *
*********************************************************************************************