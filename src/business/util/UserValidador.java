package business.util;

import java.util.List;

import business.model.Usuario;


public class UserValidador {

	public static void validateLogin(String login) throws LoginInvalidException   {
		if(login == null | login.length() <= 0)
			throw new LoginInvalidException("Login vazio!\n");
		else if(login.length() > 20) 
			throw new LoginInvalidException("Login com mais de 20 caracteres!\n");
		else if(login.matches(".*\\d.*"))
			 throw new LoginInvalidException("Login n�o pode conter numeros!\n");
	}
	
	public static void validatePassword(String pass) throws PasswordInvalidException   {
		
		if(pass == null | pass.length() < 8)
			throw new PasswordInvalidException("Senha n�o pode possuir menos de 8 caracteres!\n");
		else if(pass.length() > 12) 
			throw new PasswordInvalidException("Senha n�o pode possuir mais de 12 caracteres!\n");
		else if(!(pass.matches(".*[a-zA-Z].*") && pass.matches(".*\\d.*\\d.*"))) 
			throw new PasswordInvalidException("Senha deve possuir ao menos 1 caracter e 2 numeros!\n");
	}

	public static boolean validateUserExistence(List<Usuario> users, String login){
		for (Usuario user : users){
			if (login != null && login.equals(user.getLogin())){
				return true;
			}
		}
		return false;
	}
}
