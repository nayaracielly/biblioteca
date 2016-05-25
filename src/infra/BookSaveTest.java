package infra;

import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import business.control.BookManager;

public class BookSaveTest{
	BookFile bookF = BookFile.getInstancia();
	BookManager bookM = BookManager.getInstancia();
	
	@Before
	public void setUp() throws Exception{
		bookM.getBooks().clear();
	}

	@After
	public void tearDown() throws Exception{
		bookM.getBooks().clear();
	}

	@Test
	public void testSaveBookCorrect(){
		try{
			bookF.saveBooks();
		}
		catch (NullPointerException | InfraException | IOException e){
			fail("Test falhou! Deveria salvar nova lista.");
		}
	}
	
	@Test
	public void testSaveFail1(){
		try{
			bookF.saveBooks(bookM.getBooks(), null);
			fail("Test falhou! Deveria lançar uma exceção.");
		}
		catch (NullPointerException | InfraException | IOException e) {}
	}
}
