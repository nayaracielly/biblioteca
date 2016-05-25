package business.control;

import static org.junit.Assert.*;
import infra.InfraException;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import business.util.LoginInvalidException;
import business.util.PasswordInvalidException;

public class UserAddTest{
	UserManager userM = UserManager.getInstancia();
	@Before
	public void setUp() throws Exception { // executa ao iniciar cada teste
		userM.getUsers().clear();
	}

	@After
	public void tearDown() throws Exception{ // executa ao finalizar cada teste
		userM.getUsers().clear();
	}

	@Test
	public void testCreateUserCorrect()	{
		try	{
			userM.addUser("Nome", "matricula", "curso","MeuLogin", "MinhaSenha12");
		}
		catch (NullPointerException | LoginInvalidException| PasswordInvalidException | InfraException | IOException e)	{
			fail("Test falhou! Deveria criar um usuário.");
		}
	}

	@Test
	public void testLoginFail1(){
		try	{
			userM.addUser("Nome", "matricula", "curso",null, "MinhaSenha12");
			fail("Test falhou! Deveria lançar uma exceção.");
		}
		catch (NullPointerException | LoginInvalidException| PasswordInvalidException | InfraException | IOException e) {}
	}

	@Test
	public void testLoginFail2(){
		try	{
			userM.addUser("Nome", "matricula", "curso","", "MinhaSenha12");
			fail("Test falhou! Deveria lançar uma exceção.");
		}
		catch (NullPointerException | LoginInvalidException| PasswordInvalidException | InfraException | IOException e) {}
	}

	@Test
	public void testLoginFail3(){
		try	{
			userM.addUser("Nome", "matricula", "curso","llllluuuuullllluuuuul", "MinhaSenha12");
			fail("Test falhou! Deveria lançar uma exceção.");
		}
		catch (NullPointerException | LoginInvalidException| PasswordInvalidException | InfraException | IOException e) {}
	}

	@Test
	public void testLoginFail4(){
		try
		{
			userM.addUser("Nome", "matricula", "curso","1", "MinhaSenha12");
			fail("Test falhou! Deveria lançar uma exceção.");
		}
		catch (NullPointerException | LoginInvalidException| PasswordInvalidException | InfraException | IOException e) {}
	}

	@Test
	public void testLoginFail5(){
		try	{
			userM.addUser("Nome", "matricula", "curso","u1u", "MinhaSenha12");
			fail("Test falhou! Deveria lançar uma exceção.");
		}
		catch (NullPointerException | LoginInvalidException| PasswordInvalidException | InfraException | IOException e) {}
	}



	@Test
	public void testLoginFail6(){
		try	{
			userM.addUser("Nome", "matricula", "curso","MeuLogin", null);
			fail("Test falhou! Deveria lançar uma exceção.");
		}
		catch (NullPointerException | LoginInvalidException| PasswordInvalidException | InfraException | IOException e) {}
	}

	@Test
	public void testLoginFail7(){
		try	{
			userM.addUser("Nome", "matricula", "curso","MeuLogin", "");
			fail("Test falhou! Deveria lançar uma exceção.");
		}
		catch (NullPointerException | LoginInvalidException| PasswordInvalidException | InfraException | IOException e) {}
	}

	@Test
	public void testLoginFail8(){
		try	{
			userM.addUser("Nome", "matricula", "curso","MeuLogin", "lllll");
			fail("Test falhou! Deveria lançar uma exceção.");
		}
		catch (NullPointerException | LoginInvalidException| PasswordInvalidException | InfraException | IOException e) {}
	}

	@Test
	public void testLoginFail9(){
		try	{
			userM.addUser("Nome", "matricula", "curso","MeuLogin", "12345lllll12345");
			fail("Test falhou! Deveria lançar uma exceção.");
		}
		catch (NullPointerException | LoginInvalidException| PasswordInvalidException | InfraException | IOException e) {}
	}

	@Test
	public void testLoginFail10(){
		try	{
			userM.addUser("Nome", "matricula", "curso","MeuLogin", "llllluuuuu");
			fail("Test falhou! Deveria lançar uma exceção.");
		}
		catch (NullPointerException | LoginInvalidException| PasswordInvalidException | InfraException | IOException e) {}
	}

	@Test
	public void testLoginFail11(){
		try	{
			userM.addUser("Nome", "matricula", "curso","MeuLogin", "0123456789");
			fail("Test falhou! Deveria lançar uma exceção.");
		}
		catch (NullPointerException | LoginInvalidException| PasswordInvalidException | InfraException | IOException e) {}
	}
}
