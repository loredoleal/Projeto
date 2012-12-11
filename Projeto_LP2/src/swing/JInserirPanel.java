package swing;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import swing.action.JInserirPanelAction;
import swing.action.JInserirPanelCloseAction;


@SuppressWarnings("serial")
public class JInserirPanel extends JPanel {
	JTextField nome;
	JTextField endereco;
	JTextField fone_1;
	JTextField fone_2;
	JTextField obs;
	public JInserirPanel(JPanel principal, CardLayout cards) {
		add(new JLabel("Nome"));
		nome = new JTextField(20);
		add(nome);
		add(new JLabel("Endereço"));
		endereco = new JTextField(50);
		add(endereco);
		add(new JLabel("Fone 1"));
		fone_1 = new JTextField(8);
		add(fone_1);
		add(new JLabel("Fone 2"));
		fone_2 = new JTextField(8);
		add(fone_2);
		add(new JLabel("Observações"));
		obs = new JTextField(50);
		add(obs);
		add(new JButton(new JInserirPanelAction(principal, cards, nome,endereco,fone_1,fone_2,obs)));
		add(new JButton(new JInserirPanelCloseAction(principal, cards)));
	}
	
	@Override
	public void setVisible(boolean aFlag) {
		super.setVisible(aFlag);
		System.out.printf("JDepositarPanel::setVisible %b\n", aFlag);
		nome.setText("");
		endereco.setText("");
		fone_1.setText("");
		fone_2.setText("");
		obs.setText("");
	}
	
	public JInserirPanel() {
		this(null, null);
	}
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("VTI Informática.");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel painel = new JInserirPanel();
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
