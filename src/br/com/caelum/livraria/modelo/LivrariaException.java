package br.com.caelum.livraria.modelo;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class LivrariaException extends RuntimeException {

	public LivrariaException(String message) {
	   super(message);
	}

}
