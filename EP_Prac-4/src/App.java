import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            // step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

            String dbUserName = "system";// your user name goes here

            String dbUserPassword = "nikhil";// your password goes here

            // step2 create the connection object
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", dbUserName,
                    dbUserPassword);

            // step3 create the statement object
            Statement stmt = con.createStatement();

            // Delete any previous values in the table
            stmt.executeUpdate("TRUNCATE TABLE student");

            // Prepare to insert new names in the EMP table
            String query1 = "INSERT INTO student (id, name, age)" + "VALUES ('1', 'Felix', '20')";

            String query2 = "INSERT INTO student (id, name, age)" + "VALUES ('2', 'Jack', '19')";

            String query3 = "INSERT INTO student (id, name, age)" + "VALUES ('3', 'mark', '21')";

            int count = stmt.executeUpdate(query1);
            System.out.println("Number of rows updated in database =  " + count);

            // Executing next SQL INSERT query using executeUpdate() method of Statement
            // object.

            count = stmt.executeUpdate(query2);
            System.out.println("Number of rows updated in database = " + count);

            // Executing next SQL INSERT query using executeUpdate() method of Statement
            // object.
            count = stmt.executeUpdate(query3);
            System.out.println("Number of rows updated in database = " + count);

            // step4 execute query
            ResultSet rs = stmt.executeQuery("select * from student");
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getInt(3));

            ResultSet rs2 = stmt.executeQuery("select * from student where age<21");
            System.out.println("students whose age is less than 21 are");
            while (rs2.next())
                System.out.println(rs2.getInt(1) + "  " + rs2.getString(2) + "  " + rs2.getInt(3));
            // step5 close the connection object
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
