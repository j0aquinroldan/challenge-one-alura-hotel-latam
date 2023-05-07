package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;

import jdbc.factory.ConnectionFactory;
import jdbc.modelo.Usuario;

public class UsuarioDao {

	final Connection con;

	public UsuarioDao(Connection con) {
		this.con = con;
	}

	public boolean existe(Usuario u) {
		
		int size = 0;

		ResultSet rs;

		final Connection con = new ConnectionFactory().creaConexion();

		try {
			final PreparedStatement statement = con.prepareStatement(
					"SELECT * " + "FROM usuarios AS u" + " WHERE u.usuario = ?" + " AND u.contrasenha = ?");

			try (statement) {
				statement.setString(1, u.getId());
				statement.setString(2, u.getContrasenha());

				statement.execute();
				rs = statement.getResultSet();

				try (rs) {
					if (rs.next()) {
						size = rs.getRow();
					}
				}
			}
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return size ==1;
	}

}
