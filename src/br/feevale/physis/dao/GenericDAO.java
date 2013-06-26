package br.feevale.physis.dao;

import java.util.List;

import br.feevale.physis.model.Bean;

public interface GenericDAO<T extends Bean> {

	public T save(T bean) throws Exception;
	
	public boolean delete(T bean) throws Exception;
	
	public T get(Integer id) throws Exception;
	
	public List<T> listAll() throws Exception;
	
	public List<T> queryByExample(T example) throws Exception;
	
}
