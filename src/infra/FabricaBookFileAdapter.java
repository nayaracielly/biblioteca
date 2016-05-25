package infra;

//Classe fábricas que instancia o objeto BookFileAdapter
public class FabricaBookFileAdapter implements FabricaDeAdapter {

	@Override
	public Persistencia criar() {
		return new BookFileAdapter();
	}

}
