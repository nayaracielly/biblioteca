package infra;

//Classe fábricas que instancia o objeto UserFileAdapter
public class FabricaUserFileAdapter implements FabricaDeAdapter {

	@Override
	public Persistencia criar() {
		return new UserFileAdapter();
	}

}
