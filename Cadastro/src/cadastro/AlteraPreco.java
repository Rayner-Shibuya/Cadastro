package cadastro;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AlteraPreco extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtPrecoNovo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlteraPreco frame = new AlteraPreco();
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
	public AlteraPreco() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigoDoProduto = new JLabel("Codigo do produto");
		lblCodigoDoProduto.setBounds(21, 36, 102, 14);
		contentPane.add(lblCodigoDoProduto);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(133, 33, 260, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setBounds(33, 85, 46, 14);
		contentPane.add(lblProduto);
		
		JLabel lblNome = new JLabel("nome");
		lblNome.setBounds(99, 85, 228, 14);
		contentPane.add(lblNome);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o");
		lblPreco.setBounds(33, 125, 46, 14);
		contentPane.add(lblPreco);
		
		JLabel lblPrecoVelho = new JLabel("preco");
		lblPrecoVelho.setBounds(99, 125, 68, 14);
		contentPane.add(lblPrecoVelho);
		
		txtPrecoNovo = new JTextField();
		txtPrecoNovo.setBounds(99, 167, 75, 20);
		contentPane.add(txtPrecoNovo);
		txtPrecoNovo.setColumns(10);
		
		JLabel lblNovoPreo = new JLabel("Novo Pre\u00E7o");
		lblNovoPreo.setBounds(21, 170, 68, 14);
		contentPane.add(lblNovoPreo);
		
		JButton btnConfirma = new JButton("Confirma");
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn = Conexao.getConnection();
				
				try {
					
					conn.setAutoCommit(false);
					Mercadoria mercadoria = new Mercadoria();
										
					mercadoria.setCodigo(txtCodigo.getText());
										
					Statement myStmt = conn.createStatement();
					
					ResultSet checar = myStmt.executeQuery ("SELECT * FROM mercadoria WHERE codigo = '" + txtCodigo.getText() + "'");
					
					if (checar.next()) {
						mercadoria.setPreco(Double.parseDouble(txtPrecoNovo.getText()));
						mercadoria.atualizar(conn);
						conn.commit();
						JOptionPane.showMessageDialog(null, "Preço atualizado");

							
					}
					else {
						
						JOptionPane.showMessageDialog(null, "O cadastro não existe");
					}
			        

			      } 
			      catch(SQLException erro){
			    	  JOptionPane.showMessageDialog(null, erro + "erro1");
			         if(conn != null){
			            try{
			               conn.rollback();
			            } 
			            catch(SQLException e1){
			            	JOptionPane.showMessageDialog(null, e1 + "erro2");
			            }
			         }
			      } 
			      finally{
			         if(conn != null){
			            try{
			               conn.close();
			            } 
			            catch(SQLException e1){
			            	JOptionPane.showMessageDialog(null, e1 + "erro3");
			            }
			         }      
			      }
			}
		});
		btnConfirma.setBounds(317, 209, 89, 23);
		contentPane.add(btnConfirma);
	}
}
