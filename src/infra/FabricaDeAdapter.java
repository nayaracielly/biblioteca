package infra;

//Interface m�e das F�bricas de adapter que contem a assinatura do m�todos que instancia um objeto do tipo da 
//fabrica escolhida
public interface FabricaDeAdapter {
	Persistencia criar();
}
