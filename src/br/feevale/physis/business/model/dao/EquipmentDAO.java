package br.feevale.physis.business.model.dao;

import br.feevale.physis.business.model.bean.Equipment;
import br.feevale.physis.dao.HibernateDAOImpl;

public class EquipmentDAO extends HibernateDAOImpl<Equipment> {

	@Override
	public Class<Equipment> getBeanClass() {
		return Equipment.class;
	}

}
