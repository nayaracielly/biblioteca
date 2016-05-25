package infra;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import business.control.UserManager;

public class UserSaveTest{
	UserFile user = UserFile.getInstancia();
	UserManager userM = UserManager.getInstancia();
	@Before
	public void setUp() throws Exception{
		userM.getUsers().clear();
	}

	@After
	public void tearDown() throws Exception{
		userM.getUsers().clear();
	}

	@Test
	public void testSaveUserCorrect(){
		try{
			user.saveUsers();
		}
		catch (NullPointerException | InfraException | IOException e){
			fail("Test falhou! Deveria salvar nova lista.");
		}
	}
	
	@Test
	public void testSaveFail1(){
		try{
			user.saveUsers(userM.getUsers(), null);
			fail("Test falhou! Deveria lançar uma exceção.");
		}
		catch (NullPointerException | InfraException | IOException e) {}
	}
}
