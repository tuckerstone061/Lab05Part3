/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part3;

/**
 *
 * @author sstoneman1
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBTests {

    public static void main(String[] args) throws SQLException {
        String host = "jdbc:derby://localhost:1527/Tests";
        String uName = "student";
        String uPass = "student";
        int number;
        String question;
        boolean answer;

        try {
            Connection con = DriverManager.getConnection(host, uName, uPass);

            Statement state = con.createStatement();
            String SQL;

            for (int i = 1; i < 3; i++) {
                SQL = "SELECT * FROM STUDENT.TEST0" + i;
                System.out.println("\n\tTEST # " + i);
                ResultSet Rset = state.executeQuery(SQL);
                while (Rset.next()) {
                    number = Rset.getInt("Number");
                    question = Rset.getString("Question");
                    answer = Rset.getBoolean("Answer");

                    System.out.println("\n" + number + ". " 
                            + question + "\nAnswer: " + answer);
                }
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

}
