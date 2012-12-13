package swing;

import java.awt.CardLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import swing.action.JInserirPanelCloseAction;
import main.Cliente;
import main.ClienteDAO;

@SuppressWarnings("serial")
public class JConsultarClientePanel extends JPanel {
	private JTextArea dados;
	public JConsultarClientePanel(JPanel principal, CardLayout cards) {
		dados = new JTextArea(20,60); 
		dados.setEditable(false);
		add(dados);
		add(new JButton(new JInserirPanelCloseAction(principal, cards)));
	}

	public JConsultarClientePanel() {
		this(null, null);
	}
	
	@Override
	public void setVisible(boolean aFlag) {
		super.setVisible(aFlag);
		if (aFlag == false) {
			return;
		}
		System.out.printf("JInserirPanel::setVisible %b\n", aFlag);
	ClienteDAO cliente2 = new ClienteDAO();
		Cliente c = cliente2.findCliente(1);
		if (c == null) {
		//FIXME: comunicar erro ao programa
		} else {
			System.out.println(c);
			List<Cliente> cli = cliente2.consultarCliente(c);
			String s = "";
			for (Cliente cliente : cli) {
				s += String.format("%S // %S // %S // %S // %S\n",cliente.getNome(), cliente.getEndereco(), cliente.getFone_1(), cliente.getFone_2(), cliente.getObs());
			}
			dados.setText(s);
			}
	}
	


private static void createAndShowGUI() {
	JFrame frame = new JFrame("VTI Informática");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel painel = new JConsultarClientePanel();
		frame.getContentPane().add(painel);

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}