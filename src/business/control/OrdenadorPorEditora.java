package business.control;

import business.model.Book;

//Possui o método que define que a ordenação será por editora em ordem alfabética
public class OrdenadorPorEditora extends OrdenadorTemplate {

	@Override
	public boolean isPrimeiro(Book book1, Book book2) {
		if (book1.getEditora().compareToIgnoreCase(book2.getEditora()) <= 0) {
			return true;
		}
		return false;
	}

}
