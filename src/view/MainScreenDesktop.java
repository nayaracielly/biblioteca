package view;
import java.util.Scanner;

public class MainScreenDesktop {
	private static Scanner opcao;
	private static UserAddForm usuario;
	private static BookAddForm livro;
	
	public static void main (String[] args) {
		opcao = new Scanner(System.in);
		usuario = new UserAddForm();
		livro = new BookAddForm();
		showMenu();
	}
	
	public static void showMenu() {
		int opMenu;
		do{
			System.out.println("\nBem vindo!\nEscolha a opção desejada:\n1- Cadastro de Usuario;\n2- Cadastro de Livro;\n3- Sair");
			opMenu = opcao.nextInt();
		}while(opMenu<1||opMenu>3);
		readUserInput(opMenu);
	}
	
	public static void readUserInput(int opcao) {
		switch (opcao) {
		
			case 1:
				usuario.showMenuCadUsuario();
				if(usuario.voltar){
					showMenu();
				}
				break;
			
			case 2:
				livro.showMenuCadLivro();
				if(livro.voltar){
					showMenu();
				}
				break;
	
			case 3:
				break;
		}
	}	
}