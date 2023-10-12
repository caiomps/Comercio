package comercio_parte_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Comercio {

	// atributos
		private double saldo;
		private List<Produto> produtos = new ArrayList<>();
		
	// construtor
	 	public Comercio() {
			this.saldo = 1000;
			getGuardarInformacaoTxt();
		}
		
		public void listar_produtos() {
			if(produtos.isEmpty()) {
				System.out.println("A lista esta vazia, NENHUM produto cadastrado!!!");
			}
			else {
				System.out.printf("\nSaldo: %.2fR$ \n", this.saldo);
				
				for(Produto produto:produtos) {		
					System.out.printf("%s (cod.: %d || estoque: %d || categoria: %s || custo de compra: %.2f || valor de venda: %.2f)\n"
							, produto.getNome(),produto.getCodigo(), produto.getEstoque(), produto.getCategoria(), produto.getValor_compra(), produto.getValor_venda() );
				}
			}
		}
		
		public void listar_produtos_categoria(int opcao_categoria) {
			
			String categoria  = null;
			if(opcao_categoria == 1) {
				categoria = "Eletronico";
			}
			else if(opcao_categoria == 2) {
				categoria  = "Periferico";
			}
			if(produtos.isEmpty()) {
				System.out.println("A lista esta vazia, NENHUM produto cadastrado!!!");
			}
			else {
				System.out.printf("Saldo : %.2fR$", this.saldo);
				for(Produto produto : produtos) {
					if(produto.getCategoria().equals(categoria)) {						
						produto.listar(true);
					}
				}
			}
		}
		
		public boolean verificar_codigo(int codigo) {
					
			boolean existe_codigo = false;
				for(Produto produto : produtos) {
					if(produto.getCodigo() == codigo) {
						existe_codigo = true;
					}
				}
			return existe_codigo;
		}
		
		public Produto getProduto_por_codigo(int codigo) {

			Produto p1 = null;
			for(Produto produto : produtos) {
				if(produto.getCodigo() == codigo) {
					p1 = produto;
					return p1;
				}
			}
			return null;
		}
		
		public void cadastrar_produto(String nome,int codigo, int categoria, double custo_compra, double custo_venda, int polegada, int memoria_ram, String marca, String cor) {
						
				if(categoria == 1) {					
					Eletronico e1 = new Eletronico(nome, codigo, polegada, memoria_ram, marca);
					e1.setValor_compra(custo_compra);
					e1.setValor_venda(custo_venda);
					e1.setCategoria("Eletronico");
					produtos.add(e1);
				}		
				else if(categoria == 2) {
					Periferico p1 = new Periferico(nome, codigo, cor);
					p1.setValor_compra(custo_compra);
					p1.setValor_venda(custo_venda);
					p1.setCategoria("Periferico");
					produtos.add(p1);
				}	
			}
		
		public void adicionar_estoque(int codigo, int estoque) {
			    // retonar o produto por meio da funcao getProduto_por_codigo(codigo)
				Produto produto_por_codigo = getProduto_por_codigo(codigo);	
				
				if(produto_por_codigo == null) {	
					System.out.println("Este codigo NAO existe!!!");
				}
				else if(produto_por_codigo != null) {
					double preco_da_qntdd_de_produto = estoque * produto_por_codigo.getValor_compra();
					
					if(this.saldo >= preco_da_qntdd_de_produto) {
						produto_por_codigo.setEstoque(produto_por_codigo.getEstoque() + estoque);
						produto_por_codigo.setComprado(true);
						produto_por_codigo.setQuantidade_comprado(produto_por_codigo.getQuantidade_comprado() + estoque);
						this.saldo -= preco_da_qntdd_de_produto;
						System.out.println("Estoque Adicionado com SUCESSO!!!");
					}
					else {
						System.out.println("Voce nao tem SALDO SUFICIENTE, para esta compra!!!");
					}
				}					
		}							
		
		public void removerProduto(int codigo, String confirmar_remocao) {
			Produto verificacao =  getProduto_por_codigo(codigo);
			
			//null na funcao criada significa que o codigo nao existe
			if(verificacao == null) {
				System.out.println("Este codigo NAO existe!!!");
			}
			else {
				if(confirmar_remocao.equals("s")) {
					produtos.remove(verificacao);
					System.out.println("produto REMOVIDO com sucesso!!!!");
				}
				else if(confirmar_remocao.equals("n")) {
					System.out.println("remocao Cancelada com sucesso");
				}
				else {
					System.out.println("Opcao invalida!!!");
				}
			}
		}
		
		public void vender_estoque(int codigo, int estoque) {			
			Produto produto_por_codigo = getProduto_por_codigo(codigo);
			
			if(produto_por_codigo == null) {
				System.out.println("Este codigo nao existe");
			}
			else{			
				if(produto_por_codigo.getEstoque() > 0) {
					
					produto_por_codigo.setVendido(true);
					produto_por_codigo.setQuantidade_vendido(produto_por_codigo.getQuantidade_vendido() + estoque);
					produto_por_codigo.setEstoque(produto_por_codigo.getEstoque() - estoque);
					this.saldo += estoque * produto_por_codigo.getValor_venda();
					System.out.println("Produto Vendido com SUCESSO!!!");
				}
				else {
					System.out.println("Voce nao tem saldo suficiente");
				}
			}
		}
		public void relatorio() {
			
			double lucro_comercio = 1000 - this.saldo;
			System.out.println("== RELATORIO ==");
			System.out.printf("\nlucro: %.2f R$\n", lucro_comercio);
			
			System.out.print("\nProdutos Comprados: ");
			for(Produto produto : produtos) {
				if(produto.isComprado() == true) {
				System.out.print(produto.getNome() + "| Quantidade: " + produto.getQuantidade_comprado() + " || ");
				}
			}
			
			System.out.print("\nProdutos Vendido: ");
			for(Produto produto : produtos) {
				if(produto.isVendido() == true) {
				System.out.print(produto.getNome() + "| Quantidade: " + produto.getQuantidade_vendido() + " || ");
				}
			}
		} 
		
		//guarda informacoes do txt
		public void guardar_informacao_txt( List<Produto> produto) {
			try {
				PrintWriter writer = new PrintWriter("arquivo.txt");
				for(Produto produtoo : produtos) {
					writer.write(produtoo.getNome() + "," + produtoo.getCodigo() + ","+ produtoo.getCategoria() + "," + produtoo.getValor_compra() + "," + produtoo.getValor_venda() + "\n");
				}
				writer.close();
			}
			catch(FileNotFoundException e) {
				System.out.println("Arquivo nao encontrado");
			}
		}	
		
		// ler o arquivo.txt
		public ArrayList<Produto> getGuardarInformacaoTxt(){
			
			ArrayList<Produto> produtos_txt = new ArrayList<Produto>();
			File arquivo = new File("arquivo.txt");
			
			try {
				Scanner sc = new Scanner(arquivo);
				while( sc.hasNextLine()) {
					String[] produto = sc.nextLine().split(",");
					Produto produto_carregado = new Produto(produto[0] ,Integer.parseInt(produto[1]));
					produto_carregado.setCategoria(produto[2]);
					produto_carregado.setValor_compra(Double.parseDouble(produto[3]));
					produto_carregado.setValor_venda(Double.parseDouble(produto[4]));
					produtos.add(produto_carregado);
					
				}
				for(Produto produtoo : produtos_txt) {
					produtos.add(produtoo);
				}
				sc.close();
			}
			catch (FileNotFoundException e) {
				System.out.println("Arquivo nao encontrado!!!");
			}
			return produtos_txt;
		}
		
		// metodos getters and setters
		public double getSaldo() {
			return saldo;
		}
		
		public void setSaldo(double saldo) {
			this.saldo = saldo;
		}

		public List<Produto> getProdutos() {
			return produtos;
		}
		
		public void setProdutos(List<Produto> produtos) {
			this.produtos = produtos;
		}
}
