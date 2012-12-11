package swing.action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JInserirMenuAction  extends AbstractAction {
	public static final String INSERIR1 = "INSERIR1";

	private JPanel principal;
	private CardLayout cards;
	
	public JInserirMenuAction(JPanel principal, CardLayout cards) {
		super("Inserir");
		this.principal = principal;
		this.cards = cards;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		cards.show(principal, INSERIR1);
	}
}