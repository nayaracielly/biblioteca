package business.control;

import java.util.ArrayList;
import java.util.List;

import business.model.Livro;

public class Listagem {//Classe respons�vel por escolher qual m�todo de listagem ser� usado e por mostrar a listagem
	protected List<Livro> books;
	protected OrdenadorTemplate ordenador;
	private BookManager bookM;
	
	public Listagem(ModoDeListagem modo) {
		bookM = BookManager.getInstancia();
		books = bookM.getBooks();
		switch (modo) {
		case porAutor:
			ordenador = new OrdenadorPorAutor();
			break;
		case porEditora:
			ordenador = new OrdenadorPorEditora();
			break;
		default:
			break;
		}
	}

	public void mostrarLista() {
		List<Livro> novaLista = new ArrayList<Livro>();
		novaLista = ordenador.ordenarBook(books);

		for (Livro book : novaLista) {
			System.out.println("[ Codigo: "+book.getCodigo()+" || Nome: "+book.getNome()+ " || Editora: " +book.getEditora()+ " || Autor: " + book.getAutor()+ " || Edi��o: " + book.getEdicao() + " ]");
			
		}
	}
}
