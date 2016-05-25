package business.control;

import business.model.Book;

//Possui o m�todo que define que a ordena��o ser� por autor em ordem alfab�tica
public class OrdenadorPorAutor extends OrdenadorTemplate {

	@Override
	public boolean isPrimeiro(Book book1, Book book2) {
		if (book1.getAutor().compareToIgnoreCase(book2.getAutor()) <= 0) {
			return true;
		}
		return false;
	}

}
