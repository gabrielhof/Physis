package br.feevale.physis.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.feevale.physis.dao.PessoaDAO;
import br.feevale.physis.factory.view.ViewFactory;
import br.feevale.physis.model.Pessoa;
import br.feevale.physis.view.View;

public class PersonController implements DefaultController {

	@Resource
	private PessoaDAO pessoaDAO;
	
	@Override
	public void indexAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Pessoa> pessoas = pessoaDAO.listAll();
		
		View indexView = ViewFactory.create("person", "index");
		indexView.setVariable("pessoas", pessoas);
		indexView.forward(request, response);
	}

}
