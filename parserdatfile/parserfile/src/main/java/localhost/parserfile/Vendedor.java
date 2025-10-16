package localhost.parserfile;

//import com.sun.istack.internal.NotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

import static java.io.File.createTempFile;
import static java.nio.channels.FileChannel.*;

public class Vendedor {
    private String id;
    private String cpf;
    private String nome;
    private String salario;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @param id
	 * @param cpf
	 * @param nome
	 * @param salario
	 */
	public Vendedor(String id, String cpf, String nome, String salario) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.salario = salario;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}

}