package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClienteDAO {
	private static final String selectFindCliente = "SELECT * FROM cliente WHERE cod = ?";
	private static final String selectFindEquipamento = "SELECT * FROM equipamento WHERE os = ?";
	private static final String selectFindClientes = "SELECT * FROM cliente";
	private static final String selectFindEquipamentoCliente = "SELECT * FROM equipamento CROSS JOIN cliente WHERE equipamento.fkcliente=cliente.cod";
	// private static final String updateCliente =UPDATE cliente SET fone_2=?
	// WHERE cod = ?";
	private static final String insertCliente = "INSERT INTO cliente(nome, endereco, fone_1, fone_2, obs) values (?, ?, ?, ?, ?)";


	// ---------------------------------//-------------------------------------------------

	public Equipamento findEquipamento(int oscod) {

		Equipamento e = null;

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/LP2", "postgres", "2236");
			PreparedStatement stmt = con.prepareStatement(selectFindEquipamento);
			stmt.setInt(1, oscod);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int os = rs.getInt("os");
				String descricao = rs.getString("descricao");
				String acessorios = rs.getString("acessorios");
				String defeitoreclamado = rs.getString("defeitoreclamado");
				Date data_in = rs.getDate("data_in");
				Date data_out = rs.getDate("data_out");
				String tecnico = rs.getString("tecnico");
				boolean autorizado = rs.getBoolean("autorizado");
				boolean pronto = rs.getBoolean("pronto");
				String defeitoencontrado = rs.getString("defeitoencontrado");
				int fkcliente = rs.getInt("fkcliente");
				float valor = rs.getFloat("valor");
				boolean naloja = rs.getBoolean("naloja");
				e = new Equipamento(os, descricao, acessorios, defeitoreclamado, data_in, data_out, tecnico, autorizado, pronto, defeitoencontrado, fkcliente, valor, naloja);
			}
		} catch (Exception x) {
			x.printStackTrace();
			// FIXME: comunicar erro ao programa
		}
		return e;

	}

	// ---------------------------------//-------------------------------------------------

	public Cliente findCliente(int codigo) {

		Cliente c = null;

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/LP2", "postgres", "2236");
			PreparedStatement stmt = con.prepareStatement(selectFindCliente);
			stmt.setInt(1, codigo);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int cod = rs.getInt("cod");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String fone_1 = rs.getString("fone_1");
				String fone_2 = rs.getString("fone_2");
				String obs = rs.getString("obs");
				c = new Cliente(cod, nome, endereco, fone_1, fone_2, obs);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// FIXME: comunicar erro ao programa
		}
		return c;

	}

	// ---------------------------------//-------------------------------------------------

	public void inserir(String nome, String endereco, String fone_1,
			String fone_2, String obs) {
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/LP2", "postgres", "2236");

			PreparedStatement stmt = con.prepareStatement(insertCliente);
			stmt.setString(1, nome);
			stmt.setString(2, endereco);
			stmt.setString(3, fone_1);
			stmt.setString(4, fone_2);
			stmt.setString(5, obs);
			int r = stmt.executeUpdate();
			if (r != 1) {
				throw new RuntimeException("Erro ao inserir cliente");
			}
		} catch (Exception e) {
			// FIXME: comunicar erro ao programa
			e.printStackTrace();
		}
		// FIXME: fechar conexões
	}

	// ---------------------------------//-------------------------------------------------

	// private void atualizar(Cliente c, String fone) {
	// try {
	// Connection con = DriverManager.getConnection(
	// "jdbc:postgresql://localhost:5432/LP2", "postgres",
	// "2236");
	//
	// PreparedStatement stmt = con.prepareStatement(updateCliente);
	// stmt.setString(1, fone);
	// stmt.setInt(2, c.getCod());
	// stmt.executeUpdate();
	// } catch (Exception e) {
	// // FIXME: comunicar erro ao programa
	// e.printStackTrace();
	// }
	// // FIXME: fechar conexões
	// }

	// ---------------------------------//-------------------------------------------------

	public List<Cliente> consultarClientes() {

		List<Cliente> cli = new ArrayList<Cliente>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/LP2", "postgres", "2236");

			stmt = con.prepareStatement(selectFindClientes);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int cod = rs.getInt("cod");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String fone_1 = rs.getString("fone_1");
				String fone_2 = rs.getString("fone_2");
				String obs = rs.getString("obs");
				Cliente c2 = new Cliente(cod, nome, endereco, fone_1, fone_2,
						obs);
				cli.add(c2);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// FIXME: comunicar erro ao programa cliente
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					stmt.close();
				}
				if (con != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				// FIXME: comunicar erro ao programa cliente
			}
		}
		return cli;
	}

	// ---------------------------------//-------------------------------------------------

	public List<Equipamento> consultarEquipamento() {

		List<Equipamento> equ = new ArrayList<Equipamento>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/LP2", "postgres", "2236");

			stmt = con.prepareStatement(selectFindEquipamentoCliente);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int os = rs.getInt("os");
				String descricao = rs.getString("descricao");
				String acessorios = rs.getString("acessorios");
				String defeitoreclamado = rs.getString("defeitoreclamado");
				Date data_in = rs.getDate("data_in");
				Date data_out = rs.getDate("data_out");
				String tecnico = rs.getString("tecnico");
				boolean autorizado = rs.getBoolean("autorizado");
				boolean pronto = rs.getBoolean("pronto");
				String defeitoencontrado = rs.getString("defeitoencontrado");
				int fkcliente = rs.getInt("fkcliente");
				String nomecli = rs.getString("nome");
				float valor = rs.getFloat("valor");
				boolean naloja = rs.getBoolean("naloja");
				Equipamento e = new Equipamento(os, descricao, acessorios, defeitoreclamado, data_in, data_out, tecnico, autorizado, pronto, defeitoencontrado, fkcliente, nomecli, valor, naloja);
				e.setNomecli(nomecli);
				equ.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// FIXME: comunicar erro ao programa cliente
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					stmt.close();
				}
				if (con != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				// FIXME: comunicar erro ao programa cliente
			}
		}
		return equ;
	}

	// ---------------------------------//-------------------------------------------------
	public static void main(String[] args) {
		int i = 1;

		ClienteDAO cliente = new ClienteDAO();
		ClienteDAO equipamento= new ClienteDAO();
		// cliente.inserir("João", "Rua baba", "99999999", "33221111", "");
		Equipamento e = equipamento.findEquipamento(1);
		System.out.println(e);
		while (i != 0) {
			Cliente c = cliente.findCliente(i);
			if (c == null) {
				i = 0;
			} else {
				System.out.println(c);
				i++;
				// cliente.atualizar(c,"74747474");
//				System.out.println(cliente.consultarClientes());
				System.out.println(equipamento.consultarEquipamento());
			}
		}
	}

}
