package business.model;

import java.util.ArrayList;

public class UserZelador {
	private UserMemento savedStates;
	
	public void addMemento(UserMemento m) {
		savedStates=m;
	}
	public UserMemento getMemento(int index) throws Exception {
		if (savedStates==null){
			throw new Exception("Não há memento salvo!");
		}
		return savedStates;
	}
}
