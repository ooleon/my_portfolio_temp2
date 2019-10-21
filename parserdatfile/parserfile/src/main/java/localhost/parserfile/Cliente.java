package localhost.parserfile;

public class Cliente {
    private String id;
    private String cnpj;
    private String nome;
    private String ramoDeAtividade;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNome() {
		return nome;
	}
	/**
	 * @param id
	 * @param cnpj
	 * @param nome
	 * @param ramoDeAtividade
	 */
	public Cliente(String id, String cnpj, String nome, String ramoDeAtividade) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.nome = nome;
		this.ramoDeAtividade = ramoDeAtividade;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRamoDeAtividade() {
		return ramoDeAtividade;
	}
	public void setRamoDeAtividade(String ramoDeAtividade) {
		this.ramoDeAtividade = ramoDeAtividade;
	}
}
