

package business.model;

import java.io.Serializable;


public class Book implements Serializable {

	private static final long serialVersionUID = -3409171233621036055L;

	private String codigo, nome, editora, autor, edicao;
    
    public Book(String codigo, String nome, String editora, String autor, String edicao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.editora = editora;
		this.autor = autor;
		this.edicao = edicao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	@Override
	public String toString() {
		return "codigo: " + codigo + ", nome: " + nome + ", editora: "
				+ editora + ", autor: " + autor + ", edicao: " + edicao + "]";
	}

    
	
    
}