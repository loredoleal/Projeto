package swing.action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.JTextField;

import swing.Servico;

import main.ClienteDAO;


@SuppressWarnings("serial")
public class JInserirPanelAction extends AbstractAction {
	private JPanel principal;
	private CardLayout cards;

	private JTextField nome;
	private JTextField endereco;
	private JTextField fone_1;
	private JTextField fone_2;
	private JTextField obs;

	public JInserirPanelAction(JPanel principal, CardLayout cards, JTextField nome, JTextField endereco, JTextField fone_1, JTextField fone_2 , JTextField obs) {
		super("Inserir");
		this.principal = principal;
		this.cards = cards;
		this.nome = nome;
		this.endereco = endereco;
		this.fone_1 = fone_1;
		this.fone_2 = fone_2;
		this.obs = obs;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ClienteDAO cliente = new ClienteDAO();
		String n;
		String end;
		String f1;
		String f2;
		String o;
		n =nome.getText();
		end =endereco.getText();
		f1 =fone_1.getText();
		f2 =fone_2.getText();
		o =obs.getText();
		
		cliente.inserir(n, end, f1, f2, o);
		
		if (principal != null) {
			cards.show(principal, Servico.PRINCIPAL);
		}

	}
}