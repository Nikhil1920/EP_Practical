package inlabof9;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;

public class DeleteData {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("delete from Employee where id=2");
		query.executeUpdate();
		transaction.commit();
		session.close();
		System.out.println("Deleted a Record Successfully");
	}
}
