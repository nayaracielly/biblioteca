package infra;

import java.io.IOException;
import java.util.List;

import business.model.User;

public class UserFileAdapter implements Persistencia { //Adaptador de usuário
	
	@Override
	public void save() throws InfraException, IOException {
		UserFile.getInstancia().saveUsers();
	}

	@Override
	public List load() throws InfraException, IOException {
		return UserFile.getInstancia().loadUsers();
	}
}
