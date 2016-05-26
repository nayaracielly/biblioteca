package business.util;

import java.util.List;

import business.model.Livro;


public class BookValidador {

	public static void validateCodigo(String codigo) throws CodigoInvalidException  {
		if(codigo == null | codigo.length() <= 0)
			throw new CodigoInvalidException("C�digo vazio!\n");
		else if(codigo.length() > 10) 
			throw new CodigoInvalidException("C�digo com mais de 10 caracteres!\n");
	}

	
	public static boolean validateBookExistence(List<Livro> books, String codigo){
		for (Livro book : books){
			if (codigo != null && codigo.equals(book.getCodigo()))
				return true;
		}
		return false;
	}
}
