package views;

 import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;

public class Sobre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel Sobre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre frame = new Sobre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Sobre() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/About.png")));
		setTitle("Sobre");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Sobre = new JPanel();
		Sobre.setBackground(Color.WHITE);
		Sobre.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Sobre);
		Sobre.setLayout(null);

		JEditorPane dtrpnOlMeuNome = new JEditorPane();
		dtrpnOlMeuNome.setEditable(false);
		dtrpnOlMeuNome.setText(
				"Ol\u00E1 meu nome \u00E9 Bruno Henrique Silva,e estou atualmente estudando Tecnologia da Informa\u00E7\u00E3o e trabalhando na \u00E1rea como estagi\u00E1rio. Este projeto \u00E9 uma demonstra\u00E7\u00E3o das minhas compet\u00EAncias que foram aprendidas durante o curso.");
		dtrpnOlMeuNome.setBounds(10, 11, 307, 239);
		Sobre.add(dtrpnOlMeuNome);

		JLabel lblNewLabel = new JLabel("Vers\u00E3o 22.0");
		lblNewLabel.setBounds(350, 90, 84, 14);
		Sobre.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Sobre.class.getResource("/img/MIT.png")));
		lblNewLabel_1.setBounds(358, 23, 66, 56);
		Sobre.add(lblNewLabel_1);

	}

}
