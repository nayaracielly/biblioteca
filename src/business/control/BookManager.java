package business.control;

import infra.FabricaBookFileAdapter;
import infra.FabricaDeAdapter;
import infra.InfraException;
import infra.Persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import business.model.Livro;
import business.util.BookValidador;
import business.util.CodigoInvalidException;


public class BookManager {
	//Classe que manipula a lista de livros
	private static List<Livro> books;
	private static Scanner entrada;
	public static BookManager instancia;//Implementa��o do padr�o Singleton
	private FabricaDeAdapter fabrica;
	private Persistencia adapter;

	private BookManager(){
		fabrica = new FabricaBookFileAdapter();//instancia a fabrica de livros
		adapter = fabrica.criar(); //instancia o adaptador de livro
		try {
			books = adapter.load();//usa o m�todo load do adaptador
		} catch (InfraException e) {
			System.out.println("Erro de persistencia, contacte o admin ou tente mais tarde");
		} catch (IOException e) {
			System.out.println("Erro de persistencia, contacte o admin ou tente mais tarde");
		}
		if(books==null){
			books = new ArrayList<Livro>();
		}
	}

	public static BookManager getInstancia() { //Usando Singleton aqui
        if (instancia == null){
        	instancia = new BookManager();
        }
        return instancia;
    }
	public List<Livro> getBooks() {
		return books;
	}

	public void setBooks(List<Livro> books) {
		BookManager.books = books;
	}

	public void addBook(String codigo, String nome, String editora, String autor, String edicao) throws InfraException, CodigoInvalidException, FileNotFoundException, IOException {
		BookValidador.validateCodigo(codigo);
		// Check Existence
		if (BookValidador.validateBookExistence(books, codigo)){
			throw new CodigoInvalidException("J� existe um livro com esse c�digo.");
		}
		//Adiciona
		books.add(new Livro(codigo, nome, editora, autor, edicao));
		adapter.save();//usa o m�todo save do adaptador
		System.out.println("Livro adicionado com sucesso!");
	}

	public void deleteBook(String codigo) throws InfraException, CodigoInvalidException, FileNotFoundException, IOException {
		BookValidador.validateCodigo(codigo);
		// Check Existence
		if (!BookValidador.validateBookExistence(books, codigo)){
			throw new CodigoInvalidException("Nenhum livro foi encontrado com esse codigo.");
		}
		// Remove
		for (int i=0; i < books.size(); i++){
			if (codigo != null && codigo.equals(books.get(i).getCodigo())){
				books.remove(books.get(i));
			}
		}
		adapter.save();
		System.out.println("Livro deletado com sucesso!");
	}
	public void atualizaBook(String codigo) throws InfraException, CodigoInvalidException, FileNotFoundException, IOException {
		entrada = new Scanner(System.in);
		BookValidador.validateCodigo(codigo);
		// Check Existence
		if (!BookValidador.validateBookExistence(books, codigo)){
			throw new CodigoInvalidException("Nenhum livro foi encontrado com esse codigo.");
		}
		//Atualiza
		for (int i=0; i < books.size(); i++){
			if (codigo != null && codigo.equals(books.get(i).getCodigo())){
				System.out.println("Codigo (at� 10 caracteres): ");
				books.get(i).setCodigo(entrada.nextLine());
				System.out.println("Nome: ");
				books.get(i).setNome(entrada.nextLine());
				System.out.println("Editora: ");
				books.get(i).setEditora(entrada.nextLine());
				System.out.println("Autor: ");
				books.get(i).setAutor(entrada.nextLine());
				System.out.println("Edi��o: ");
				books.get(i).setEdicao(entrada.nextLine());
			}
		}
		adapter.save();
		System.out.println("Usuario atualizado com sucesso!");
	}
	
}