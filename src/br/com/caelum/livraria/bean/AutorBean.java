package br.com.caelum.livraria.bean;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.LivrariaException;

@Model
public class AutorBean {
	
	private Autor autor = new Autor();
	
	@Inject
	private AutorService sercice;
	
	public Autor getAutor() {
		return autor;
	}
	
	public void cadastra()  {
		this.sercice.adiciona(autor);
		this.autor = new Autor();
	}
	
	public List<Autor> getAutores() {
		return this.sercice.todosAutores();
	}
}
