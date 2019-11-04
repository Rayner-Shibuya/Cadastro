package cadastro;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtDesc;
	private JTextField txtUni;
	private JLabel lblValor;
	private JTextField txtValor;
	private JLabel lblDataAtualizao;
	private JTextField txtData;
	private JLabel lblAtivo;
	private JTextField txtAtivo;
	Connection conn = Conexao.getConnection();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Cadastro de produtos");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Cadastro() {
		
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(22, 30, 46, 14);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(123, 27, 227, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblDesc = new JLabel("Descri\u00E7\u00E3o");
		lblDesc.setBounds(22, 61, 71, 14);
		contentPane.add(lblDesc);
		
		txtDesc = new JTextField();
		txtDesc.setBounds(123, 58, 227, 20);
		contentPane.add(txtDesc);
		txtDesc.setColumns(10);
		
		JLabel lblUnidades = new JLabel("Unidade(s)");
		lblUnidades.setBounds(22, 92, 71, 14);
		contentPane.add(lblUnidades);
		
		txtUni = new JTextField();
		txtUni.setBounds(123, 89, 86, 20);
		contentPane.add(txtUni);
		txtUni.setColumns(10);
		
		lblValor = new JLabel("Valor");
		lblValor.setBounds(22, 123, 46, 14);
		contentPane.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setBounds(123, 120, 86, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		lblDataAtualizao = new JLabel("Data Atualiza\u00E7\u00E3o");
		lblDataAtualizao.setBounds(22, 153, 96, 14);
		contentPane.add(lblDataAtualizao);
		
		txtData = new JTextField();
		txtData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtData.setText("Ola");
			}
		});
		txtData.setBounds(123, 150, 86, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		lblAtivo = new JLabel("Ativo");
		lblAtivo.setBounds(22, 184, 46, 14);
		contentPane.add(lblAtivo);
		
		txtAtivo = new JTextField();
		txtAtivo.setBounds(123, 181, 86, 20);
		contentPane.add(txtAtivo);
		txtAtivo.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				try {
					
					conn.setAutoCommit(false);
					Mercadoria mercadoria = new Mercadoria();
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					boolean resp = (txtAtivo.getText().equalsIgnoreCase("sim")) ? true : false;
					
					java.util.Date utilDate = format.parse(txtData.getText());
			        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
					
					mercadoria.setCodigo(txtCodigo.getText());
					mercadoria.setDescricao(txtDesc.getText());
					mercadoria.setUnidade(txtUni.getText());
					mercadoria.setPreco(Double.parseDouble(txtValor.getText()));
					mercadoria.setData(sqlDate);
					mercadoria.setAtivo(resp);
					
					Statement myStmt = conn.createStatement();
					
					ResultSet checar = myStmt.executeQuery ("SELECT * FROM mercadoria WHERE codigo = '" + txtCodigo.getText() + "'");
					if (checar.next()) {
						JOptionPane.showMessageDialog(null, "O cadastro já existe");
						
					}
					else {
						
						int confirma = JOptionPane.showConfirmDialog(null, "Os dados estão corretos:\nCodigo de barras: " + txtCodigo.getText()
															+ "\nDescrição: " + txtDesc.getText()
															+ "\nUnidade: " + txtUni.getText()
															+ "\nPreço: " + txtValor.getText()
															+ "\nData: " + txtData.getText()
															+ "\nAtivo: " + txtAtivo.getText()
															, "Confirme", JOptionPane.YES_NO_OPTION);
						
							if (confirma == 0) {
								mercadoria.inserir(conn);
								conn.commit();
								JOptionPane.showMessageDialog(null, "Cadastro efetuado");
								
								txtCodigo.setText("");
								txtDesc.setText("");
								txtUni.setText("");
								txtValor.setText("");
								txtData.setText("");
								txtAtivo.setText("");
								
								mercadoria.setCodigo("");
								mercadoria.setDescricao("");
								mercadoria.setUnidade("");
								mercadoria.setPreco(0);
								format.parse("");
								resp = false;

								
								}

					}
			        

			      } 
			      catch(SQLException | ParseException erro){
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
		btnCadastrar.setBounds(353, 201, 105, 23);
		contentPane.add(btnCadastrar);
	}
}
