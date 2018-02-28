package managers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;


import dbmodel.Prodaja;
import dbmodel.Prodavac;



public class ProdavacManager {
	
	
	
	
	public static Prodavac getProdavacById(int id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Prodavac pr = (Prodavac) session.get(Prodavac.class, id);
		session.getTransaction().commit();
		return pr;
	}
	
	
	public static int snimiProdavca(String ime, String prezime, String adresa, int brTel,String username,String password) {
		try {
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			session.beginTransaction();

			
			
			Set<Prodaja> prodaje = new HashSet<Prodaja>(0);
			Prodavac p = new Prodavac(ime, prezime, adresa, brTel, username,
					password, prodaje);

			int id = (Integer) session.save(p);
			System.out.println("Snimili smo prodavca sa rednim brojem: " + id);
			session.getTransaction().commit();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static boolean postoji(String user) {

		try {
			List<Integer> rezultat = new ArrayList<Integer>();

			Session sesija = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			sesija.beginTransaction();

			List<Prodavac> lista = new ArrayList<Prodavac>();

			Criteria crit = sesija.createCriteria(Prodavac.class);

			if (user != null) {
				crit.add(Restrictions.like("username", user, MatchMode.EXACT));
			}

			lista = crit.list();

			sesija.getTransaction().commit();
			return lista.size() > 0;
			

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	public static Prodavac logovanje(String user, String pass) {

		try {
			List<Integer> rezultat = new ArrayList<Integer>();

			Session sesija = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			sesija.beginTransaction();

			List<Prodavac> lista = new ArrayList<Prodavac>();

			Criteria crit = sesija.createCriteria(Prodavac.class);

			if (user != null) {
				crit.add(Restrictions.like("username", user, MatchMode.EXACT));
			}

			if (pass != null) {
				crit.add(Restrictions.like("password", pass, MatchMode.EXACT));
			}

			lista = crit.list();

			sesija.getTransaction().commit();
			if (lista.size() == 1) {
				rezultat.add(lista.get(0).getIdprodavca());
				Prodavac pro = (Prodavac) lista.get(0);
				return pro;
			} else {
				return null;
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	public static void main(String [] args) {
		// za testiranje!
		int id = snimiProdavca("Stefan", "Mikic", "Balkan", 055555555, "stefan", "stefan");
		System.out.println(id);
	}
}
