import java.sql.*;
import java.util.Scanner;

public class VulnerableLogin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");
            Statement stmt = conn.createStatement();

            String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
            System.out.println("Executing: " + query);

            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                System.out.println("Login successful (vulnerable).");
            } else {
                System.out.println("Login failed.");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
