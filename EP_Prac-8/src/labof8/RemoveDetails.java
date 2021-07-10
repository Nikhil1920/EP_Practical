package labof8;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RemoveDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        System.out.println("Enter the id of the rice bag");
        int x = sc.nextInt();
        Integer integer = Integer.valueOf(x);
        Object o = s.load(RiceBag.class, integer);
        RiceBag r = (RiceBag) o;
        System.out.println("the cost of the rice bag is :" + r.getCost());
        System.out.println("Want to purchase the bag(yes/no)");
        String y = sc.next();
        if (y.equals("yes")) {
            Transaction tx = s.beginTransaction();
            s.delete(r);
            tx.commit();
            System.out.println("the bag is sold");
        } else {
            System.out.println("Not sold");
        }
        sc.close();
        s.close();
    }
}