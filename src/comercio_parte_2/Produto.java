package comercio_parte_2;

public class Produto {

	    //atributos
		private String nome;
		private String categoria;
		private int estoque;
		private int codigo;
		private double valor_compra;
		private double valor_venda;
		private int quantidade_comprado;
		private int quantidade_vendido;
		private boolean comprado;
		private boolean vendido;

		// construtor
		public Produto(String nome, int codigo) {
			this.nome = nome;
			this.codigo  = codigo;;
		}
			
		public void listar(boolean produto) {
			 System.out.println("nome = " + nome + ", estoque = " + estoque + ", codigo = " + codigo + ", valor_compra = "
					+ valor_compra + ", valor_venda = " + valor_venda + ", categoria = " + categoria);			 
		}

		// getters and setters
		public String getCategoria() {
			return categoria;
		}

		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}


		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public int getEstoque() {
			return estoque;
		}

		public void setEstoque(int estoque) {
			this.estoque = estoque;
		}

		public int getCodigo() {
			return codigo;
		}

		public double getValor_compra() {
			return valor_compra;
		}

		public void setValor_compra(double valor_compra) {
			this.valor_compra = valor_compra;
		}

		public double getValor_venda() {
			return valor_venda;
		}

		public void setValor_venda(double valor_venda) {
			this.valor_venda = valor_venda;
		}
		public boolean isComprado() {
			return comprado;
		}

		public void setComprado(boolean comprado) {
			this.comprado = comprado;
		}

		public boolean isVendido() {
			return vendido;
		}

		public void setVendido(boolean vendido) {
			this.vendido = vendido;
		}

		public int getQuantidade_comprado() {
			return quantidade_comprado;
		}

		public void setQuantidade_comprado(int quantidade_comprado) {
			this.quantidade_comprado = quantidade_comprado;
		}

		public int getQuantidade_vendido() {
			return quantidade_vendido;
		}

		public void setQuantidade_vendido(int quantidade_vendido) {
			this.quantidade_vendido = quantidade_vendido;
		}		
}
