package infra;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import business.control.BookManager;
import business.model.Livro;

public class BookFile {
	
	public static BookFile instancia;//Implementa��o do padr�o Singleton
	
	private BookFile(){}
	
	public static BookFile getInstancia() { //Usando Singleton aqui
        if (instancia == null){
        	instancia = new BookFile();
        }
        return instancia;
    }

	public void saveBooks(List<Livro> books, String path) throws InfraException, IOException {
		File file = new File(path);
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(books);
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void saveBooks() throws InfraException, IOException {
		saveBooks(BookManager.getInstancia().getBooks(), "book.bin");
	}

	@SuppressWarnings("unchecked")
	public List<Livro> loadBooks(String path) throws InfraException, IOException {
		List<Livro> books = new ArrayList<Livro>();
		File file = new File(path);
		ObjectInputStream objInput = null;
		InputStream in = null;
		if (!file.exists()) {
			saveBooks();
		}
		try {
			in = new FileInputStream(file);
			// Recupera a lista
			objInput = new ObjectInputStream(in);
			books = (List<Livro>) objInput.readObject();
			return books;

		} catch (NullPointerException ex) {
			throw new InfraException("Erro de persistencia, contacte o admin ou tente mais tarde");

		} catch (IOException ex) {
			throw new InfraException("Erro de persistencia, contacte o admin ou tente mais tarde");
		} catch (ClassNotFoundException ex) {
			throw new InfraException("Erro de persistencia, contacte o admin ou tente mais tarde");
		} finally {
			try {
				objInput.close();
				in.close();
			} catch (IOException e) {
				throw new InfraException("Erro de persistencia, contacte o admin ou tente mais tarde");
			}
		}
	}
	public List<Livro> loadBooks() throws InfraException, IOException {
		return loadBooks("book.bin");
	}
}
