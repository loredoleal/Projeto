package swing;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Servico {
	public static final String PRINCIPAL = "PRINCIPAL";
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("VTI Informática");
		CardLayout cards = new CardLayout();
		JPanel principal = new JPanel(cards);
	}

}
