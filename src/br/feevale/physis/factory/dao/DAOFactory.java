package br.feevale.physis.factory.dao;

import br.feevale.physis.dao.GenericDAO;
import br.feevale.physis.model.Bean;

public interface DAOFactory {

	public <T extends Bean> GenericDAO<T> getDAO(Class<? extends GenericDAO<T>> daoInterface);
	
}
