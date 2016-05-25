package business.control;

import static org.junit.Assert.*;
import infra.InfraException;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import business.util.LoginInvalidException;

public class UserDeleteTest{
	UserManager userM = UserManager.getInstancia();
	@Before
	public void setUp() throws Exception
	{
		userM.getUsers().clear();

		userM.addUser("Nome", "matricula", "curso","MeuUsuarioA", "MinhaSenha12");
		userM.addUser("Nome", "matricula", "curso","MeuUsuarioB", "MinhaSenha12");
		userM.addUser("Nome", "matricula", "curso","MeuUsuarioC", "MinhaSenha12");
	}

	@After
	public void tearDown() throws Exception
	{
		userM.getUsers().clear();
	}

	@Test
	public void testDeleteUserCorrect()
	{
		try
		{
			userM.deleteUser("MeuUsuarioB");
		}
		catch (NullPointerException | LoginInvalidException | InfraException | IOException e)
		{
			fail("Test falhou! Deveria remover um usuário.");
		}
	}

	@Test
	public void testLoginFail1()
	{
		try
		{
			userM.deleteUser(null);
			fail("Test falhou! Deveria lançar uma exceção.");
		}
		catch (NullPointerException | LoginInvalidException | InfraException | IOException e) {}
	}

	@Test
	public void testLoginFail2()
	{
		try
		{
			userM.deleteUser("");
			fail("Test falhou! Deveria lançar uma exceção.");
		}
		catch (NullPointerException | LoginInvalidException | InfraException | IOException e) {}
	}

	@Test
	public void testLoginFail3()
	{
		try
		{
			userM.deleteUser("desconhecido");
			fail("Test falhou! Deveria lançar uma exceção.");
		}
		catch (NullPointerException | LoginInvalidException | InfraException | IOException e) {}
	}
}
