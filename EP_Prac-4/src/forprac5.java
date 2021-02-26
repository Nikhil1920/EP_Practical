import java.sql.*;

public class forprac5 {
    public static void main(String[] args) throws Exception {
        String dbUserName = "system";

        String dbUserPassword = "nikhil";

        String oracleurl = "jdbc:oracle:thin:@localhost:1521:XE";

        String query = "SELECT firstname FROM login WHERE email=?";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(oracleurl, dbUserName, dbUserPassword);

            PreparedStatement prepst = con.prepareStatement(query);

            prepst.setString(1, "190031920@kluniversity.in");

            ResultSet rs = prepst.executeQuery();

            rs.next();

            System.out.println(rs.getString(1));

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Error");
    }
}
