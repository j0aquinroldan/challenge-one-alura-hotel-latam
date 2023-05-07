package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.modelo.Reserva;

public class ReservaDao {
	
	private Connection con;

	public ReservaDao(Connection con) {
		this.con = con;
	}

	public void guardar(Reserva reserva) {
		
		try {
			PreparedStatement statement = con.prepareStatement(
					"INSERT INTO reservas(fecha_entrada, fecha_salida, valor, medio_pago) "
					+ "VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			
			try(statement){
				ejecutarRegistro(reserva, statement);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void ejecutarRegistro(Reserva reserva, PreparedStatement statement) throws SQLException {
		statement.setDate(1, reserva.getFechaE());
		statement.setDate(2, reserva.getFechaS());
		statement.setString(3, reserva.getValor());
		statement.setString(4, reserva.getFormaPago());
		
		statement.execute();
		
		final ResultSet resultSet = statement.getGeneratedKeys();

		try (resultSet) {
			while (resultSet.next()) {
				reserva.setId(resultSet.getInt(1));
				System.out.println(String.format("Fue insertado el producto %s", reserva));
			}
		}
	}

	
	
	

}
