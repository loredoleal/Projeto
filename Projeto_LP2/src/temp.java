import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class temp {
	public static void main(String[] args) throws Exception {
		
	    Connection con = DriverManager.getConnection(
	                         "jdbc:postgresql://localhost:5432/LP2",
	                         "postgres",
	                         "senacrs");

	    Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery("SELECT cod FROM \"Cliente\"");

	    while (rs.next()) {
	        int x = rs.getInt("cod");
	        System.out.printf("%d\n", x);
	    }
	}
}
