

package business.model;

import java.io.Serializable;

public class Usuario implements Serializable {

    private static final long serialVersionUID = -3409171233621036055L;
    private int curso;
    private String nome, matricula, login, senha;

    public Usuario(String nome, String matricula, int curso, String login, String senha) {
        super();
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UserMemento saveToMemento() {
        System.out.println("Originator: Saving to Memento.");
        return new UserMemento(nome, matricula, curso, login, senha);
    }
    public Usuario restoreFromMemento(UserMemento m) {
        return new Usuario(m.getNome(), m.getMatricula(), m.getCurso(), m.getLogin(), m.getSenha());
    }

    public String toString() {
        return nome +"\n" +matricula+ "\n" +curso +"\n" + login +"\n"+senha;
    }



}
