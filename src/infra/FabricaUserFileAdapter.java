package infra;

//Classe f�bricas que instancia o objeto UserFileAdapter
public class FabricaUserFileAdapter implements FabricaDeAdapter {

	@Override
	public Persistencia criar() {
		return new UserFileAdapter();
	}

}
