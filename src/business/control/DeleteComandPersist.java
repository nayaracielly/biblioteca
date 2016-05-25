package business.control;

import infra.InfraException;

import java.io.IOException;
import java.util.List;

import business.util.LoginInvalidException;
import business.util.PasswordInvalidException;

public class DeleteComandPersist implements ComandPersistencia {
	
	UserManager userM;
	
	public DeleteComandPersist(UserManager userM) {
		this.userM = userM;
	}

	@Override
	public void execute(List<String> listaDados) throws LoginInvalidException, PasswordInvalidException, InfraException, IOException {
		userM.deleteUser(listaDados.get(0));
		
	}

}
