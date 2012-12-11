package swing.action;

import java.awt.event.ActionEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class JAboutMenuAction extends AbstractAction {

	private JFrame frame;
	public JAboutMenuAction(JFrame frame) {
		super("Sobre");
		this.frame = frame;
		putValue(SHORT_DESCRIPTION, "Sobre a aplica��o.");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Mostrar tela com About...");
		JOptionPane.showMessageDialog(frame, "VTI INform�tica.\n 2012 Copiado descaradamente de/n Marco Mangan/n Por Thiago L.L.", "Sobre...", JOptionPane.INFORMATION_MESSAGE);		
	}
}