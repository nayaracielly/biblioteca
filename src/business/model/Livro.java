package business.model;

import java.io.Serializable;
import java.util.List;


public class Livro implements Serializable {

    private static final long serialVersionUID = -3409171233621036055L;
    private String codigo, nome, edicao;
    private int idLivro, editora, autor;
    private List areaConhecimento;

    @Deprecated
    public Livro(String codigo, String nome, int editora, int autor, String edicao) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.editora = editora;
        this.autor = autor;
        this.edicao = edicao;
    }

    public Livro(int idLivro,List areaConhecimento, String codigoISBN, String nome, int editora, int autor, String edicao ) {
        super();
        this.codigo = codigoISBN;
        this.idLivro = idLivro;
        this.nome = nome;
        this.editora = editora;
        this.autor = autor;
        this.edicao = edicao;
        this.areaConhecimento = areaConhecimento;
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

    public int getEditora() {
        return editora;
    }

    public void setEditora(int editora) {
        this.editora = editora;
    }

    public int getAutor() {
        return autor;
    }

    public void setAutor(int autor) {
        this.autor = autor;
    }

    public List getAreaConhecimento() {
        return areaConhecimento;
    }

    public void setAreaConhecimento(List areaConhecimento) {
        this.areaConhecimento = areaConhecimento;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    @Override
    public String toString() {
        return "Book{" + "codigo=" + codigo + ", nome=" + nome + ", editora=" + editora + ", autor=" + autor + ", edicao=" + edicao + ", idLivro=" + idLivro + '}';
    }
}