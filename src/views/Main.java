package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.DAO;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JLabel;
import java.awt.Cursor;
import java.awt.Font;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	// os objetos abaixo serão manipulados pela classe Login

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				Date data = new Date();
				DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
				lblTempo.setText(formatador.format(data));
			}
		});
		setTitle("Controle De Estoque ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 462);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnUsuarios = new JButton("");
		btnUsuarios.setEnabled(false);
		btnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuarios.setBorder(null);
		btnUsuarios.setBackground(Color.BLACK);
		btnUsuarios.setIcon(new ImageIcon(Main.class.getResource("/img/Users2.png")));
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuarios usuarios = new Usuarios();
				usuarios.setVisible(true);
			}
		});
		btnUsuarios.setToolTipText("Usuarios ");
		btnUsuarios.setBounds(30, 26, 106, 103);
		contentPane.add(btnUsuarios);

		JButton btnFornecedores = new JButton("");
		btnFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fornecedores fornecedores = new Fornecedores();
				fornecedores.setVisible(true);
			}
		});
		btnFornecedores.setIcon(new ImageIcon(Main.class.getResource("/img/Fornecedor.png")));
		btnFornecedores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFornecedores.setToolTipText("Fornecedores");
		btnFornecedores.setBorder(null);
		btnFornecedores.setBackground(Color.BLACK);
		btnFornecedores.setBounds(258, 26, 89, 81);
		contentPane.add(btnFornecedores);

		JButton btnProdutos = new JButton("");
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produtos produtos = new Produtos();
				produtos.setVisible(true);
			}
		});
		btnProdutos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProdutos.setIcon(new ImageIcon(Main.class.getResource("/img/produtos.png")));
		btnProdutos.setToolTipText("Produtos");
		btnProdutos.setBorder(null);
		btnProdutos.setBackground(Color.BLACK);
		btnProdutos.setBounds(466, 26, 115, 117);
		contentPane.add(btnProdutos);

		JButton btnClientes = new JButton("");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes clientes = new Clientes();
				clientes.setVisible(true);
			}
		});
		btnClientes.setIcon(new ImageIcon(Main.class.getResource("/img/Clients.png")));
		btnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClientes.setToolTipText("Clientes");
		btnClientes.setBorder(null);
		btnClientes.setBackground(Color.BLACK);
		btnClientes.setBounds(49, 188, 99, 103);
		contentPane.add(btnClientes);

		btnRelatorios = new JButton("");
		btnRelatorios.setEnabled(false);
		btnRelatorios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorios relatorios = new Relatorios();
				relatorios.setVisible(true);

			}
		});
		btnRelatorios.setIcon(new ImageIcon(Main.class.getResource("/img/Report.png")));
		btnRelatorios.setToolTipText("Relatorios");
		btnRelatorios.setBorder(null);
		btnRelatorios.setBackground(Color.BLACK);
		btnRelatorios.setBounds(248, 188, 99, 103);
		contentPane.add(btnRelatorios);

		JButton btnSobre = new JButton("");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setIcon(new ImageIcon(Main.class.getResource("/img/About.png")));
		btnSobre.setToolTipText("Sobre");
		btnSobre.setBorder(null);
		btnSobre.setBackground(Color.BLACK);
		btnSobre.setBounds(466, 188, 99, 103);
		contentPane.add(btnSobre);

		panelUsuario = new JPanel();
		panelUsuario.setBackground(Color.GRAY);
		panelUsuario.setBounds(0, 360, 610, 63);
		contentPane.add(panelUsuario);
		panelUsuario.setLayout(null);

		lblTempo = new JLabel("");
		lblTempo.setForeground(Color.WHITE);
		lblTempo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTempo.setBounds(253, 11, 347, 41);
		panelUsuario.add(lblTempo);

		JLabel lblNewLabel = new JLabel("Usu\u00E1rio: ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 25, 71, 27);
		panelUsuario.add(lblNewLabel);

		lblUsuario = new JLabel("");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
		lblUsuario.setBounds(91, 25, 151, 27);
		panelUsuario.add(lblUsuario);

	}// fim do construtor

	DAO dao = new DAO();

	// os objetos abaixo serão manipulados pela classe Login
	private JLabel lblTempo;
	JButton btnUsuarios;
	JButton btnRelatorios;
	JPanel panelUsuario;
	JLabel lblUsuario;
}// FIM
