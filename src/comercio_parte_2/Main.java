package comercio_parte_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Comercio comercio = new Comercio();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ola Seja Bem Vindo!!");
		listar_opcoes();
		int opcao = 0;
		
		while(opcao != 7) {
			
			System.out.print("\nDigite uma opcao: ");
			opcao = sc.nextInt();
		
			switch(opcao) {
			
			//listar produtos
			case(1):
				System.out.println("[1] --> Ver Todos os produtos da loja");
				System.out.println("[2] --> Ver Todos os produtos de uma categoria");
				System.out.print("Digite uma opcao: ");
				int opcao_escolha = sc.nextInt();
				
				if(opcao_escolha == 1) {
				comercio.listar_produtos();
				
				}
				else if(opcao_escolha == 2) {
					System.out.print("Digite uma das categorias [1] Eletronico || [2] Periferico");
					int opcao_categoria = sc.nextInt();
					comercio.listar_produtos_categoria(opcao_categoria);
				}
				else {
					System.out.println("opcao invalida!!!");
				}	
				break;
				
			//cadastrar novo produto	
			case(2):
				System.out.print("nome do produto: ");
				sc.nextLine();
				String nome_produto = sc.nextLine();
				
				System.out.print("Qual o codigo do produto: ");
				int codigo = sc.nextInt();
				
				if(comercio.verificar_codigo(codigo) == false) {
						System.out.print("Qual a categoria do produto:  ");
						System.out.println("Categorias: [ 1 ] Eletronico | [ 2 ] Periferico |");
						int categoria = sc.nextInt();
						
						// variaveis criadas para poder entrar no comando IF, else if
						int polegada = 0;
						int memoria_ram =0;
						String marca = "";
						String cor = "";
						
						if(categoria == 1) {
							System.out.print("Digite a polegada do produto: ");
							polegada = sc.nextInt();
							System.out.print("Digite a memoria ram do produto: ");
							memoria_ram = sc.nextInt();
							System.out.print("Digite a marca do produto: ");
							sc.nextLine();
							marca = sc.nextLine();
							}
						else if(categoria == 2) {
							System.out.print("Digite a cor do produto: ");
							sc.nextLine();
							cor = sc.nextLine();
						}
						else {
							System.out.println("Categoria nao exite!!!");
						}
						
						System.out.print("Qual foi o custo de compra: ");
						double custo_de_compra = sc.nextDouble();
						
						System.out.print("Qual vai ser o valor de venda: ");
						double custo_de_venda = sc.nextDouble();
						
						comercio.cadastrar_produto(nome_produto, codigo, categoria, custo_de_compra, custo_de_venda, polegada, memoria_ram, marca, cor);
						comercio.guardar_informacao_txt(comercio.getProdutos());
						System.out.println("Cadastrado com SUCESSO!!!");
					}
					
				else {
					System.out.println("Este codigo ja existe!!!");
				}
				break;
				
			// add estoque ao produto	
			case(3):
				comercio.listar_produtos();
				System.out.print("\nQual produto voce quer adicionar estoque, Digite pelo codigo: ");
				int pesquisar_por_codigo = sc.nextInt();
				System.out.print("Quanto voce quer adicionar de estoque: ");
				int quantidade_add_estoque = sc.nextInt();
				
				comercio.adicionar_estoque(pesquisar_por_codigo, quantidade_add_estoque);
				break;
				
			// remover produto	
			case(4):
				comercio.listar_produtos();
				System.out.print("\nQual produto voce quer remover, digite o codigo do produto: ");
				int codigo_de_produto = sc.nextInt();
				System.out.println("Voce tem certeza que deseja remover o produto [s/n]: ");
				sc.nextLine();
				String confirmar_remocao = sc.nextLine();
				
				comercio.removerProduto(codigo_de_produto, confirmar_remocao);
				break;
				
			// vender estoque do produto	
			case(5):
				comercio.listar_produtos();
				System.out.print("\nDigite o codigo do produto para vender o estoque: ");
				int codigo_do_produto = sc.nextInt();
				System.out.print("Quanto voce quer vender de estoque: ");
				int qntdd_de_estoque = sc.nextInt();
				
				comercio.vender_estoque(codigo_do_produto, qntdd_de_estoque);
				break;
				
			// relatorio de compras e vendas	
			case(6):
				comercio.relatorio();
				break;
				}			
		}
		System.out.println("Obrigado por usar nosso programa, VOLTE SEMPRE :)");		
	}
	
	public static void listar_opcoes() {			
			System.out.println("1) Lista os produtos");
			System.out.println("2) Cadastrar um novo produto");
			System.out.println("3) Adicionar estoque ao produto");
			System.out.println("4) Remover um produto");
			System.out.println("5) Vender um produtos do comercio");
			System.out.println("6) Relatorio de compra e vendas");
			System.out.println("7) Sair do programa");			
		}
	}
