package business.control;

import infra.InfraException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import business.util.LoginInvalidException;
import business.util.PasswordInvalidException;
public class FachadaComand {
	private ComandPersistencia comand;
	private UserManager userM;	
	
	public FachadaComand(String tipo, List<String> listaDados) throws LoginInvalidException, PasswordInvalidException, InfraException, IOException {
		userM = UserManager.getInstancia();
		iniciaComand(userM, tipo, listaDados);
	}
	
	public void iniciaComand(UserManager userM,String tipo, List<String> listaDados) throws LoginInvalidException, PasswordInvalidException, InfraException, IOException{
		if(tipo.equals("add")){
			comand = new AddComandPersist(userM);
			comand.execute(listaDados);
		}
		else if(tipo.equals("lista")){
			comand = new ListComandPersist(userM);
			comand.execute(listaDados);
		}
		else if(tipo.equals("update")){
			comand = new UpdateComandPersist(userM);
			comand.execute(listaDados);
		}
		else if(tipo.equals("delete")){
			comand = new DeleteComandPersist(userM);
			comand.execute(listaDados);
		}
		else if(tipo.equals("desfazer")){
			comand = new DesfazComandPersist(userM);
			comand.execute(listaDados);
		}
	}
}
