package cadastro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC", "root", "Alunos");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "N�o foi possivel estabelecer conex�o com o banco");
		}
		return null;
	}

}
