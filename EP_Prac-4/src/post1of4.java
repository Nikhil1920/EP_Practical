import java.sql.*;
import java.util.Scanner;

public class post1of4 {
    public static void main(String[] args) throws Exception {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "nikhil");

            Statement stmt = con.createStatement();

            Scanner scanner = new Scanner(System.in);

            // Code used to create wildlife table
            // CREATE TABLE wildlife (
            // name VARCHAR(255) NOT NULL,
            // category NUMBER(1) NOT NULL,
            // image VARCHAR(255) NOT NULL,
            // description VARCHAR(255) NOT NULL
            // );
            for (int i = 6; i > 4; i++) {
                System.out.println("1. Insert data\n2. View data\n3. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        try {
                            PreparedStatement insert = con.prepareStatement("INSERT INTO wildlife VALUES (?, ?, ?, ?)");

                            System.out.println("Please enter name of animal or plant");
                            String name = scanner.nextLine();
                            insert.setString(1, name);

                            System.out.println("Please enter the number corresponding to " + name + "'s category");
                            System.out.println("1 for plant \n2 for animal");
                            int category = scanner.nextInt();
                            scanner.nextLine();
                            insert.setInt(2, category);

                            System.out.println("Please enter path to image file");
                            String imgfilepath = scanner.nextLine();
                            insert.setString(3, imgfilepath);

                            System.out.println("Please enter path to description file");
                            String txtfilepath = scanner.nextLine();
                            insert.setString(4, txtfilepath);

                            int num = insert.executeUpdate();
                            System.out.println(num + " record inserted");
                        } catch (Exception e) {
                            System.out.println(e + "\n Please try again");
                        }
                        break;
                    case 2:
                        ResultSet rs = stmt.executeQuery("select * from wildlife");
                        System.out.println("Name | Category | image file path | description file path");
                        while (rs.next()) {
                            String category = (rs.getInt(2) == 1) ? "plant" : "animal";
                            System.out.println(rs.getString(1) + " | " + category + " | " + rs.getString(3) + " | "
                                    + rs.getString(4));
                        }
                        break;
                    case 3:
                        con.close();
                        scanner.close();
                        i = 2;
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
