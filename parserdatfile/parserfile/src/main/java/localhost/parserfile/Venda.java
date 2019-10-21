package localhost.parserfile;

public class Venda {
	/**
	 * Este nao é o ID unico, é o valor '003' que identifica o tipo de linha no archivo origem.
	 */
    private String id;
    private String idDoItem;
    private int qtdeDoItem;
    private double preçoDoItem;
    
    /**
     * Para poder comparar e porem ordenar, se precisa que o campo seja de tipo Clase rapper, nao tipo primitiva. por isso usamos Double.
     * Este campo nao é dado, é calculado com qtdeDoItem * preçoDoItem.  
     */
    private Double venda;
    private String nomeDovendedor;
    
    
	/**
	 * @param id
	 * @param idDoItem
	 * @param qtdeDoItem
	 * @param preçoDoItem
	 * @param venda
	 * @param nomeDovendedor
	 */
	public Venda(String id, String idDoItem, int qtdeDoItem, double preçoDoItem, double venda, String nomeDovendedor) {
		super();
		this.id = id;
		this.idDoItem = idDoItem;
		this.qtdeDoItem = qtdeDoItem;
		this.preçoDoItem = preçoDoItem;
		this.venda = venda;
		this.nomeDovendedor = nomeDovendedor;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdDoItem() {
		return idDoItem;
	}
	public void setIdDoItem(String idDoItem) {
		this.idDoItem = idDoItem;
	}
	public int getQtdeDoItem() {
		return qtdeDoItem;
	}
	public void setQtdeDoItem(int qtdeDoItem) {
		this.qtdeDoItem = qtdeDoItem;
	}
	public double getPreçoDoItem() {
		return preçoDoItem;
	}
	public void setPreçoDoItem(double preçoDoItem) {
		this.preçoDoItem = preçoDoItem;
	}
	public Double getVenda() {
		return venda;
	}
	public void setVenda(Double venda) {
		this.venda = venda;
	}
	public String getNomeDovendedor() {
		return nomeDovendedor;
	}
	public void setNomeDovendedor(String nomeDovendedor) {
		this.nomeDovendedor = nomeDovendedor;
	}
	@Override
	public String toString() {
		return "Venda [idDoItem=" + idDoItem + ", qtdeDoItem=" + qtdeDoItem + ", preçoDoItem=" + preçoDoItem
				+ ", venda=" + venda + ", nomeDovendedor=" + nomeDovendedor + "]";
	}

    
}
