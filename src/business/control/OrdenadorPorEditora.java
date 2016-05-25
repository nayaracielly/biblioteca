package business.control;

import business.model.Book;

//Possui o m�todo que define que a ordena��o ser� por editora em ordem alfab�tica
public class OrdenadorPorEditora extends OrdenadorTemplate {

	@Override
	public boolean isPrimeiro(Book book1, Book book2) {
		if (book1.getEditora().compareToIgnoreCase(book2.getEditora()) <= 0) {
			return true;
		}
		return false;
	}

}
