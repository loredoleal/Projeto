package swing;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import swing.action.JAboutMenuAction;
import swing.action.JInserirMenuAction;
import swing.action.JSairMenuAction;


public class Servico {
	public static final String PRINCIPAL = "PRINCIPAL";
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("VTI Informática");
		CardLayout cards = new CardLayout();
		JPanel principal = new JPanel(cards);
		
		JPanel inserir = new JInserirPanel(principal, cards);
		JPanel vazio = new JPanel();
		JLabel label = new JLabel("VTI Infirmática.");
		vazio.add(label);
		
		principal.add(vazio, PRINCIPAL);
		principal.add(inserir, JInserirMenuAction.INSERIR1);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setIconImage(new ImageIcon("pindorama.jpg").getImage());
		
		frame.getContentPane().add(principal);
		
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("Arquivo");
		menubar.add(file);
		JMenu cadastrar = new JMenu("Cadastrar");
		menubar.add(cadastrar);
		JMenu help = new JMenu("Ajuda");
		menubar.add(help);
		
		Action exitAction = new JSairMenuAction();
		file.add(exitAction);
		
		Action inserirAction = new JInserirMenuAction(principal,cards);
		cadastrar.add(inserirAction);
		Action aboutAction = new JAboutMenuAction(frame);
		help.add(aboutAction);
		
		frame.setJMenuBar(menubar);
		
		frame.setMinimumSize(new Dimension(400,200));

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
