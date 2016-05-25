package infra;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import business.control.UserManager;

public class UserLoadTest{
	UserFile userF = UserFile.getInstancia();
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
	public void testLoadUserCorrect(){
		try{
			userF.loadUsers();
		}
		catch (NullPointerException | InfraException | IOException e)
		{
			fail("Test falhou! Deveria carregar lista.");
		}
	}

	@Test
	public void testLoadFail1(){
		try{
			userF.loadUsers(null);
			fail("Test falhou! Deveria lançar uma exceção.");
		}
		catch (NullPointerException | InfraException | IOException e) {}
	}

	@Test
	public void testLoadFail2(){
		try{
			userF.loadUsers("");
			fail("Test falhou! Deveria lançar uma exceção.");
		}
		catch (NullPointerException | InfraException | IOException e) {}
	}
}
