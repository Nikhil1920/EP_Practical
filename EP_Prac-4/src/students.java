import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class students {
    public static void main(String[] args) throws Exception {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "nikhil");

            Statement stmt = con.createStatement();

            Scanner scanner = new Scanner(System.in);

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

            // Create the Student table
            String query = "CREATE TABLE students (Student_ID NUMBER(10) PRIMARY KEY, Student_Name VARCHAR(255) NOT NULL, Email VARCHAR(255) NOT NULL, Date_of_Birth NUMBER(6))";
            try {
                stmt.executeUpdate(query);
                System.out.println("Students table created successfully");
            } catch (Exception e) {
                System.out.println("Student Table already exists");
            }

            // Create the workshop table
            query = "CREATE TABLE workshop (Student_ID NUMBER(10) PRIMARY KEY, contactNumber NUMBER(10) NOT NULL)";
            try {
                stmt.executeUpdate(query);
                System.out.println("workshop table created successfully");
            } catch (Exception e) {
                System.out.println("Workshop Table already exists");
            }

            for (int i = 6; i > 4; i++) {
                System.out.println("1. insert data into students table");
                System.out.println("2. insert interested students data into workshop table");
                System.out.println("3. View Students table");
                System.out.println("4. View workshop table");
                System.out.println("5. Delete not interested students data");
                System.out.println("6. Exit program");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        PreparedStatement prepstmt = con
                                .prepareStatement("INSERT INTO students VALUES (?, ?, ?,TO_DATE(?, 'DD/MM/YYYY'))");
                        System.out.println("Please enter Student id: ");
                        int studentId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Please enter Student name : ");
                        String studentName = scanner.nextLine();
                        System.out.println("Please enter Student Email : ");
                        String studentEmail = scanner.nextLine();
                        System.out.println("Please enter Student date of birth in dd/mm/yyyy format : ");
                        String studentdob = scanner.nextLine();
                        prepstmt.setInt(1, studentId);
                        prepstmt.setString(2, studentName);
                        prepstmt.setString(3, studentEmail);
                        prepstmt.setString(4, studentdob);
                        int num = prepstmt.executeUpdate();
                        System.out.println(num + " record inserted");
                        break;

                    case 2:
                        PreparedStatement intoWorkshop = con
                                .prepareStatement("INSERT INTO workshop VALUES (?, ?, null, null)");
                        System.out.println("Please enter Student id: ");
                        int insertedstudentId = scanner.nextInt();
                        System.out.println("Please enter Student contact number: ");
                        int contactNumber = scanner.nextInt();
                        intoWorkshop.setInt(1, insertedstudentId);
                        intoWorkshop.setInt(2, contactNumber);
                        num = intoWorkshop.executeUpdate();
                        System.out.println(num + " record inserted");
                        break;

                    case 3:
                        ResultSet rs = stmt.executeQuery("select * from students");
                        while (rs.next())
                            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  "
                                    + formatter.format(rs.getDate(4)));
                        break;
                    case 4:
                        try {
                            query = "ALTER TABLE workshop ADD (studentName VARCHAR(255), studentEmail VARCHAR(255))";
                            stmt.executeUpdate(query);
                            System.out.println("workshop table altered successfully");
                        } catch (Exception e) {
                            System.out.println("Workshop Table already altered");
                        }
                        try {
                            query = "UPDATE workshop t1 SET (StudentName, studentEmail) = (SELECT t2.Student_Name, t2.Email FROM students t2 WHERE t1.Student_ID=t2.Student_ID) WHERE EXISTS (SELECT 1 FROM students t2 WHERE t1.Student_ID=t2.Student_ID )";
                            stmt.executeUpdate(query);
                        } catch (Exception e) {
                            System.out.println();
                        }
                        rs = stmt.executeQuery("select * from workshop");
                        while (rs.next())
                            System.out.println(rs.getInt(1) + "  " + rs.getInt(2) + "  " + rs.getString(3) + "  "
                                    + rs.getString(4));
                        break;
                    case 5:
                        int notInterestStudentId;
                        System.out.println("Please enter student ID of not interested student : ");
                        notInterestStudentId = scanner.nextInt();
                        PreparedStatement deleteData = con.prepareStatement("DELETE FROM workshop WHERE Student_ID=?");
                        deleteData.setInt(1, notInterestStudentId);
                        try {
                            deleteData.executeUpdate();
                            System.out.println("Student Data deleted successfully");
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            System.out.println("Please try again");
                        }
                        break;
                    case 6:
                        i = 2;
                        break;

                }
            }

            scanner.close();

            stmt.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
