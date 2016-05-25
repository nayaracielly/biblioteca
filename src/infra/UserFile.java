package infra;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import business.control.UserManager;
import business.model.User;

public class UserFile {
	public static UserFile instancia; //Implementação do padrão Singleton
	
	private UserFile(){}
	
	public static UserFile getInstancia() { //Usando Singleton aqui
        if (instancia == null){
        	instancia = new UserFile();
        }
        return instancia;
    }
	
	//Classe que manipula o arquivo de usuários
	public void saveUsers(List<User> users, String path) throws InfraException, IOException {
		File file = new File(path);
		try {
			//Gera o arquivo para armazenar o objeto
			FileOutputStream arquivoGrav =  new FileOutputStream(file);
			//Classe responsavel por inserir os objetos
			ObjectOutputStream out = new ObjectOutputStream(arquivoGrav);
			//Grava o objeto cliente no arquivo
			out.writeObject(users);
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void saveUsers() throws InfraException, IOException {
		saveUsers(UserManager.getInstancia().getUsers(), "user.bin");
	}
	
	public boolean existeArquivo(String path){
		path = "user.bin";
		File file = new File(path);
		if(file.exists()){
			return true;
		}
		return false;
		
	}

	@SuppressWarnings("unchecked")
	public List<User> loadUsers(String path) throws InfraException, IOException {
		List<User> users = new ArrayList<User>();
		File file = new File(path);
		ObjectInputStream objInput = null;
		InputStream in = null;
		if (!file.exists()) {
			saveUsers();
		}
		try {
			in = new FileInputStream(file);
			// Recupera a lista
			objInput = new ObjectInputStream(in);
			users = (List<User>) objInput.readObject();
			return users;

		} catch (NullPointerException ex) {
			throw new InfraException("Erro de persistencia, contacte o admin ou tente mais tarde");
		} catch (IOException ex) {
			throw new InfraException("Erro de persistencia, contacte o admin ou tente mais tarde");
		} catch (ClassNotFoundException ex) {
			throw new InfraException("Erro de persistencia, contacte o admin ou tente mais tarde");
		} finally {
			try {
				objInput.close();
				in.close();
			} catch (IOException e) {
				throw new InfraException("Erro de persistencia, contacte o admin ou tente mais tarde");
			}
		}
	}
	public List<User> loadUsers() throws InfraException, IOException {
		return loadUsers("user.bin");
	}
}
