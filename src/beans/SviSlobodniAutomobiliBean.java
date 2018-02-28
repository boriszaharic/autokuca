package beans;

import java.util.ArrayList;
import java.util.List;

import managers.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import dbmodel.Vozilo;

public class SviSlobodniAutomobiliBean {
	
	private List<Vozilo> automobili = null;

	@SuppressWarnings("unchecked")
	public SviSlobodniAutomobiliBean() {

		try {
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			session.beginTransaction();
			List<Vozilo> lista = new ArrayList<Vozilo>();
			
			Criteria crit = session.createCriteria(Vozilo.class);
			crit.add(Restrictions.sizeLt("prodajas", 1));

			lista = crit.list();

			setAutomobili(lista);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Vozilo> getAutomobili() {
		return automobili;
	}

	public void setAutomobili(List<Vozilo> automobili) {
		this.automobili = automobili;
	}

}
