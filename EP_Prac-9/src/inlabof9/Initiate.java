package inlabof9;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Initiate {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Employee employee = new Employee();
		employee.setEmpName("Vyshnav");
		employee.setEmpSalary("22000");
		employee.setEmpAddress("Tenali");
		Employee employee2 = new Employee();
		employee2.setEmpName("Kishan");
		employee2.setEmpSalary("44000");
		employee2.setEmpAddress("Vijayawada");
		session.save(employee);
		session.save(employee2);
		transaction.commit();
		session.close();
		System.out.println("Inserted SuccessFully");
	}
}
