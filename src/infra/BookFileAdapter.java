package infra;

import java.io.IOException;
import java.util.List;

import business.model.Book;

public class BookFileAdapter implements Persistencia {//Adaptador de livro
	
	@Override
	public void save() throws InfraException, IOException {
		BookFile.getInstancia().saveBooks();
	}

	@Override
	public List load() throws InfraException, IOException {
		return BookFile.getInstancia().loadBooks();
	}

}
