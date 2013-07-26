package br.feevale.physis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.feevale.physis.annotation.Request;
import br.feevale.physis.builder.view.ViewBuilder;
import br.feevale.physis.converter.RequestConverter;
import br.feevale.physis.converter.impl.BeanRequestConverter;
import br.feevale.physis.dao.HibernateDAOImpl;
import br.feevale.physis.enums.RequestMethod;
import br.feevale.physis.model.Bean;
import br.feevale.physis.util.RequestUtils;
import br.feevale.physis.util.StringUtils;
import br.feevale.physis.view.View;

public abstract class CrudController<T extends Bean> implements DefaultController {

	@Override
	public void indexAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<T> list = getDao().listAll();
		
		View view = ViewBuilder.build(getControllerName(), getListViewName());
		view.setVariable(getListVarName(), list);
		view.forward(request, response);
	}
	
	public void newAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		View view = ViewBuilder.build(getControllerName(), getViewName());
		buildVariables(view);
		view.forward(request, response);
	}
		
	public void editAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		View view = ViewBuilder.build(getControllerName(), getViewName());
		buildVariables(view);
		
		String id = request.getParameter(getIdVarName());
		if (StringUtils.isNotBlank(id)) {
			T bean = getDao().get(Integer.parseInt(id));
			view.setVariable(getBeanVarName(), bean);
		}
		
		view.forward(request, response);
	}

	@Request(methods=RequestMethod.POST)
	public void saveAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RequestConverter<T> converter = new BeanRequestConverter<T>(request, getDao().getBeanClass());
		T bean  = converter.convert();
		
		beforeSave(bean);
		getDao().save(bean);
		afterSave(bean);
		
		RequestUtils.redirect(request, response, getControllerName());
	}
	
	@Request(methods=RequestMethod.POST)
	public void deleteAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		if (StringUtils.isNotBlank(id)) {
			T bean = getDao().get(new Integer(id));
			getDao().delete(bean);
		}
		
		RequestUtils.redirect(request, response, getControllerName());
	}
	
	
	protected abstract HibernateDAOImpl<T> getDao();
	
	protected abstract String getListVarName();
	protected abstract String getBeanVarName();
	protected String getIdVarName() {
		return "id";
	}
	
	protected abstract String getControllerName();
	protected abstract String getListViewName();
	protected abstract String getViewName();
	
	protected void buildVariables(View view) throws Exception {}
	protected void beforeSave(T bean) throws Exception {}
	protected void afterSave(T bean) throws Exception {}
}
