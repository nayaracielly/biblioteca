package business.model;


public class UserMemento {
	private String nome, matricula, curso, login, senha;
	
	public UserMemento(String nome, String matricula, String curso, String login, String senha) {
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
		this.login = login;
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getCurso() {
		return curso;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public UserMemento getSavedState() {
		return this;
	}

}
