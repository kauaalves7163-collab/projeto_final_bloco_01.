package mercado;

import java.util.Scanner;
import java.util.InputMismatchException; // Import necessário para a Exception
import mercado.controller.ProdutoController;
import mercado.model.NaoPerecivel;

public class Menu{

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		ProdutoController produtos = new ProdutoController();
		
		produtos.cadastrar(new NaoPerecivel(produtos.gerarNumero(), "Arroz 5kg", 1, 25.00f, "Alimentos"));
		produtos.cadastrar(new NaoPerecivel(produtos.gerarNumero(), "Feijão 1kg", 1, 8.50f, "Alimentos"));

		int opcao;
		String nome, setor;
		float preco;

		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                MERCADO TECH                         ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Cadastrar Produto                    ");
			System.out.println("            2 - Listar todos os Produtos             ");
			System.out.println("            3 - Consultar Produto por ID             ");
			System.out.println("            4 - Atualizar Dados do Produto           ");
			System.out.println("            5 - Apagar Produto                       ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");


			try {
			    opcao = leia.nextInt();
			} catch (InputMismatchException e) {
			    System.out.println("\nERRO: Digite apenas números inteiros!");
			    leia.nextLine(); // Limpa o que o usuário digitou de errado
			    opcao = -1;      // Garante que o switch não faça nada errado
			}

			if (opcao == 0) {
				System.out.println("\nMercado Tech - O seu dia a dia começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println("Cadastrar Produto\n\n");

				    System.out.println("Digite o Nome do Produto: ");
				    leia.nextLine(); // Limpa o buffer do nextInt lá do menu
				    nome = leia.nextLine(); // Agora sim o nome será lido!

				    System.out.println("Digite o Preço do Produto: ");
				    preco = leia.nextFloat();

				    System.out.println("Digite o Setor (Ex: Alimentos, Bebidas): ");
				    leia.nextLine(); // Limpa o buffer do float
				    setor = leia.nextLine();

				 // O ID é gerado automaticamente e o Tipo é sempre 1 (Não Perecível)
				    produtos.cadastrar(new NaoPerecivel(produtos.gerarNumero(), nome, 1, preco, setor));
				    
					break;
				case 2:
					System.out.println("Listar todos os Produtos\n\n");
					
					produtos.listarTodas();

					break;
				case 3:
					System.out.println("Consultar dados do Produto - por ID\n\n");
					
					System.out.println("Digite o ID do produto: ");
					int idBusca = leia.nextInt();  
					produtos.procurarPorId(idBusca);
					break;
				case 4:
					System.out.println("Atualizar dados do Produto\n\n");
					System.out.println("Digite o ID do produto que deseja atualizar: ");
				    int idAtualizar = leia.nextInt();
				    
				    var buscaProduto = produtos.buscarNaCollection(idAtualizar);

				    if (buscaProduto != null) {
				        System.out.println("Digite o Novo Nome: ");
				        leia.nextLine(); 
				        String novoNome = leia.nextLine();
				        
				        System.out.println("Digite o Novo Preço: ");
				        float novoPreco = leia.nextFloat();
				        
				        System.out.println("Digite o Novo Setor: ");
				        leia.nextLine();
				        String novoSetor = leia.nextLine();
				        
				        produtos.atualizar(new NaoPerecivel(idAtualizar, novoNome, 1, novoPreco, novoSetor));
				    } else {
				        System.out.println("\nProduto não encontrado!");
				    }

					break;
				case 5:
					System.out.println("Apagar o Produto\n\n");
					System.out.println("Digite o ID do produto que deseja apagar: ");
				    int idApagar = leia.nextInt();
				    produtos.deletar(idApagar);

					break;
				default:
					System.out.println("\nOpção Inválida!\n");
					break;
			}
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Kauã Alves Cazemiro");
		System.out.println("github.com/kauaalves7163-collab");
		System.out.println("*********************************************************");
		
	}

}
