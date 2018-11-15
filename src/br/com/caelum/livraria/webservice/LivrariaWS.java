package br.com.caelum.livraria.webservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Livro;

@Stateless
@WebService
public class LivrariaWS {
	
	@Inject
	private LivroDao dao;

	@WebMethod(operationName="ProcurarPorNome")
	@WebResult(name="livros")
	public List<Livro> getLivrosPeloNome(@WebParam(name="titulo") String nome){
		System.out.println("Livraria - Procurando livro pelo nome :" + nome);
		return dao.buscaLivrosPeloNome(nome);
	}
}
