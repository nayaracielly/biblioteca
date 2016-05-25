package business.control;

import infra.InfraException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import business.model.User;
import business.util.LoginInvalidException;
import business.util.PasswordInvalidException;

public class ListComandPersist implements ComandPersistencia{
	private UserManager userM;
	
	public ListComandPersist(UserManager userM) {
		this.userM = userM;
	}

	@Override
	public void execute(List<String> listaDados)throws LoginInvalidException,PasswordInvalidException, InfraException, IOException {
		for (User user : userM.getUsers()){
			System.out.println("[ Nome: "+user.getNome()+" || Matricula: "+user.getMatricula()+ " || Curso: " +user.getCurso()+ " || Login: " + user.getLogin() + " || Senha: " + user.getSenha() + " ]");
		}
		
	}

	

}
