package br.feevale.physis.business.model.dao;

import br.feevale.physis.business.model.bean.Equipment;
import br.feevale.physis.dao.HibernateDAOImpl;

public class EquipementDAO extends HibernateDAOImpl<Equipment> {

	@Override
	protected Class<Equipment> getBeanClass() {
		return Equipment.class;
	}

}
