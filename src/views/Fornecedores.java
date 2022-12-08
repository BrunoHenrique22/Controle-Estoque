package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;
import models.DAO;
import net.proteanit.sql.DbUtils;

public class Fornecedores extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFornecedores;
	private JTextField txtId;
	private JTextField txtIe;
	private JTextField txtCnpj;
	private JTextField txtRazao;
	private JTextField txtFantasia;
	private JTextField txtContato;
	private JTextField txtFone;
	private JTextField txtZap;
	private JTextField txtSite;
	private JTextField txtEmail;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCidade;
	JComboBox<?> cboUf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fornecedores frame = new Fornecedores();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Fornecedores() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
			}
		});
		setTitle("Fornecedores ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Fornecedores.class.getResource("/img/Fornecedor.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 618, 553);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLabel = new JLabel("Fornecedores: ");
		lblLabel.setForeground(Color.WHITE);
		lblLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLabel.setBounds(10, 11, 91, 14);
		contentPane.add(lblLabel);

		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Arial", Font.PLAIN, 12));
		lblId.setBounds(10, 139, 21, 20);
		contentPane.add(lblId);

		txtFornecedores = new JTextField();
		txtFornecedores.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisaAvançada();
			}
		});
		txtFornecedores.setBounds(96, 8, 246, 20);
		contentPane.add(txtFornecedores);
		txtFornecedores.setColumns(10);

		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(30, 139, 46, 20);
		contentPane.add(txtId);

		JButton btnBuscarid = new JButton("");
		btnBuscarid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarid();
			}
		});
		btnBuscarid.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/Search.png")));
		btnBuscarid.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscarid.setBorder(null);
		btnBuscarid.setBackground(Color.BLACK);
		btnBuscarid.setToolTipText("Busca");
		btnBuscarid.setBounds(86, 128, 38, 42);
		contentPane.add(btnBuscarid);

		JLabel lblIe = new JLabel("IE: ");
		lblIe.setForeground(Color.WHITE);
		lblIe.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIe.setBounds(145, 139, 21, 20);
		contentPane.add(lblIe);

		txtIe = new JTextField();
		txtIe.setColumns(10);
		txtIe.setBounds(165, 139, 149, 20);
		contentPane.add(txtIe);

		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setForeground(Color.WHITE);
		lblCnpj.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCnpj.setBounds(348, 139, 57, 20);
		contentPane.add(lblCnpj);

		txtCnpj = new JTextField();
		txtCnpj.setColumns(10);
		txtCnpj.setBounds(387, 139, 149, 20);
		contentPane.add(txtCnpj);

		JLabel lblRazoSocial = new JLabel("Raz\u00E3o Social: ");
		lblRazoSocial.setForeground(Color.WHITE);
		lblRazoSocial.setFont(new Font("Arial", Font.PLAIN, 12));
		lblRazoSocial.setBounds(10, 181, 78, 20);
		contentPane.add(lblRazoSocial);

		txtRazao = new JTextField();
		txtRazao.setColumns(10);
		txtRazao.setBounds(92, 181, 149, 20);
		contentPane.add(txtRazao);

		JLabel lblNomeFantasia = new JLabel("Nome Fantasia:");
		lblNomeFantasia.setForeground(Color.WHITE);
		lblNomeFantasia.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNomeFantasia.setBounds(251, 181, 91, 20);
		contentPane.add(lblNomeFantasia);

		txtFantasia = new JTextField();
		txtFantasia.setColumns(10);
		txtFantasia.setBounds(348, 181, 149, 20);
		contentPane.add(txtFantasia);

		JLabel lblNome = new JLabel("Nome Do Contato: ");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setBounds(10, 220, 108, 20);
		contentPane.add(lblNome);

		txtContato = new JTextField();
		txtContato.setColumns(10);
		txtContato.setBounds(114, 220, 149, 20);
		contentPane.add(txtContato);

		JLabel lblFone = new JLabel("Fone: ");
		lblFone.setForeground(Color.WHITE);
		lblFone.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFone.setBounds(273, 220, 35, 20);
		contentPane.add(lblFone);

		txtFone = new JTextField();
		txtFone.setColumns(10);
		txtFone.setBounds(312, 220, 108, 20);
		contentPane.add(txtFone);

		JLabel lblWhatsapp = new JLabel("Whatsapp:");
		lblWhatsapp.setForeground(Color.WHITE);
		lblWhatsapp.setFont(new Font("Arial", Font.PLAIN, 12));
		lblWhatsapp.setBounds(428, 220, 69, 20);
		contentPane.add(lblWhatsapp);

		txtZap = new JTextField();
		txtZap.setColumns(10);
		txtZap.setBounds(491, 220, 101, 20);
		contentPane.add(txtZap);

		JLabel lblSite = new JLabel("Site:");
		lblSite.setForeground(Color.WHITE);
		lblSite.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSite.setBounds(10, 260, 32, 20);
		contentPane.add(lblSite);

		txtSite = new JTextField();
		txtSite.setColumns(10);
		txtSite.setBounds(40, 260, 160, 20);
		contentPane.add(txtSite);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEmail.setBounds(210, 260, 46, 20);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(260, 260, 160, 20);
		contentPane.add(txtEmail);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setForeground(Color.WHITE);
		lblEndereo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEndereo.setBounds(184, 307, 57, 20);
		contentPane.add(lblEndereo);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setForeground(Color.WHITE);
		lblCep.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCep.setBounds(10, 307, 32, 20);
		contentPane.add(lblCep);

		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(40, 307, 78, 20);
		contentPane.add(txtCep);

		JButton btnBucarcep = new JButton("");
		btnBucarcep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtCep.getText().equals("")) {
					JOptionPane.showInternalMessageDialog(null, " Infome o CEP");
					txtCep.requestFocus();

				} else {

					buscarCep();

				}
			}
		});
		btnBucarcep.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBucarcep.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/Search.png")));
		btnBucarcep.setToolTipText("Busca");
		btnBucarcep.setBorder(null);
		btnBucarcep.setBackground(Color.BLACK);
		btnBucarcep.setBounds(128, 297, 38, 42);
		contentPane.add(btnBucarcep);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(245, 307, 160, 20);
		contentPane.add(txtEndereco);

		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setForeground(Color.WHITE);
		lblNmero.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNmero.setBounds(415, 310, 57, 20);
		contentPane.add(lblNmero);

		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(466, 307, 86, 20);
		contentPane.add(txtNumero);

		JLabel lblBairro = new JLabel("Complemento: ");
		lblBairro.setForeground(Color.WHITE);
		lblBairro.setFont(new Font("Arial", Font.PLAIN, 12));
		lblBairro.setBounds(10, 353, 91, 20);
		contentPane.add(lblBairro);

		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(96, 353, 135, 20);
		contentPane.add(txtComplemento);

		JLabel lblBairro_2 = new JLabel("Bairro:");
		lblBairro_2.setForeground(Color.WHITE);
		lblBairro_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblBairro_2.setBounds(240, 353, 38, 20);
		contentPane.add(lblBairro_2);

		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(285, 353, 78, 20);
		contentPane.add(txtBairro);

		JLabel lblBairro_2_1 = new JLabel("Cidade:");
		lblBairro_2_1.setForeground(Color.WHITE);
		lblBairro_2_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblBairro_2_1.setBounds(373, 353, 47, 20);
		contentPane.add(lblBairro_2_1);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(419, 353, 78, 20);
		contentPane.add(txtCidade);

		JLabel lblBairro_2_1_1 = new JLabel("UF:");
		lblBairro_2_1_1.setForeground(Color.WHITE);
		lblBairro_2_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblBairro_2_1_1.setBounds(505, 353, 21, 20);
		contentPane.add(lblBairro_2_1_1);

		cboUf = new JComboBox();
		cboUf.setModel(new DefaultComboBoxModel(
				new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cboUf.setBounds(536, 352, 56, 22);
		contentPane.add(cboUf);

		JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es ");
		lblObservaes.setForeground(Color.WHITE);
		lblObservaes.setFont(new Font("Arial", Font.PLAIN, 12));
		lblObservaes.setBounds(10, 405, 91, 20);
		contentPane.add(lblObservaes);

		btnUpdate1 = new JButton("");
		btnUpdate1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateFornecedores();
			}
		});
		btnUpdate1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate1.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/Update.png")));
		btnUpdate1.setToolTipText("Atualizar");
		btnUpdate1.setBorder(null);
		btnUpdate1.setBackground(Color.BLACK);
		btnUpdate1.setBounds(251, 447, 64, 64);
		contentPane.add(btnUpdate1);

		btnAdd1 = new JButton("");
		btnAdd1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					addForneceodores();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAdd1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd1.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/Add.png")));
		btnAdd1.setToolTipText("Adicionar Fornecedor");
		btnAdd1.setBorder(null);
		btnAdd1.setBackground(Color.BLACK);
		btnAdd1.setBounds(66, 447, 64, 64);
		contentPane.add(btnAdd1);

		btnExcluir1 = new JButton("");
		btnExcluir1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					excluirFornecedores();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnExcluir1.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/Delete.png")));
		btnExcluir1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir1.setToolTipText("Excluir Fornecedor");
		btnExcluir1.setBorder(null);
		btnExcluir1.setBackground(Color.BLACK);
		btnExcluir1.setBounds(491, 447, 64, 64);
		contentPane.add(btnExcluir1);

		// Fornecedores
		RestrictedTextField validar = new RestrictedTextField(txtFornecedores);
		validar.setLimit(50);

		// ID
		RestrictedTextField validar2 = new RestrictedTextField(txtId);
		validar2.setLimit(5);
		validar2.setOnlyNums(true);

		// IE
		RestrictedTextField validar3 = new RestrictedTextField(txtIe);
		validar3.setLimit(20);
		validar3.setOnlyNums(true);

		// CNPJ
		RestrictedTextField validar4 = new RestrictedTextField(txtCnpj);
		validar4.setLimit(20);
		validar4.setOnlyNums(true);

		// RazãoSocial
		RestrictedTextField validar5 = new RestrictedTextField(txtRazao);
		validar5.setLimit(50);
		validar5.setOnlyText(true);
		validar5.setAcceptSpace(true);

		// Nome Fantasia
		RestrictedTextField validar6 = new RestrictedTextField(txtFantasia);
		validar6.setLimit(50);
		validar6.setOnlyText(true);
		validar6.setAcceptSpace(true);

		// Nome Do Contato
		RestrictedTextField validar7 = new RestrictedTextField(txtContato);
		validar7.setLimit(50);
		validar7.setOnlyText(true);
		validar7.setAcceptSpace(true);

		// Fone
		RestrictedTextField validar8 = new RestrictedTextField(txtFone, "0123456789()-");
		validar8.setLimit(15);
		validar8.setOnlyNums(true);

		// Zap
		RestrictedTextField validar9 = new RestrictedTextField(txtZap, "0123456789()-");
		validar9.setLimit(15);
		validar9.setOnlyNums(true);

		// Site
		RestrictedTextField validar10 = new RestrictedTextField(txtSite);
		validar10.setLimit(50);

		// Email
		RestrictedTextField validar11 = new RestrictedTextField(txtEmail);
		validar11.setLimit(50);

		// CEP
		RestrictedTextField validar12 = new RestrictedTextField(txtCep);
		validar12.setOnlyNums(true);
		validar12.setLimit(10);

		// Endereço
		RestrictedTextField validar13 = new RestrictedTextField(txtEndereco);
		validar13.setLimit(50);

		// Numero
		RestrictedTextField validar14 = new RestrictedTextField(txtNumero, "0123456789()-");
		validar14.setLimit(15);
		validar14.setOnlyNums(true);

		// Complemento
		RestrictedTextField validar15 = new RestrictedTextField(txtComplemento);
		validar15.setLimit(50);

		// Bairro
		RestrictedTextField validar16 = new RestrictedTextField(txtBairro);
		validar16.setLimit(50);
		validar16.setOnlyText(true);
		validar16.setAcceptSpace(true);

		// Cidade
		RestrictedTextField validar17 = new RestrictedTextField(txtCidade);

		txtObs2 = new JTextField();
		txtObs2.setBounds(96, 405, 347, 20);
		contentPane.add(txtObs2);
		txtObs2.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 44, 582, 73);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		validar17.setLimit(50);
		validar17.setOnlyText(true);
		validar17.setAcceptSpace(true);

		getRootPane().setDefaultButton(btnBuscarid);

	}// FIM DO CONSTRUTOR

	DAO dao = new DAO(); // crtl + shift + O
	private JTextField txtObs2;
	private JTable table;
	private JButton btnAdd1;
	private JButton btnUpdate1;
	private JButton btnExcluir1;

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
		if (txtId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite A ID");
			txtId.requestFocus();
		} else {

			String read = "select * from fornecedores where idFor = ?";
			try {

				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(read);

				pst.setString(1, txtId.getText());

				ResultSet rs = pst.executeQuery();

				if (rs.next()) {
					txtId.setText(rs.getString(1));
					txtRazao.setText(rs.getString(2));
					txtFantasia.setText(rs.getString(3));
					txtCnpj.setText(rs.getString(4));
					txtIe.setText(rs.getString(5));
					txtCep.setText(rs.getString(6));
					txtEndereco.setText(rs.getString(7));
					txtNumero.setText(rs.getString(8));
					txtComplemento.setText(rs.getString(9));
					txtBairro.setText(rs.getString(10));
					txtCidade.setText(rs.getString(11));
					cboUf.setSelectedItem(rs.getString(12));
					txtContato.setText(rs.getString(13));
					txtFone.setText(rs.getString(14));
					txtZap.setText(rs.getString(15));
					txtEmail.setText(rs.getString(16));
					txtSite.setText(rs.getString(17));
					txtObs2.setText(rs.getString(18));

					btnAdd1.setEnabled(false);
					btnUpdate1.setEnabled(true);
					btnExcluir1.setEnabled(true);

				} else {
					JOptionPane.showMessageDialog(null, "Fornecedor inexistente");
					txtFornecedores.requestFocus();
					limpar();

				}

				con.close();
			} catch (Exception e) {
				System.out.println(e);

			}
		}

	}// FIM DA BUSCA DO USUARIO

	// PESQUISA AVANÇADA DE FORNECEDORES USANDO AS LETRAS INICIAIS DO NOME FANTASIA

	private void pesquisaAvançada() {
		String read2 = "select idFor as ID, fantasia as Fornecedor, fone, nomeContato as contato from fornecedores where fantasia like ?";

		try {
			Connection con = dao.conectar();

			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, txtFornecedores.getText() + "%"); // ATENÇÃO TEM Q SER DESSE MODO "%"
			ResultSet rs = pst.executeQuery();

			// uso da Biblioteca rx2xml para encher a tabela
			table.setModel(DbUtils.resultSetToTableModel(rs)); /// so da pra usar isso dai se estiver a biblioteca lá

			con.close();
		} catch (Exception e) {
			System.out.println(e);

		}

	}// FIM DA Pesquisa avançada

	void addForneceodores() throws SQLException {

		if (txtRazao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha A Razão Social");
			txtRazao.requestFocus();

		} else if (txtIe.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Campo IE");
			txtIe.requestFocus();

		} else if (txtCnpj.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o CNPJ");
			txtCnpj.requestFocus();

		} else if (txtFantasia.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha O Nome Fantasia");
			txtFantasia.requestFocus();

		} else if (txtCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha O CEP");
			txtCep.requestFocus();

		} else if (txtEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha O Endereço");
			txtEndereco.requestFocus();

		} else if (txtNumero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha O Número");
			txtNumero.requestFocus();

		} else if (txtBairro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha O Bairro");
			txtBairro.requestFocus();

		} else if (txtCidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha A Cidade");
			txtCidade.requestFocus();

		} else if (txtNumero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha A UF");
			txtNumero.requestFocus();

		} else if (txtContato.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha O Nome para Contato");
			txtContato.requestFocus();

		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha Um Telefone para Contato");
			txtFone.requestFocus();

		} else if (cboUf.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha A  UF");
			cboUf.requestFocus();

		} else {

			// System.out.println("Teste Confirmar");
			String create = "insert into fornecedores (razãoSocial,fantasia,cnpj,ie,cep,endereco,numero,complemento,bairro,cidade,uf,nomecontato,fone,whatsapp,email,site,obs) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {

				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(create);
				pst.setString(1, txtRazao.getText());
				pst.setString(2, txtFantasia.getText());
				pst.setString(3, txtCnpj.getText());
				pst.setString(4, txtIe.getText());
				pst.setString(5, txtCep.getText());
				pst.setString(6, txtEndereco.getText());
				pst.setString(7, txtNumero.getText());
				pst.setString(8, txtComplemento.getText());
				pst.setString(9, txtBairro.getText());
				pst.setString(10, txtCidade.getText());
				pst.setString(11, cboUf.getSelectedItem().toString());
				pst.setString(12, txtContato.getText());
				pst.setString(13, txtFone.getText());
				pst.setString(14, txtZap.getText());
				pst.setString(15, txtEmail.getText());
				pst.setString(16, txtSite.getText());
				pst.setString(17, txtObs2.getText());

				int confirma1 = pst.executeUpdate();
				// System.out.println("confrima");
				if (confirma1 == 1) {
					JOptionPane.showMessageDialog(null, "Fornecedor Adicionado");
					btnUpdate1.setEnabled(true);
					btnExcluir1.setEnabled(true);
					limpar();

				} else {
					JOptionPane.showMessageDialog(null, "ATENÇÃO FORNECEDOR NÃO ADICIONADO");

				}

				con.close();
			} catch (java.sql.SQLIntegrityConstraintViolationException e1) { // personalizar os erros do java
				JOptionPane.showMessageDialog(null, "Esse Fornecedor já existe!!");
				txtCnpj.setText(null);
				txtCnpj.requestFocus();

			}
		}
	}// FIM DO ADICIONAR

	private void updateFornecedores() {
		// System.out.println("teste ");

		// validação de CAMPOS OBRIGATÓRIOS
		if (txtId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite A ID");
			txtId.requestFocus();

		} else if (txtRazao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha A Razão Social");
			txtRazao.requestFocus();

		} else if (txtFantasia.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha O Nome Fantasia");
			txtFantasia.requestFocus();

		} else if (txtIe.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Campo Ie");
			txtIe.requestFocus();

		} else if (txtCnpj.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o CNPJ");
			txtCnpj.requestFocus();

		} else if (txtCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha O CEP");
			txtCep.requestFocus();

		} else if (txtEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha O Endereço");
			txtEndereco.requestFocus();

		} else if (txtNumero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha O Número");
			txtNumero.requestFocus();

		} else if (txtBairro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha O Bairro");
			txtBairro.requestFocus();

		} else if (txtCidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha A Cidade");
			txtCidade.requestFocus();

		} else if (txtNumero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha A UF");
			txtNumero.requestFocus();

		} else if (txtContato.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha O Nome para Contato");
			txtContato.requestFocus();

		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha Um Telefone para Contato");
			txtFone.requestFocus();

		} else if (txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha Um Email");
			txtEmail.requestFocus();

		} else if (txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha Um Email");
			txtEmail.requestFocus();

		} else if (cboUf.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha A  UF");
			cboUf.requestFocus();

		} else {

			// LOGICA PRINCIPAL
			String update = "update fornecedores set razãoSocial = ? ,fantasia  = ?,cnpj  = ?,ie = ?,cep = ?,endereco = ?,numero = ?,complemento = ?,bairro = ?,cidade = ?,uf = ?,nomecontato = ?,fone = ?,whatsapp = ?,email = ?,site = ?,obs = ? where idFor = ?";
			try {

				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, txtRazao.getText());
				pst.setString(2, txtFantasia.getText());
				pst.setString(3, txtCnpj.getText());
				pst.setString(4, txtIe.getText());
				pst.setString(5, txtCep.getText());
				pst.setString(6, txtEndereco.getText());
				pst.setString(7, txtNumero.getText());
				pst.setString(8, txtComplemento.getText());
				pst.setString(9, txtBairro.getText());
				pst.setString(10, txtCidade.getText());
				pst.setString(11, cboUf.getSelectedItem().toString());
				pst.setString(12, txtContato.getText());
				pst.setString(13, txtFone.getText());
				pst.setString(14, txtZap.getText());
				pst.setString(15, txtEmail.getText());
				pst.setString(16, txtSite.getText());
				pst.setString(17, txtObs2.getText());
				pst.setString(18, txtId.getText());

				int confirma = pst.executeUpdate();
				// System.out.println("confrima");
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Fornecedor Atualizado");
					limpar();
				}

				con.close();
			} catch (java.sql.SQLIntegrityConstraintViolationException e1) { // personalizar os erros do java
				JOptionPane.showMessageDialog(null, "Esse Fornecedor já existe!!");
				txtCnpj.setText(null);
				txtCnpj.requestFocus();

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}// FIM DO UPDATE

	private void excluirFornecedores() throws SQLException {

		int confirma = JOptionPane.showConfirmDialog(null, "Deseja Excluir Esse Fornecedor??", "Exluir Fornecedor!!",
				JOptionPane.YES_NO_OPTION);

		if (confirma == JOptionPane.YES_NO_OPTION) {

			String delete = "delete from fornecedores where idFor = ?";

			try {

				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, txtId.getText());

				int confirmaExcluir = pst.executeUpdate();

				if (confirmaExcluir == 1) {
					JOptionPane.showMessageDialog(null, "Fornecedor Excluido Com Sucesso");
					limpar();

				}

				con.close();

			} catch (java.sql.SQLIntegrityConstraintViolationException e1) { // personalizar os erros do java
				JOptionPane.showMessageDialog(null,
						"Esse Fornecedor não pode ser deletado. \n Pois ainda existe um Produto Cadastrado!!");

				txtCnpj.setText(null);
				txtCnpj.requestFocus();

			}

		}

	}// FIM DO EXCLUIR

	private void buscarCep() {
		String logradouro = "";
		String tipoLogradouro = "";
		String cep = txtCep.getText();
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
			SAXReader xml = new SAXReader();
			Document documento = xml.read(url);
			Element root = documento.getRootElement();
			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				if (element.getQualifiedName().equals("cidade")) {
					txtCidade.setText(element.getText());
				}
				if (element.getQualifiedName().equals("bairro")) {
					txtBairro.setText(element.getText());
				}
				if (element.getQualifiedName().equals("uf")) {
					cboUf.setSelectedItem(element.getText());
				}
				if (element.getQualifiedName().equals("tipo_logradouro")) {
					tipoLogradouro = element.getText();
				}
				if (element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}

			}

			txtEndereco.setText(tipoLogradouro + " " + logradouro);

		} catch (

		Exception e) {
			System.out.println(e);
		}

	}

	private void limpar() {
		txtId.setText(null);
		txtId.requestFocus();
		txtFornecedores.setText(null);
		txtIe.setText(null);
		txtRazao.setText(null);
		txtFantasia.setText(null);
		txtContato.setText(null);
		txtFone.setText(null);
		txtZap.setText(null);
		txtSite.setText(null);
		txtCep.setText(null);
		txtEndereco.setText(null);
		txtNumero.setText(null);
		txtComplemento.setText(null);
		txtBairro.setText(null);
		txtCidade.setText(null);
		txtEmail.setText(null);
		txtCnpj.setText(null);
		txtObs2.getText();
		btnAdd1.setEnabled(true);
		btnUpdate1.setEnabled(false);
		btnExcluir1.setEnabled(false);
		cboUf.setSelectedItem("");
		cboUf.requestFocus();

		// limpar a tabela
		((DefaultTableModel) table.getModel()).setRowCount(0);

	}
}
// FIM DA VIDA
