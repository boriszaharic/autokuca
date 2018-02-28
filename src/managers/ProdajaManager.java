package managers;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import dbmodel.Prodaja;
import dbmodel.Prodavac;
import dbmodel.Vozilo;

public class ProdajaManager {

	public static Prodaja getProdajaById(int id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Prodaja pr = (Prodaja) session.get(Prodaja.class, id);
		session.getTransaction().commit();
		return pr;
	}

	@SuppressWarnings({ "static-access", "unchecked" })
	public static int prodajAutomobil(int idVozila, int idProdavca) {
		try {

			VoziloManager vm = new VoziloManager();
			Vozilo vozilo = vm.getVoziloById(idVozila);

			ProdavacManager pm = new ProdavacManager();
			Prodavac prodavac = pm.getProdavacById(idProdavca);

			if ((vozilo != null) && (prodavac != null)) {
				Session session = HibernateUtil.getSessionFactory()
						.getCurrentSession();
				session.beginTransaction();

				Prodaja p = new Prodaja(vozilo, prodavac, new Date());

				int id = (Integer) session.save(p);
				System.out.println("Snimili smo prodaju sa rednim brojem: "
						+ id);
				session.getTransaction().commit();
				
				Set <Prodaja> prodajeVozila = prodavac.getProdajas();
				prodajeVozila.add(p);
				prodavac.setProdajas(prodajeVozila);
				
				Session session2 = HibernateUtil.getSessionFactory()
						.getCurrentSession();
				session2.beginTransaction();
				
				session2.saveOrUpdate(prodavac);
				session2.getTransaction().commit();
				
				
				Set <Prodaja> voziloProdato = vozilo.getProdajas();
				voziloProdato.add(p);
				vozilo.setProdajas(voziloProdato);
				
				Session session3 = HibernateUtil.getSessionFactory()
						.getCurrentSession();
				session3.beginTransaction();
				
				session3.saveOrUpdate(vozilo);
				session3.getTransaction().commit();
				
				
				return id;
			} else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	
	@SuppressWarnings("unchecked")
	public static List<Prodaja> sveProdaje() {
		try {
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			session.beginTransaction();

			List<Prodaja> lista = (session.createQuery("from Prodaja").list());
			
			session.getTransaction().commit();
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	public static void main (String [] args) {
		
		// za testiranje
		
		prodajAutomobil(4, 1);
		
	}
	
	
	

}
