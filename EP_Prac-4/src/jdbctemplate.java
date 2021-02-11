
//Step 1 : import java.sql package
import java.sql.*;

public class jdbctemplate {
    public static void main(String[] args) throws Exception {
        try {
            // Step 2 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

            String dbUserName = "system";// your user name goes here

            String dbUserPassword = "nikhil";// your password goes here

            // step 3 create the connection object
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", dbUserName,
                    dbUserPassword);

            // step 4 create the statement object
            Statement stmt = con.createStatement();

            /*
             * step 5 Now the connection has been established succesfully Now you can
             * execute your necessary commands here
             */

            ResultSet rs = stmt.executeQuery("select * from student");
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getInt(3));

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
