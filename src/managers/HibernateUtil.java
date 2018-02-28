package managers;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static ServiceRegistry serviceRegistry;
	
	private static SessionFactory buildSessionFactory(){
		try{
			Configuration cfg = new Configuration()
			 	.configure(HibernateUtil.class.getResource("/dbmodel/hibernate.cfg.xml"));
			serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(cfg.getProperties()).buildServiceRegistry();
			
			return cfg.buildSessionFactory(serviceRegistry);
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
		
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	

}
