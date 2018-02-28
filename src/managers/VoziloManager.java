package managers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import dbmodel.Kategorija;
import dbmodel.Prodaja;
import dbmodel.Vozilo;

public class VoziloManager {

	public static Vozilo getVoziloById(int id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Vozilo vozilo = (Vozilo) session.get(Vozilo.class, id);
		session.getTransaction().commit();
		return vozilo;
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	public static int snimiVozilo(int idKat, String marka, String model,
			int cena, int godina, String boja) {
		try {
			KategorijaManager km = new KategorijaManager();
			Kategorija kategorija = km.getKategorijaById(idKat);
			
			
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			session.beginTransaction();

			Set<Prodaja> prodaje = new HashSet<Prodaja>(0);

			

			Vozilo v = new Vozilo(kategorija, marka, model, cena, godina, boja,
					prodaje);

			int id = (Integer) session.save(v);
			System.out.println("Snimili smo vozilo sa rednim brojem: " + id);
			session.getTransaction().commit();
			
			Set<Vozilo> lista = kategorija.getVozilos();
			lista.add(v);
			kategorija.setVozilos(lista);
			
			Session session2 = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			session2.beginTransaction();
			
			session2.saveOrUpdate(kategorija);
			session2.getTransaction().commit();
			
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@SuppressWarnings("static-access")
	public static boolean updateVozila(int idVozila,int idKat, String marka,
			String model, int cena, int godina, String boja) {

		try {
			
			KategorijaManager km = new KategorijaManager();
			Kategorija k = km.getKategorijaById(idKat);
			
			Vozilo v = getVoziloById(idVozila);
			
			if (v != null) {

				v.setBoja(boja);
				v.setCena(cena);
				v.setGodinaproizvodnje(godina);
				v.setKategorija(k);
				v.setMarka(marka);
				v.setModel(model);
				
				Session session = HibernateUtil.getSessionFactory()
						.getCurrentSession();
				session.beginTransaction();
				
				session.saveOrUpdate(v);
				session.getTransaction().commit();
				return true;
			}
			return false;
		} catch (Exception e) {
			System.out.println("Greska prilikom update vozila!");
			return false;
		}
		
	}
	
	
	public static boolean izbrisiVozilo(int id) {
		
		try{
			Session sesija = HibernateUtil.getSessionFactory().getCurrentSession();
			sesija.beginTransaction();
			
			Vozilo v = (Vozilo) sesija.createCriteria(Vozilo.class)
                    .add(Restrictions.eq("idvozila", id)).uniqueResult();
			sesija.delete(v);	
			
			sesija.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public static List<Vozilo> prodatiAutomobili(){
		try{
		Session sesija = HibernateUtil.getSessionFactory().getCurrentSession();
		sesija.beginTransaction();

		List<Vozilo> lista = new ArrayList<Vozilo>();

		Criteria crit = sesija.createCriteria(Vozilo.class);

		crit.add(Restrictions.sizeGt("prodajas", 0));



		lista = crit.list();

		sesija.getTransaction().commit();

		return lista;
		}catch(Exception e){
		e.printStackTrace();
		return null;
		}
	} 
	
	
	
	@SuppressWarnings("unchecked")
	public static List<Vozilo> slobodniAutomobili() {
		try{
		Session sesija = HibernateUtil.getSessionFactory().getCurrentSession();
		sesija.beginTransaction();

		List<Vozilo> lista = new ArrayList<Vozilo>();

		Criteria crit = sesija.createCriteria(Vozilo.class);

		crit.add(Restrictions.sizeLt("prodajas", 1));



		lista = crit.list();

		sesija.getTransaction().commit();

		return lista;
		}catch(Exception e){
		e.printStackTrace();
		return null;
		}
	} 
	
	
	
	

	public static void main(String[] args) {

		// za testiranje
		/*
		int id = snimiVozilo(1, "Audi", "RS8", 39000, 2013, "crvena");
		System.out.println(id);
		*/
		
		List<Vozilo> lista = prodatiAutomobili();
		System.out.println("Broj prodatih: " + lista.size());
		
		List<Vozilo> lista2 = slobodniAutomobili();
		System.out.println("Broj slobodnih: " + lista2.size());
		
		izbrisiVozilo(8);
		
		List<Vozilo> lista24 = prodatiAutomobili();
		System.out.println("Broj prodatih: " + lista24.size());
		
		List<Vozilo> lista23 = slobodniAutomobili();
		System.out.println("Broj slobodnih: " + lista23.size());
	}

}
