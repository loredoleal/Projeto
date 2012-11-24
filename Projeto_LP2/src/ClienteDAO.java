import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public class ClienteDAO {
	private static final String selectFindCliente = "SELECT * FROM \"Cliente\" WHERE cod = ?";
//---------------------------------//-------------------------------------------------
	
	public Cliente findCliente(int codigo){

		Cliente c = null;
		
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/LP2", "postgres",
					"senacrs");
			PreparedStatement stmt = con.prepareStatement(selectFindCliente);
			stmt.setInt(1, codigo);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int cod = rs.getInt("cod");
				String nome = rs.getString("nome");
				String end = rs.getString("end");
				String fone_1 = rs.getString("fone_1");
				String fone_2 = rs.getString("fone_2");
				String obs = rs.getString("obs");
				c = new Cliente(cod, nome, end, fone_1, fone_2, obs);
				}
			} catch (Exception e) {
				e.printStackTrace();
				// FIXME: comunicar erro ao programa
			}
			return c;
				
	}
//---------------------------------//-------------------------------------------------
	public static void main(String[] args) {
		ClienteDAO cliente = new ClienteDAO();
		Cliente c = cliente.findCliente(1);
		if (c == null) {
			System.out.println("Cliente não encontrado!");
		} else {
			System.out.println(c);
		}
	}

}
