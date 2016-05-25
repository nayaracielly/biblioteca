package infra;

import java.io.IOException;
import java.util.List;

public interface Persistencia {//Interface m�e das Adapter
	
	void save()throws InfraException, IOException;
	
	List load() throws InfraException, IOException;
}
