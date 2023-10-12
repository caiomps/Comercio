package comercio_parte_2;

public class Periferico extends Produto{
	
	// atributos
	private String cor;

	public Periferico(String nome, int codigo, String cor) {
		super(nome, codigo);
		this.cor = cor;
	}

	@Override
	public void listar(boolean produto) {
		System.out.printf("PERIFERICO -  %s (cod.: %d || estoque: %d || atributos: %s || custo de compra: %.2f || valor de venda: %.2f)\n"
				, super.getNome(), super.getCodigo(), super.getEstoque(), this.cor, super.getValor_compra(), super.getValor_venda());
			}

	//metodos getters and setters
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
}
