package br.feevale.physis.business.model.dao;

import br.feevale.physis.business.model.bean.Payment;
import br.feevale.physis.dao.HibernateDAOImpl;

public class PaymentDAO extends HibernateDAOImpl<Payment> {

	@Override
	public Class<Payment> getBeanClass() {
		return Payment.class;
	}

}
