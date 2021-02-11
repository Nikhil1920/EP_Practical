import java.sql.*;
import java.util.*;

public class supermarket {
    public static void main(String[] args) throws Exception {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "nikhil");

            Scanner scanner = new Scanner(System.in);

            Statement stmt = con.createStatement();

            System.out.println("Please enter the number of items you have bought : ");
            int numofitems = scanner.nextInt();

            for (int i = 0; i < numofitems; i++) {
                System.out.println("Please enter the item id : ");
                int item_id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Please enter the item name : ");
                String item_name = scanner.nextLine();
                System.out.println("Please enter the item price : ");
                double item_price = scanner.nextDouble();
                String insertquery = String.format("INSERT INTO sales VALUES (%d, '%s', %.2f)", item_id, item_name,
                        item_price);
                stmt.executeUpdate(insertquery);
            }
            System.out.println("Entered items details : ");

            ResultSet rs = stmt.executeQuery("select * from sales");
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getFloat(3));

            int sum = 0;
            rs = stmt.executeQuery("SELECT SUM(price) FROM sales");
            rs.next();
            sum = rs.getInt(1);
            System.out.println("Total price of the Items entered = " + sum);

            scanner.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
