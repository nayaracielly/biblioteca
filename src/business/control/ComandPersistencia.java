package business.control;

import infra.InfraException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import business.util.LoginInvalidException;
import business.util.PasswordInvalidException;

public interface ComandPersistencia {
	
	public void execute(List<String> listaDados) throws LoginInvalidException, PasswordInvalidException,InfraException, IOException;

}
