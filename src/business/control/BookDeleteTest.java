package business.control;

import static org.junit.Assert.*;
import infra.InfraException;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import business.util.CodigoInvalidException;

public class BookDeleteTest{
	BookManager bookM = BookManager.getInstancia();
	
	@Before
	public void setUp() throws Exception {
		bookM.getBooks().clear();

		bookM.addBook("codigo", "nome", "editora","autor", "edicao");
		bookM.addBook("codigo1", "nome1", "editora1","autor1", "edicao1");
		bookM.addBook("codigo2", "nome2", "editora2","autor2", "edicao2");
	}

	@After
	public void tearDown() throws Exception	{
		bookM.getBooks().clear();
	}

	@Test
	public void testDeleteBookCorrect()
	{
		try
		{
			bookM.deleteBook("codigo");
		}
		catch (NullPointerException | CodigoInvalidException| InfraException | IOException e)
		{
			fail("Test falhou! Deveria remover um livro.");
		}
	}

	@Test
	public void testLoginFail1()
	{
		try
		{
			bookM.deleteBook(null);
			fail("Test falhou! Deveria lançar uma exceção.");
		}
		catch (NullPointerException | CodigoInvalidException| InfraException | IOException e){}
	}

	@Test
	public void testLoginFail2()
	{
		try
		{
			bookM.deleteBook("");
			fail("Test falhou! Deveria lançar uma exceção.");
		}
		catch (NullPointerException | CodigoInvalidException| InfraException | IOException e){}
	}

	@Test
	public void testLoginFail3()
	{
		try
		{
			bookM.deleteBook("desconhecido");
			fail("Test falhou! Deveria lançar uma exceção.");
		}
		catch (NullPointerException | CodigoInvalidException| InfraException | IOException e) {}
	}
}