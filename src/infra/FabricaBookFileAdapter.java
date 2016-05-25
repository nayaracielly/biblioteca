package infra;

//Classe f�bricas que instancia o objeto BookFileAdapter
public class FabricaBookFileAdapter implements FabricaDeAdapter {

	@Override
	public Persistencia criar() {
		return new BookFileAdapter();
	}

}
