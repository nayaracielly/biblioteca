package business.control;

import static org.junit.Assert.*;
import infra.InfraException;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import business.util.CodigoInvalidException;

public class BookAddTest{
	BookManager bookM = BookManager.getInstancia();
	
	@Before
	public void setUp() throws Exception { // executa ao iniciar cada teste
		bookM.getBooks().clear();
	}

	@After
	public void tearDown() throws Exception{ // executa ao finalizar cada teste
		bookM.getBooks().clear();
	}

	@Test
	public void testCreateBookCorrect()	{
		try	{
			bookM.addBook("codigo", "nome", "editora","autor", "edicao");
		}
		catch (NullPointerException | CodigoInvalidException| InfraException | IOException e)	{
			fail("Test falhou! Deveria criar um usuário.");
		}
	}

	@Test
	public void testLoginFail1(){
		try	{
			bookM.addBook(null, "nome", "editora","autor", "edicao");
			fail("Test falhou! Deveria lançar uma exceção.");
		}
		catch (NullPointerException | CodigoInvalidException| InfraException | IOException e) {}
	}

	@Test
	public void testLoginFail2(){
		try	{
			bookM.addBook("", "nome", "editora","autor", "edicao");
			fail("Test falhou! Deveria lançar uma exceção.");
		}
		catch (NullPointerException | CodigoInvalidException| InfraException | IOException e) {}
	}

	@Test
	public void testLoginFail3(){
		try	{
			bookM.addBook("lllllluuuuul", "nome", "editora","autor", "edicao");
			fail("Test falhou! Deveria lançar uma exceção.");
		}
		catch (NullPointerException | CodigoInvalidException| InfraException | IOException e) {}
	}

}
