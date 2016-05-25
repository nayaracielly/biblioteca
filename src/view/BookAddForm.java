package view;

import infra.InfraException;

import java.io.IOException;
import java.util.Scanner;

import business.control.BookManager;
import business.control.Listagem;
import business.control.ModoDeListagem;
import business.model.Book;
import business.util.CodigoInvalidException;

public class BookAddForm {//Classe que escolhe o tipo de listagem do template method
	private Scanner opcao;
	private Scanner entrada;
	public boolean voltar = false;
	private BookManager bookM;
	Listagem minhaListagem;
	
	public BookAddForm(){
		bookM = BookManager.getInstancia();
	}
	
	public void showMenuCadLivro(){
		opcao = new Scanner(System.in);
		int opMenu;
		do{
			System.out.println("\nEscolha a opção desejada:\n1- Cadastrar Livro;\n2- Listar Livros; \n3- Excluir Livro;"
					+ "\n4- Alterar Livro;\n5- Voltar");
			opMenu = opcao.nextInt();
		}while(opMenu<1||opMenu>5);
		opcaoCadLivro(opMenu);	
	}
	
	public void opcaoCadLivro(int option){
		entrada = new Scanner(System.in);
		int choice = option;
		boolean checked = true;
		switch (choice) {
			
		case 1:
			String nome = "";
			String editora = "";
			String autor = "";
			String edicao = "";
			
			System.out.println("Nome do livro:");
			nome = entrada.nextLine();
			System.out.println("Editora do livro:");
			editora = entrada.nextLine();
			System.out.println("Autor do livro:");
			autor = entrada.nextLine(); 
			System.out.println("Edicao do livro:");					
			edicao = entrada.nextLine();
			
			while (checked) {
				String codigo = "";
				
				System.out.println("Codigo do livro (até 10 caracteres):");
				codigo = entrada.nextLine();
				
									
				try {
					bookM.addBook(codigo, nome, editora, autor, edicao);
					checked = false;
				} catch (CodigoInvalidException e) {
					System.out.println(e.getMessage());
				} catch (InfraException e) {
					System.out.println(e.getMessage());
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				
			}
			showMenuCadLivro();
			break;
		
		case 2:
			opcao = new Scanner(System.in);
			int opMenu;
			do{
				System.out.println("\nEscolha a listagem desejada:\n1- Por autor;\n2- Por editora;\n3- Voltar");
				opMenu = opcao.nextInt();
			}while(opMenu<1||opMenu>3);
			
			if(opMenu==1){//Nesse if-else é ecolhido qual método de listagem será usado no template method
				minhaListagem = new Listagem(ModoDeListagem.porAutor);
				System.out.println("=== Listagem por Autor ===");
				minhaListagem.mostrarLista();
			} 
			else if(opMenu==2){
				minhaListagem = new Listagem(ModoDeListagem.porEditora);
				System.out.println("=== Listagem por Editora ===");
				minhaListagem.mostrarLista();
			}			
			showMenuCadLivro();
			break;

		case 3:
			System.out.println("Codigo do livro a ser excluido:");
			String deleteCodigo = entrada.nextLine();
			
			try {
				bookM.deleteBook(deleteCodigo);
			} catch (CodigoInvalidException e) {
				System.out.println(e.getMessage());
			} catch (InfraException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			showMenuCadLivro();
			break;
			
		case 4:
			System.out.println("Codigo do livro a ser atualizado:");
			String atualizaCodigo = entrada.nextLine();
			
			try {
				bookM.atualizaBook(atualizaCodigo);
			} catch (CodigoInvalidException e) {
				System.out.println(e.getMessage());
			} catch (InfraException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			showMenuCadLivro();
			break;
		
		case 5:
			voltar = true;
		}
	}
}
