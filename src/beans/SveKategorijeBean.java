package beans;

import java.util.List;

import managers.HibernateUtil;

import org.hibernate.Session;

import dbmodel.Kategorija;

public class SveKategorijeBean {
	
	private List<Kategorija> kategorije = null;

	@SuppressWarnings("unchecked")
	public SveKategorijeBean() {

		try {
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			session.beginTransaction();

			setKategorije(session.createQuery("from Kategorija").list());
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Kategorija> getKategorije() {
		return kategorije;
	}

	public void setKategorije(List<Kategorija> kategorije) {
		this.kategorije = kategorije;
	}
}
