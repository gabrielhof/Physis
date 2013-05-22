package br.feevale.physis.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.feevale.physis.dao.PessoaDAO;
import br.feevale.physis.dao.TesteDAO;
import br.feevale.physis.model.Pessoa;

public class IndexController implements DefaultController {

	@Resource
	private PessoaDAO pessoaDao;
	
	@Resource
	private TesteDAO testeDao;
	
	@Override
	public void indexAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Pessoa> pessoas = pessoaDao.getList();
		
		for (Pessoa pessoa : pessoas) {
			response.getWriter().println(pessoa.getName() + "\n\n");
		}
	}
	
	public void testAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Pessoa> pessoas = pessoaDao.getList();
		
		for (Pessoa pessoa : pessoas) {
			response.getWriter().println(pessoa.getName() + "\n\n");
		}
	}
	
}
