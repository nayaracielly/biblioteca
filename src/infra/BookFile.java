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
import business.model.Book;

public class BookFile {
	
	public static BookFile instancia;//Implementação do padrão Singleton
	
	private BookFile(){}
	
	public static BookFile getInstancia() { //Usando Singleton aqui
        if (instancia == null){
        	instancia = new BookFile();
        }
        return instancia;
    }

	public void saveBooks(List<Book> books, String path) throws InfraException, IOException {
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
	public List<Book> loadBooks(String path) throws InfraException, IOException {
		List<Book> books = new ArrayList<Book>();
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
			books = (List<Book>) objInput.readObject();
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
	public List<Book> loadBooks() throws InfraException, IOException {
		return loadBooks("book.bin");
	}
}
