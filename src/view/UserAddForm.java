package view;

import infra.InfraException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import business.control.FachadaComand;
import business.control.UserManager;
import business.model.User;
import business.util.LoginInvalidException;
import business.util.PasswordInvalidException;

public class UserAddForm {

	private Scanner entrada;
	private Scanner opcao;
	public boolean voltar = false;
	UserManager userM;
	FachadaComand userF;
	List<String> dadosUser;

	public UserAddForm(){
		dadosUser = new ArrayList<String>();
		userM = UserManager.getInstancia();
	}
	public void showMenuCadUsuario(){
		opcao = new Scanner(System.in);
		int opMenu;
		do{
			System.out.println("\nEscolha a opção desejada:\n1- Cadastrar Usuario;\n2- Listar Usuários; \n3- Excluir Usuário;"
					+ "\n4- Alterar Usuário;\n5- Desfazer última atualização; \n6- Voltar");
			opMenu = opcao.nextInt();
		}while(opMenu<1||opMenu>5);
		opcaoCadUsuario(opMenu);			
	}
	
	public void opcaoCadUsuario(int option){
		entrada = new Scanner(System.in);
		int choice = option;
		boolean checked = true;
		switch (choice) {

		case 1:
			dadosUser.clear();
			String nome = "";
			String matricula = "";
			String curso = "";
			
			System.out.println("Nome do usuario:");
			dadosUser.add(entrada.nextLine());
			System.out.println("Matricula do usuario:");
			dadosUser.add(entrada.nextLine());
			System.out.println("Curso do usuario:");
			dadosUser.add(entrada.nextLine());
			
			while (checked) {
				
				String login = "";
				String senha = "";
				
				System.out.println("Login do usuario (deve ter menos de 20 caracteres e não pode ter números):");
				dadosUser.add(3, entrada.nextLine());
				System.out.println("Senha do usuario (entre 8 e 12 caracteres e pelo menos 1 caracter e 2 números):");					
				dadosUser.add(4, entrada.nextLine());
				
				try {
					userF = new FachadaComand("add", dadosUser);
					checked = false;
				} catch (LoginInvalidException | PasswordInvalidException
						| InfraException | IOException e) {
					System.out.println(e.getMessage());
				}
			}
			showMenuCadUsuario();
			break;
		
		case 2:
			try {
				userF = new FachadaComand("lista", dadosUser);
			} catch (LoginInvalidException | PasswordInvalidException
					| InfraException | IOException e) {
				System.out.println(e.getMessage());
			}
			
			showMenuCadUsuario();
			break;

		case 3:
			dadosUser.clear();
			System.out.println("Login do usuario a ser excluido:");
			dadosUser.add(entrada.nextLine());
			
			
			try {
				userF = new FachadaComand("delete", dadosUser);
			} catch (LoginInvalidException | InfraException | PasswordInvalidException | IOException e) {
				System.out.println(e.getMessage());
			}
			
			showMenuCadUsuario();
			break;
			
		case 4:
			dadosUser.clear();
			System.out.println("Login do usuario a ser atualizado:");
			dadosUser.add(entrada.nextLine());
		
			try {
				userF = new FachadaComand("update", dadosUser);
			} catch (LoginInvalidException | PasswordInvalidException | InfraException | IOException e) {
				System.out.println(e.getMessage());
			}
			
			showMenuCadUsuario();
			break;
		case 5:
			try {
				userF = new FachadaComand("desfazer", dadosUser);
			} catch (LoginInvalidException | PasswordInvalidException | InfraException | IOException e) {
				System.out.println(e.getMessage());
			}
			showMenuCadUsuario();
			break;
			
		case 6:
			voltar = true;
		}
	}
}
	
