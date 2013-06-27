package br.feevale.physis.util;

import org.hibernate.Criteria;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.internal.CriteriaImpl;
import org.hibernate.loader.criteria.CriteriaJoinWalker;
import org.hibernate.loader.criteria.CriteriaQueryTranslator;
import org.hibernate.persister.entity.OuterJoinLoadable;

public class HibernateUtils {

	public static String toSQL(Criteria criteria) {
		CriteriaImpl impl = (CriteriaImpl) criteria;
		SessionImplementor session = impl.getSession();
		SessionFactoryImplementor factory = session.getFactory();
		CriteriaQueryTranslator translator = new CriteriaQueryTranslator(factory, impl, impl.getEntityOrClassName(), CriteriaQueryTranslator.ROOT_SQL_ALIAS);
		
		String implementors[] = factory.getImplementors(impl.getEntityOrClassName());
		
		CriteriaJoinWalker walker = new CriteriaJoinWalker((OuterJoinLoadable)factory.getEntityPersister(implementors[0]), translator, factory, impl, impl.getEntityOrClassName(), session.getLoadQueryInfluencers());
		
		return walker.getSQLString();
	}
	
}
