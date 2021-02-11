import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class post2of4 {
    public static void main(String[] args) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "nikhil");

        Statement stmt = con.createStatement();

        String path = "C:/study/EP/EP_Practical/EP_Prac-4/";

        ResultSet rs = stmt.executeQuery("select * from wildlife");

        // Create plants folder
        String plantfolder = path.concat("Plants");
        try {
            Files.createDirectories(Paths.get(plantfolder));
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        // Create animals folder
        String animalfolder = path.concat("Animals");
        try {
            Files.createDirectories(Paths.get(animalfolder));
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        String imgFileName;
        String txtFileName;
        File imgfile = null;
        File txtfile = null;

        while (rs.next()) {
            if (rs.getInt(2) == 2) {
                imgFileName = "animal_" + rs.getString(1) + ".jpg";
                txtFileName = "animal_" + rs.getString(1) + ".txt";
                imgfile = new File(animalfolder + "/" + imgFileName);
                txtfile = new File(animalfolder + "/" + txtFileName);
            } else if (rs.getInt(2) == 1) {
                imgFileName = "plant_" + rs.getString(1) + ".jpg";
                txtFileName = "plant_" + rs.getString(1) + ".txt";
                imgfile = new File(plantfolder + "/" + imgFileName);
                txtfile = new File(plantfolder + "/" + txtFileName);
            }
            try {
                FileWriter imgfw = new FileWriter(imgfile.getAbsoluteFile());
                FileWriter txtfw = new FileWriter(txtfile.getAbsoluteFile());
                BufferedWriter imgbw = new BufferedWriter(imgfw);
                BufferedWriter txtbw = new BufferedWriter(txtfw);
                imgbw.close();
                txtbw.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }

        }
    }
}
