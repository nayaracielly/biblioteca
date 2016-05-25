package infra;

//Interface mãe das Fábricas de adapter que contem a assinatura do métodos que instancia um objeto do tipo da 
//fabrica escolhida
public interface FabricaDeAdapter {
	Persistencia criar();
}
