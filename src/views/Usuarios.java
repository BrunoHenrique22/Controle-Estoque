package views;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;

import Atxy2k.CustomTextField.RestrictedTextField;
import models.DAO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class Usuarios extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtId;
	private JTextField txtLogin;
	private JTextField txtUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuarios dialog = new Usuarios();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Usuarios() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
			}
		});
		getContentPane().setBackground(Color.BLACK);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Usuarios.class.getResource("/img/Users2.png")));
		setResizable(false);
		setTitle("Usu\u00E1rios ");
		setBounds(100, 100, 564, 422);
		getContentPane().setLayout(null);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(442, 114, 86, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);

		JLabel lblNewLabel = new JLabel("Usu\u00E1rio:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(24, 116, 64, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 15));
		lblLogin.setBounds(24, 29, 64, 20);
		getContentPane().add(lblLogin);

		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		txtLogin.setBounds(98, 30, 191, 20);
		getContentPane().add(txtLogin);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSenha.setBounds(24, 195, 64, 20);
		getContentPane().add(lblSenha);

		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Arial", Font.PLAIN, 15));
		lblId.setBounds(407, 116, 64, 14);
		getContentPane().add(lblId);

		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(98, 114, 191, 20);
		getContentPane().add(txtUsuario);

		btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarid();
			}
		});
		btnBuscar.setToolTipText("Procurar");
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setBorder(null);
		btnBuscar.setBackground(Color.BLACK);
		btnBuscar.setIcon(new ImageIcon(Usuarios.class.getResource("/img/Search.png")));
		btnBuscar.setBounds(299, 11, 48, 48);
		getContentPane().add(btnBuscar);

		btnAdd = new JButton("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addUsuario();
			}
		});
		btnAdd.setIcon(new ImageIcon(Usuarios.class.getResource("/img/Add.png")));
		btnAdd.setToolTipText("Adicionar");
		btnAdd.setBorder(null);
		btnAdd.setBackground(Color.BLACK);
		btnAdd.setBounds(57, 297, 64, 64);
		getContentPane().add(btnAdd);

		btnUpdate = new JButton("");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// verificar se o checkbox
				// para verificar se não está selecionado use NOT (!)
				if (chckSenha.isSelected()) {
					updateUsuarioSenha(); // No primeiro caso seguindo a logica caso o checkbox esteja marcado ele vai
											// qurer trocar a senha então o metodo tem que vir primeiro, caso não queria
											// ele só faz a taualização normal do úsuario.

				} else {
					updateUsuario();

				}
			}
		});
		btnUpdate.setIcon(new ImageIcon(Usuarios.class.getResource("/img/Update.png")));
		btnUpdate.setToolTipText("Atualizar Cadastro");
		btnUpdate.setBorder(null);
		btnUpdate.setBackground(Color.BLACK);
		btnUpdate.setBounds(225, 297, 64, 64);
		getContentPane().add(btnUpdate);

		btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirUsuario();
			}
		});
		btnExcluir.setIcon(new ImageIcon(Usuarios.class.getResource("/img/Delete.png")));
		btnExcluir.setToolTipText("Atualizar Cadastro");
		btnExcluir.setBorder(null);
		btnExcluir.setBackground(Color.BLACK);
		btnExcluir.setBounds(407, 297, 64, 64);
		getContentPane().add(btnExcluir);

		// Uso da Biblioteca
		RestrictedTextField validar = new RestrictedTextField(txtUsuario);
		validar.setLimit(50);
		validar.setOnlyText(true);
		validar.setAcceptSpace(true);

		RestrictedTextField validar2 = new RestrictedTextField(txtLogin);
		validar2.setLimit(20);

		// Uso da tecla <Enter> junto a um botão (so da pra fazer com um botão)
		getRootPane().setDefaultButton(btnBuscar);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(98, 196, 191, 20);
		getContentPane().add(txtPassword);

		JLabel lblPerfil = new JLabel("Perfil:");
		lblPerfil.setForeground(Color.WHITE);
		lblPerfil.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPerfil.setBounds(389, 29, 64, 20);
		getContentPane().add(lblPerfil);

		cboPerfil = new JComboBox<Object>();
		cboPerfil.setModel(new DefaultComboBoxModel<Object>(new String[] { "", "admin", "user" }));
		cboPerfil.setBounds(442, 29, 80, 22);
		getContentPane().add(cboPerfil);

		chckSenha = new JCheckBox("Alterar Senha");
		chckSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// fazer o check na cixar Jchechbx, usando botão direito
				txtPassword.setEditable(true);
				txtPassword.setText(null);
				txtPassword.requestFocus();
				txtPassword.setBackground(Color.white);
			}
		});
		chckSenha.setVisible(false);
		chckSenha.setBounds(98, 241, 113, 23);
		getContentPane().add(chckSenha);

	} // fim do constutor

	DAO dao = new DAO();

	private JButton btnUpdate;
	private JButton btnExcluir;
	private JButton btnAdd;
	private JButton btnBuscar;
	private JPasswordField txtPassword;
	private JComboBox<Object> cboPerfil;
	private JCheckBox chckSenha;

	private void status() {

		try {
			Connection con = dao.conectar();
			if (con == null) {

			} else {

			}

			con.close();
		} catch (Exception e) {
			System.out.println(e);

		}

	}// FIM DO STATUS

	private void pesquisarid() {

		// VALIDAÇÃO
		if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite O Login");
			txtLogin.requestFocus();
		} else {

			String read = "select * from usuarios where login = ?";
			try {

				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(read);

				pst.setString(1, txtLogin.getText());

				ResultSet rs = pst.executeQuery();

				if (rs.next()) {
					txtUsuario.setText(rs.getString(2));
					txtId.setText(rs.getString(1));
					txtPassword.setText(rs.getString(4));
					cboPerfil.setSelectedItem(rs.getString(5));
					// exibir a caixa Checkbox
					chckSenha.setVisible(true);

					// desativar table
					txtPassword.setEditable(false);

					btnUpdate.setEnabled(false);
					btnExcluir.setEnabled(false);
					btnAdd.setEnabled(false);

				} else {
					JOptionPane.showMessageDialog(null, "Usuário inexistente");
					txtUsuario.setText(null);
					txtLogin.setText(null);
					txtPassword.requestFocus();

					btnAdd.setEnabled(true);
					btnBuscar.setEnabled(false);

				}

				con.close();
			} catch (Exception e) {
				System.out.println(e);

			}
		}

	}// FIM DA BUSCA DO USUARIO

	void addUsuario() {

		// validação de CAMPOS OBRIGATÓRIOS
		if (txtUsuario.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha O Usuário");
			txtUsuario.requestFocus();
		} else if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha O Login");
			txtLogin.requestFocus();

		} else {

			// System.out.println("Teste Confirmar");
			String create = "insert into usuarios (usuario,login,senha,perfil) values (?,?,md5(?),?)";
			try {

				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(create);
				pst.setString(1, txtUsuario.getText());
				pst.setString(2, txtLogin.getText());
				// Captura segura da senha
				String capturaSenha = new String(txtPassword.getPassword());
				pst.setString(3, capturaSenha);
				pst.setString(4, cboPerfil.getSelectedItem().toString());

				int confirma1 = pst.executeUpdate(); // pra adicionar ou mudar é sempre o UPDATE
				// System.out.println("confrima");
				if (confirma1 == 1) {
					JOptionPane.showMessageDialog(null, "Usuário Adicionado");
					limpar();

				} else {
					JOptionPane.showMessageDialog(null, "ATENÇÃO  USUÁRIO NÃO ADICIONADO");

				}

				con.close();
			} catch (java.sql.SQLIntegrityConstraintViolationException e1) { // personalizar os erros do java
				JOptionPane.showMessageDialog(null, "Esse login já existe!!");
				txtLogin.setText(null);
				txtLogin.requestFocus();

			} catch (Exception e2) {
				System.out.println(e2);

			}
		}
	}// FIM DO ADICIONAR

	private void updateUsuario() {
		// System.out.println("teste ");

		// validação de CAMPOS OBRIGATÓRIOS
		if (txtUsuario.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha O Usuário");
			txtUsuario.requestFocus();
		} else if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha O Login");
			txtLogin.requestFocus();

		} else {

		}

		// LOGICA PRINCIPAL
		String update = "update usuarios set usuario = ?, login = ?, perfil = ? where id= ?";
		try {

			Connection con = dao.conectar();

			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, txtUsuario.getText());
			pst.setString(2, txtLogin.getText());
			pst.setString(3, cboPerfil.getSelectedItem().toString());
			pst.setString(4, txtId.getText());

			int confirma = pst.executeUpdate();
			// System.out.println("confrima");
			if (confirma == 1) {
				JOptionPane.showMessageDialog(null, "Usuário Atualizado");
				limpar();
			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}// FIM DO UPDATE

	private void updateUsuarioSenha() {
		// System.out.println("teste ");

		// validação de CAMPOS OBRIGATÓRIOS
		if (txtUsuario.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha O Usuário");
			txtUsuario.requestFocus();
		} else if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha O Login");
			txtLogin.requestFocus();

		} else {

		}

		// LOGICA PRINCIPAL
		String update = "update usuarios set usuario = ?, login = ?, senha = md5(?), perfil = ? where id= ?";
		try {

			Connection con = dao.conectar();

			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, txtUsuario.getText());
			pst.setString(2, txtLogin.getText());

			// capturarsenha
			String capturarSenha = new String(txtPassword.getPassword());
			pst.setString(3, capturarSenha);
			pst.setString(4, cboPerfil.getSelectedItem().toString());
			pst.setString(5, txtId.getText());

			int confirma = pst.executeUpdate();
			// System.out.println("confrima");
			if (confirma == 1) {
				JOptionPane.showMessageDialog(null, "Usuário Atualizado");
				limpar();
			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}// FIM DO UPDATESENHA

	// METODO PARA EXCLUIR CONTATO
	private void excluirUsuario() {
		// System.out.println("Teste");

		int confirma = JOptionPane.showConfirmDialog(null, "Deseja Excluir Esse Usuário?", "Exluir Contato!!",
				JOptionPane.YES_NO_OPTION);

		if (confirma == JOptionPane.YES_NO_OPTION) {

			String delete = "delete from usuarios where id = ?";

			try {

				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, txtId.getText());

				int confirmaExcluir = pst.executeUpdate();

				if (confirmaExcluir == 1) {
					JOptionPane.showMessageDialog(null, "Usuário Excluido");
					limpar();

				}

				con.close();

			} catch (Exception e) {
				System.out.println(e);

			}

		}

	}// FIM DO EXCLUIR

	// Limpar Campos e resetar os botões
	private void limpar() {
		txtId.setText(null);
		txtUsuario.setText(null);
		txtLogin.setText(null);
		txtPassword.setText(null);
		txtId.requestFocus();
		txtUsuario.requestFocus();
		cboPerfil.setSelectedItem("");
		btnBuscar.setEnabled(false);
		btnAdd.setEnabled(true);
		btnUpdate.setEnabled(false);
		btnExcluir.setEnabled(false);
		txtPassword.setBackground(null);
		chckSenha.setSelected(false); // desmarcar a caixa check
		chckSenha.setVisible(false);
		txtPassword.setEditable(true);

	}
}
