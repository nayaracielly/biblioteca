package business.control;

import business.model.Book;

//Possui o método que define que a ordenação será por autor em ordem alfabética
public class OrdenadorPorAutor extends OrdenadorTemplate {

	@Override
	public boolean isPrimeiro(Book book1, Book book2) {
		if (book1.getAutor().compareToIgnoreCase(book2.getAutor()) <= 0) {
			return true;
		}
		return false;
	}

}
