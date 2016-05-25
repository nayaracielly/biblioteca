package business.control;

import java.util.ArrayList;
import java.util.List;

import business.model.Book;

//Classe que possui o m�todo de ordena��o dos livros e a assinatura do m�todo que define qual ser� a ordena��o
public abstract class OrdenadorTemplate {
	public abstract boolean isPrimeiro(Book book1, Book book2);

	protected List<Book> ordenarBook(List<Book> books) {
		List<Book> novaLista = new ArrayList<Book>();
		for (business.model.Book book : books) {
			novaLista.add(book);
		}

		for (int i = 0; i < novaLista.size(); i++) {
			for (int j = i; j < novaLista.size(); j++) {
				if (!isPrimeiro(novaLista.get(i), novaLista.get(j))) {
					Book temp = novaLista.get(j);
					novaLista.set(j, novaLista.get(i));
					novaLista.set(i, temp);
				}
			}
		}

		return novaLista;
	}
}
