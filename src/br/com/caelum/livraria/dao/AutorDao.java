package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.LivrariaException;
import br.com.caleum.livraria.interceptor.LogInterceptor;


@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
//@Interceptors({LogInterceptor.class})
public class AutorDao {

	@PersistenceContext
	private EntityManager manager;

	
	@PostConstruct
	public void aposCriacao() {
		System.out.println("AutorDao foi criado");
		
	}


	public void salva(Autor autor)  {
		manager.persist(autor);
	}
	
	public List<Autor> todosAutores() {
		return manager.createQuery("select a from Autor a",Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.manager.find(Autor.class,autorId);
		return autor;
	}
	
}
