package business.control;

import infra.InfraException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import business.util.LoginInvalidException;
import business.util.PasswordInvalidException;

public class AddComandPersist implements ComandPersistencia {
	private UserManager userM;
	
	public AddComandPersist(UserManager userM) {
		this.userM = userM;
	}

	@Override
	public void execute(List<String> listaDados) throws LoginInvalidException, PasswordInvalidException, InfraException, IOException {
		userM.addUser(listaDados.get(0), listaDados.get(1), listaDados.get(2), listaDados.get(3), listaDados.get(4));
		
	}
	
	

}
