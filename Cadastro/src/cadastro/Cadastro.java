package cadastro;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {
		
		Connection conn = Conexao.getConnection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(22, 61, 46, 14);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(123, 58, 227, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblDesc = new JLabel("Descri\u00E7\u00E3o");
		lblDesc.setBounds(22, 92, 71, 14);
		contentPane.add(lblDesc);
		
		txtDesc = new JTextField();
		txtDesc.setBounds(123, 89, 227, 20);
		contentPane.add(txtDesc);
		txtDesc.setColumns(10);
		
		JLabel lblUnidades = new JLabel("Unidade(s)");
		lblUnidades.setBounds(22, 123, 71, 14);
		contentPane.add(lblUnidades);
		
		txtUni = new JTextField();
		txtUni.setBounds(123, 120, 86, 20);
		contentPane.add(txtUni);
		txtUni.setColumns(10);
		
		lblValor = new JLabel("Valor");
		lblValor.setBounds(22, 150, 46, 14);
		contentPane.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setBounds(123, 151, 86, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		lblDataAtualizao = new JLabel("Data Atualiza\u00E7\u00E3o");
		lblDataAtualizao.setBounds(22, 187, 105, 14);
		contentPane.add(lblDataAtualizao);
		
		txtData = new JTextField();
		txtData.setBounds(123, 184, 86, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		lblAtivo = new JLabel("Ativo");
		lblAtivo.setBounds(22, 219, 46, 14);
		contentPane.add(lblAtivo);
		
		txtAtivo = new JTextField();
		txtAtivo.setBounds(123, 216, 86, 20);
		contentPane.add(txtAtivo);
		txtAtivo.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = Conexao.getConnection();
				
				try {
					conn.setAutoCommit(false);
					Mercadoria mercadoria = new Mercadoria();
					
					mercadoria.setCodigo(txtCodigo.getText());
					mercadoria.setDescricao(txtDesc.getText());
					mercadoria.setUnidade(txtUni.getText());
					mercadoria.setPreco(Double.parseDouble(txtValor.getText()));
					mercadoria.setData(Date.valueOf(txtData.getText()));
					mercadoria.setAtivo(Boolean.parseBoolean(txtAtivo.getText()));
				
			        mercadoria.inserir(conn);
			         conn.commit();

			      } 
			      catch(SQLException erro){
			    	  System.out.println("Favor verificar, dados invalidos!");
			         if(conn != null){
			            try{
			               conn.rollback();
			            } 
			            catch(SQLException e1){
			            	System.out.println("Favor verificar, dados invalidos!");
			            }
			         }
			      } 
			      finally{
			         if(conn != null){
			            try{
			               conn.close();
			            } 
			            catch(SQLException e1){
			               System.out.println("Favor verificar, dados invalidos!");
			            }
			         }      
			      }
			   }

			
		});
		btnCadastrar.setBounds(438, 215, 105, 23);
		contentPane.add(btnCadastrar);
	}
}
