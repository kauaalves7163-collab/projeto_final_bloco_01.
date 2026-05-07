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

					break;
				case 2:
					System.out.println("Listar todos os Produtos\n\n");
					
					produtos.listarTodas();

					break;
				case 3:
					System.out.println("Consultar dados do Produto - por ID\n\n");

					break;
				case 4:
					System.out.println("Atualizar dados do Produto\n\n");

					break;
				case 5:
					System.out.println("Apagar o Produto\n\n");

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
