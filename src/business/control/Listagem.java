package business.control;

import java.util.ArrayList;
import java.util.List;

import business.model.Book;

public class Listagem {//Classe responsável por escolher qual método de listagem será usado e por mostrar a listagem
	protected List<Book> books;
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
		List<Book> novaLista = new ArrayList<Book>();
		novaLista = ordenador.ordenarBook(books);

		for (Book book : novaLista) {
			System.out.println("[ Codigo: "+book.getCodigo()+" || Nome: "+book.getNome()+ " || Editora: " +book.getEditora()+ " || Autor: " + book.getAutor()+ " || Edição: " + book.getEdicao() + " ]");
			
		}
	}
}
