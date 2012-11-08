import caixa.Conta;




public class ClienteDAO {
	private static final String selectFindCliente = "SELECT * FROM \"Cliente\" WHERE cod = ?";
	
	public Cliente findCliente(String cod){
		
	}
	
	public static void main(String[] args) {
		ClienteDAO cliente = new ClienteDAO();
		Cliente c = cliente.findcliente("2");
	}

}
