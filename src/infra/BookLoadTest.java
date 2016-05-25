package infra;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import business.control.BookManager;

public class BookLoadTest{
	BookFile bookF = BookFile.getInstancia();
	BookManager bookM = BookManager.getInstancia();
	@Before
	public void setUp() throws Exception{
		bookM.getBooks().clear();;
	}

	@After
	public void tearDown() throws Exception{
		bookM.getBooks().clear();
	}
	@Test
	public void testLoadBookCorrect(){
		try{
			bookF.loadBooks();
		}
		catch (NullPointerException | InfraException | IOException e)
		{
			fail("Test falhou! Deveria carregar lista.");
		}
	}

	@Test
	public void testLoadFail1(){
		try{
			bookF.loadBooks(null);
			fail("Test falhou! Deveria lançar uma exceção.");
		}
		catch (NullPointerException | InfraException | IOException e) {}
	}

	@Test
	public void testLoadFail2(){
		try{
			bookF.loadBooks("");
			fail("Test falhou! Deveria lançar uma exceção.");
		}
		catch (NullPointerException | InfraException | IOException e) {}
	}
}