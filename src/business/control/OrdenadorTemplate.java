package business.control;

import java.util.ArrayList;
import java.util.List;

import business.model.Livro;

//Classe que possui o m�todo de ordena��o dos livros e a assinatura do m�todo que define qual ser� a ordena��o
public abstract class OrdenadorTemplate {
	public abstract boolean isPrimeiro(Livro book1, Livro book2);

	protected List<Livro> ordenarBook(List<Livro> books) {
		List<Livro> novaLista = new ArrayList<Livro>();
		for (business.model.Livro book : books) {
			novaLista.add(book);
		}

		for (int i = 0; i < novaLista.size(); i++) {
			for (int j = i; j < novaLista.size(); j++) {
				if (!isPrimeiro(novaLista.get(i), novaLista.get(j))) {
					Livro temp = novaLista.get(j);
					novaLista.set(j, novaLista.get(i));
					novaLista.set(i, temp);
				}
			}
		}

		return novaLista;
	}
}
