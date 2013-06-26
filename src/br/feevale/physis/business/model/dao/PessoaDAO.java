package br.feevale.physis.business.model.dao;

import br.feevale.physis.business.model.bean.Pessoa;
import br.feevale.physis.dao.HibernateDAOImpl;

public class PessoaDAO extends HibernateDAOImpl<Pessoa>{

	@Override
	protected Class<Pessoa> getBeanClass() {
		return Pessoa.class;
	}
	
	
}
