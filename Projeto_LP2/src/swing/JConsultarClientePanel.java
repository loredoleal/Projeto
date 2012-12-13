package swing;

import java.awt.CardLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import swing.action.JInserirPanelCloseAction;
//import main.Cliente;
import main.ClienteDAO;
import main.Equipamento;

@SuppressWarnings("serial")
public class JConsultarClientePanel extends JPanel {
	private JTextArea dados;

	public JConsultarClientePanel(JPanel principal, CardLayout cards) {
		dados = new JTextArea(20, 60);
		dados.setEditable(true);
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
		ClienteDAO equipamento2 = new ClienteDAO();
		String s = "";
		List<Equipamento> equ = equipamento2.consultarEquipamento();
		for (Equipamento equipamento : equ) {
			s += String.format("%S \n", equipamento.toString());
		}
		dados.setText(s);
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