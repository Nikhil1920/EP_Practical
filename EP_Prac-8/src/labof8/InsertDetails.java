package labof8;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertDetails {
	public static void main(String[] args) {
		Boolean continues = true;
		Scanner sc = new Scanner(System.in);
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		while (continues) {
			RiceBag r = new RiceBag();
			System.out.println("Enter the id of the rice bag : ");
			int bid = sc.nextInt();
			System.out.println("Enter the quantity of rice bag in kgs : ");
			int amt = sc.nextInt();
			System.out.println("Enter the cost of rice bag : ");
			double cst = sc.nextDouble();
			System.out.println("Enter the type of rice bag(polished/nonpolished) : ");
			String t = sc.next();
			r.setId(bid);
			r.setQuantity(amt);
			r.setCost(cst);
			r.setType(t);
			s.save(r);
			Transaction tx = s.beginTransaction();
			tx.commit();
			System.out.println("Do you want to insert(yes/no) : ");
			String proceed = sc.next();
			if (proceed.equals("no")) {
				continues = false;
			}
		}
		System.out.println("Data has been entered\n");
		s.close();
		sc.close();
	}
}
