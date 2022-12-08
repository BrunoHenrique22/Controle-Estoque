package views;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import models.DAO;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class Relatorios extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorios dialog = new Relatorios();
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
	public Relatorios() {
		getContentPane().setBackground(Color.BLACK);
		setTitle("Relat\u00F3rios ");
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Relatorios.class.getResource("/img/Report.png")));
		setBounds(100, 100, 460, 309);
		getContentPane().setLayout(null);

		JButton btnReposicao = new JButton("");
		btnReposicao.setIcon(new ImageIcon(Relatorios.class.getResource("/img/exchange.png")));
		btnReposicao.setBackground(Color.BLACK);
		btnReposicao.setToolTipText("Reposi\u00E7\u00E3o ");
		btnReposicao.setBorder(null);
		btnReposicao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReposicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reposicaoEstoque();
			}
		});
		btnReposicao.setBounds(95, 11, 64, 64);
		getContentPane().add(btnReposicao);

		JButton btnProdutos = new JButton("");
		btnProdutos.setBorder(null);
		btnProdutos.setForeground(Color.BLACK);
		btnProdutos.setBackground(Color.BLACK);
		btnProdutos.setIcon(new ImageIcon(Relatorios.class.getResource("/img/Clients.png")));
		btnProdutos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProdutos.setToolTipText("Clientes");
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioClientes();
			}
		});
		btnProdutos.setBounds(95, 106, 64, 64);
		getContentPane().add(btnProdutos);

		JButton btnValores = new JButton("");
		btnValores.setBackground(Color.BLACK);
		btnValores.setIcon(new ImageIcon(Relatorios.class.getResource("/img/Valores.png")));
		btnValores.setToolTipText("Produtos e Seus Fornecedores");
		btnValores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnValores.setBorder(null);
		btnValores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutosFornecedores();
			}
		});
		btnValores.setBounds(95, 195, 64, 64);
		getContentPane().add(btnValores);

		JButton btnInventario = new JButton("");
		btnInventario.setBackground(Color.BLACK);
		btnInventario.setBorder(null);
		btnInventario.setIcon(new ImageIcon(Relatorios.class.getResource("/img/Invent\u00E1rio.png")));
		btnInventario.setToolTipText("Invent\u00E1rio");
		btnInventario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inventario();
			}
		});
		btnInventario.setBounds(296, 11, 64, 64);
		getContentPane().add(btnInventario);

		JButton btnVencidos = new JButton("");
		btnVencidos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVencidos.setBorder(null);
		btnVencidos.setBackground(Color.BLACK);
		btnVencidos.setIcon(new ImageIcon(Relatorios.class.getResource("/img/overdue.png")));
		btnVencidos.setToolTipText("Produtos Vencidos");
		btnVencidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosVencidos();
			}
		});
		btnVencidos.setBounds(296, 106, 64, 64);
		getContentPane().add(btnVencidos);

		JButton btnLucro = new JButton("");
		btnLucro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLucro.setBackground(Color.BLACK);
		btnLucro.setBorder(null);
		btnLucro.setIcon(new ImageIcon(Relatorios.class.getResource("/img/Vender.png")));
		btnLucro.setToolTipText("Pre\u00E7o De Venda");
		btnLucro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lucro();
			}
		});
		btnLucro.setBounds(296, 188, 74, 71);
		getContentPane().add(btnLucro);

	}// FIM DO CONSTRUTOR

	DAO dao = new DAO();

	private void relatorioClientes() {
		// criar objeto para construir a página pdf
		Document document = new Document();
		// gerar o documento pdf
		try {
			// cria um documento pdf em branco de nome clientes.pdf
			PdfWriter.getInstance(document, new FileOutputStream("clientes.pdf"));
			document.open();
			// gerar o conteúdo do documento
			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Clientes cadastrados"));
			document.add(new Paragraph(" "));
			// ... Demais conteúdos (imagem, tabela, gráfico, etc)
			PdfPTable tabela = new PdfPTable(4);
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Fone"));
			PdfPCell col3 = new PdfPCell(new Paragraph("CPF"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Email"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);

			// Acessar o banco de dados
			String relClientes = "select nome,fone,cpf,email from clientes";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relClientes);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
				}

			} catch (Exception e) {
				System.out.println(e);
			}
			// Adicionar a tabela ao documento pdf
			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);
		} finally { // executa o código independente do resultado OK ou não
			document.close();
		}

		// abrir o documento que foi gerado no leitor padrão de pdf do sistema (PC)
		try {
			Desktop.getDesktop().open(new File("clientes.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void Inventario() {
		// System.out.println("Teste");

		// criar objeto para construir a página pdf
		Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);
		// gerar o documento pdf
		try {
			// cria um documento pdf em branco de nome clientes.pdf
			PdfWriter.getInstance(document, new FileOutputStream("Inventario.pdf"));
			document.open();
			// gerar o conteúdo do documento
			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			// document.add() Serve pra adicionar coisas na linha do PDF.
			document.add(new Paragraph(new Paragraph(formatador.format(data)))); // é pra colocar a data no pdf.
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Valor Total dos Produtos/Inventário"));
			document.add(new Paragraph(" "));
			// ... Demais conteúdos (imagem, tabela, gráfico, etc)
			PdfPTable tabela = new PdfPTable(1); // esse 5 siginifica o número de colunas.

			// Cabeçalho da Tabela
			PdfPCell col1 = new PdfPCell(new Paragraph("Inventário"));

			tabela.addCell(col1);

			// Acessar o banco de dados
			String relReposicao = " select sum(estoque * custo) from produtos; ";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relReposicao);
				ResultSet rs = pst.executeQuery();

				// while é uma estrutura de repetição Infinita, ou seja enquanto tiver dados na
				// tabela do bnaod ele vai obter o valor.
				while (rs.next()) {
					tabela.addCell(rs.getString(1));

				}

			} catch (Exception e) {
				System.out.println(e);
			}
			// Adicionar a tabela ao documento pdf
			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);

		} finally { // executa o código independente do resultado OK ou não, que serve pra fechar o
					// documento
			document.close();
		}

		// abrir o documento que foi gerado no leitor padrão de pdf do sistema (PC)
		try {
			Desktop.getDesktop().open(new File("Inventario.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}

	}// FIM DO RELATORIO DE INVENTÁRIO.

	private void produtosVencidos() {
		// System.out.println("Teste");

		// criar objeto para construir a página pdf
		Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);
		// gerar o documento pdf
		try {
			// cria um documento pdf em branco de nome clientes.pdf
			PdfWriter.getInstance(document, new FileOutputStream("Vencidos.pdf"));
			document.open();
			// gerar o conteúdo do documento
			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			// document.add() Serve pra adicionar coisas na linha do PDF.
			document.add(new Paragraph(new Paragraph(formatador.format(data)))); // é pra colocar a data no pdf.
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Produtos com A Validade Vencida"));
			document.add(new Paragraph(" "));
			// ... Demais conteúdos (imagem, tabela, gráfico, etc)
			PdfPTable tabela = new PdfPTable(5); // esse 5 siginifica o número de colunas.

			// Cabeçalho da Tabela
			PdfPCell col1 = new PdfPCell(new Paragraph("Código"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Produto"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Localização"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Data De Entrada"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Vencido á"));

			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);

			// Acessar o banco de dados
			String relReposicao = "select codigo, produto, localizacao, date_format(dataval,'%d/%m/%y'), datediff(dataval,curdate()) from produtos where datediff(dataval,curdate()) < 0;";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relReposicao);
				ResultSet rs = pst.executeQuery();

				// while é uma estrutura de repetição Infinita, ou seja enquanto tiver dados na
				// tabela do bnaod ele vai obter o valor.
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					tabela.addCell(rs.getString(5));
				}

			} catch (Exception e) {
				System.out.println(e);
			}
			// Adicionar a tabela ao documento pdf
			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);

		} finally { // executa o código independente do resultado OK ou não, que serve pra fechar o
					// documento
			document.close();
		}

		// abrir o documento que foi gerado no leitor padrão de pdf do sistema (PC)
		try {
			Desktop.getDesktop().open(new File("Vencidos.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}

	}// FIM DO RELATORIO DE PRODUTOS VENCIDOS.

	private void ProdutosFornecedores() {
		// System.out.println("Teste");

		// criar objeto para construir a página pdf
		Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);
		// gerar o documento pdf
		try {
			// cria um documento pdf em branco de nome clientes.pdf
			PdfWriter.getInstance(document, new FileOutputStream("ProdutoeFornecedores.pdf"));
			document.open();
			// gerar o conteúdo do documento
			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			// document.add() Serve pra adicionar coisas na linha do PDF.
			document.add(new Paragraph(new Paragraph(formatador.format(data)))); // é pra colocar a data no pdf.
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Produtos e Seus Fornecedores"));
			document.add(new Paragraph(" "));
			// ... Demais conteúdos (imagem, tabela, gráfico, etc)
			PdfPTable tabela = new PdfPTable(3); // esse 5 siginifica o número de colunas.

			// Cabeçalho da Tabela
			PdfPCell col1 = new PdfPCell(new Paragraph("Código"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Produto"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Fornecedor"));

			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);

			// Acessar o banco de dados
			String relReposicao = " select produtos.codigo ,produtos.produto,fornecedores.fantasia from produtos inner join fornecedores on produtos.idFor = fornecedores.idFor;";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relReposicao);
				ResultSet rs = pst.executeQuery();

				// while é uma estrutura de repetição Infinita, ou seja enquanto tiver dados na
				// tabela do bnaod ele vai obter o valor.
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));

				}

			} catch (Exception e) {
				System.out.println(e);
			}
			// Adicionar a tabela ao documento pdf
			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);

		} finally { // executa o código independente do resultado OK ou não, que serve pra fechar o
					// documento
			document.close();
		}

		// abrir o documento que foi gerado no leitor padrão de pdf do sistema (PC)
		try {
			Desktop.getDesktop().open(new File("ProdutoeFornecedores.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}

	}// FIM DO RELATORIO DE ESTOQUE MINIMO.

	private void reposicaoEstoque() {
		// System.out.println("Teste");

		// criar objeto para construir a página pdf
		Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);
		// gerar o documento pdf
		try {
			// cria um documento pdf em branco de nome clientes.pdf
			PdfWriter.getInstance(document, new FileOutputStream("reposicao.pdf"));
			document.open();
			// gerar o conteúdo do documento
			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			// document.add() Serve pra adicionar coisas na linha do PDF.
			document.add(new Paragraph(new Paragraph(formatador.format(data)))); // é pra colocar a data no pdf.
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Reposição de estoque"));
			document.add(new Paragraph(" "));
			// ... Demais conteúdos (imagem, tabela, gráfico, etc)
			PdfPTable tabela = new PdfPTable(5); // esse 5 siginifica o número de colunas.

			// Cabeçalho da Tabela
			PdfPCell col1 = new PdfPCell(new Paragraph("Código"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Produto"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Validade"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Estoque"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Estoque mínimo"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);

			// Acessar o banco de dados
			String relReposicao = "select codigo,produto,date_format(dataval,'%d/%m/%Y'), estoque, estoquemin from produtos where estoque < estoquemin";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relReposicao);
				ResultSet rs = pst.executeQuery();

				// while é uma estrutura de repetição Infinita, ou seja enquanto tiver dados na
				// tabela do bnaod ele vai obter o valor.
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					tabela.addCell(rs.getString(5));
				}

			} catch (Exception e) {
				System.out.println(e);
			}
			// Adicionar a tabela ao documento pdf
			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);

		} finally { // executa o código independente do resultado OK ou não, que serve pra fechar o
					// documento
			document.close();
		}

		// abrir o documento que foi gerado no leitor padrão de pdf do sistema (PC)
		try {
			Desktop.getDesktop().open(new File("reposicao.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}

	}// FIM DO RELATORIO DE ESTOQUE MINIMO.

	private void Lucro() {
		// System.out.println("Teste");

		// criar objeto para construir a página pdf
		Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);
		// gerar o documento pdf
		try {
			// cria um documento pdf em branco de nome clientes.pdf
			PdfWriter.getInstance(document, new FileOutputStream("Valor De Venda.pdf"));
			document.open();
			// gerar o conteúdo do documento
			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			// document.add() Serve pra adicionar coisas na linha do PDF.
			document.add(new Paragraph(new Paragraph(formatador.format(data)))); // é pra colocar a data no pdf.
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Valor De Venda dos Produtos"));
			document.add(new Paragraph(" "));
			// ... Demais conteúdos (imagem, tabela, gráfico, etc)
			PdfPTable tabela = new PdfPTable(4); // esse 5 siginifica o número de colunas.

			// Cabeçalho da Tabela
			PdfPCell col1 = new PdfPCell(new Paragraph("Código"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Produto"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Custo"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Valor De Venda"));

			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);

			// Acessar o banco de dados
			String relReposicao = " select codigo, produto, custo,(custo + (custo * lucro)/100) as venda from produtos";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relReposicao);
				ResultSet rs = pst.executeQuery();

				// while é uma estrutura de repetição Infinita, ou seja enquanto tiver dados na
				// tabela do bnaod ele vai obter o valor.
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
				}

			} catch (Exception e) {
				System.out.println(e);
			}
			// Adicionar a tabela ao documento pdf
			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);

		} finally { // executa o código independente do resultado OK ou não, que serve pra fechar o
					// documento
			document.close();
		}

		// abrir o documento que foi gerado no leitor padrão de pdf do sistema (PC)
		try {
			Desktop.getDesktop().open(new File("Valor De Venda.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}

	}// FIM DO RELATORIO DE PRODUTOS VENCIDOS.

}// FIM DA VIDA
