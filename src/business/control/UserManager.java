package business.control;

import infra.FabricaDeAdapter;
import infra.FabricaUserFileAdapter;
import infra.InfraException;
import infra.Persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import business.model.Usuario;
import business.model.UserZelador;
import business.util.LoginInvalidException;
import business.util.PasswordInvalidException;
import business.util.UserValidador;

public class UserManager {
	//Classe que manipula a lista de usu�rios
	private static List<Usuario> users;
	private static Scanner entrada;
	public static UserManager instancia; //Implementa��o do padr�o Singleton
	private FabricaDeAdapter fabrica;
	private Persistencia adapter;
	private UserZelador userZ;
	private int i;

	private UserManager(){
		fabrica = new FabricaUserFileAdapter();//instancia a fabrica de usu�rios
		adapter = fabrica.criar();//instancia o adaptador de usu�rio
		try {
			users = adapter.load();//usa o m�todo load do adaptador
		} catch (InfraException e) {
			System.out.println("Erro de persistencia, contacte o admin ou tente mais tarde");
		} catch (IOException e) {
			System.out.println("Erro de persistencia, contacte o admin ou tente mais tarde");
		}
		if(users==null){
			users = new ArrayList<Usuario>();
		}		
	}
	
	public static UserManager getInstancia() { //Usando Singleton aqui
        if (instancia == null){
        	instancia = new UserManager();
        }
        return instancia;
    }

	public List<Usuario> getUsers() {
		return users;
	}

	public void setUsers(List<Usuario> users) {
		UserManager.users = users;
	}

	public void addUser(String nome, String matricula, String curso, String login, String senha) throws InfraException, LoginInvalidException, PasswordInvalidException, FileNotFoundException, IOException {
		
		UserValidador.validateLogin(login);
		UserValidador.validatePassword(senha);
		// Check Existence
		if (UserValidador.validateUserExistence(users, login)){
			throw new LoginInvalidException("J� existe um usu�rio com esse login.");
		}
		//Adiciona
		users.add(new Usuario(nome, matricula, curso, login, senha));
		adapter.save();
		System.out.println("Usuario adicionado com sucesso!");	
	}

	public void deleteUser(String login) throws InfraException, LoginInvalidException, FileNotFoundException, IOException {
		UserValidador.validateLogin(login);
		// Check Existence
		if (!UserValidador.validateUserExistence(users, login)){
			throw new LoginInvalidException("Nenhum usu�rio foi encontrado com esse login.");
		}
		// Remove
		for (int i=0; i < users.size(); i++){
			if (login != null && login.equals(users.get(i).getLogin())){
				users.remove(users.get(i));
			}
		}
		adapter.save();
		System.out.println("Usuario deletado com sucesso!");
	}
	public void atualizaUser(String login) throws InfraException, LoginInvalidException, FileNotFoundException, IOException {
		entrada = new Scanner(System.in);
		userZ = new UserZelador();
		UserValidador.validateLogin(login);
		// Check Existence
		if (!UserValidador.validateUserExistence(users, login)){
			throw new LoginInvalidException("Nenhum usu�rio foi encontrado com esse login.");
		}
		// Atualiza
		for (i = 0; i < users.size(); i++){
			if (login != null && login.equals(users.get(i).getLogin())){
				userZ.addMemento(users.get(i).saveToMemento());//Aqui adiciona o memento ao zelador
				System.out.println("Nome: ");
				users.get(i).setNome(entrada.nextLine());
				System.out.println("Matricula: ");
				users.get(i).setMatricula(entrada.nextLine());
				System.out.println("Curso: ");
				users.get(i).setCurso(entrada.nextLine());
				System.out.println("Login (deve ter menos de 20 caracteres e n�o pode ter n�meros): ");
				users.get(i).setLogin(entrada.nextLine());
				System.out.println("Senha (entre 8 e 12 caracteres e pelo menos 1 caracter e 2 n�meros): ");
				users.get(i).setSenha(entrada.nextLine());
				break;
			}
		}
		adapter.save();
		System.out.println("Usuario atualizado com sucesso!");
//		int escolha;
//		do{
//			System.out.println("Digite:\n1- Para desfazer atualiza��o;\n2- Para continuar.");
//			escolha = entrada.nextInt();
//		}while(escolha<1||escolha>2);
//		if(escolha==1){
//			desfazer();	
//		}
	}
	
	public void desfazer() throws InfraException, IOException{		
		try {
			users.set(i,users.get(i).restoreFromMemento(userZ.getMemento(0)));//aqui est� desfazendo a a��o de atualiza��o
			adapter.save();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}	
	
}
